package llc.cret.service;

import jakarta.transaction.Transactional;
import llc.cret.constants.AuthConst;
import llc.cret.constants.SystemConst;
import llc.cret.repository.CompanyRepository;
import llc.cret.repository.SystemConfigtRepository;
import llc.cret.repository.entity.Company;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * サインイン サービス
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SignInService {
    private final SystemConfigtRepository systemConfigtRepository;
    private final CompanyRepository companyRepository;

    /**
     * サインイン.
     * @param companyCd 会社CD
     * @param pass パスワード
     * @return 会社情報
     */
    public Company signIn(String companyCd, String pass) {

        // システム定義の取得
        Map<String, String> sysCong = systemConfigtRepository.getMap();
        String adminId = sysCong.get(SystemConst.ADMIN_ID);
        String adminPass = sysCong.get(SystemConst.ADMIN_PASS);
        // システム管理者かのチェック
        if (StringUtils.equals(adminId,companyCd) && StringUtils.equals(adminPass,pass)) {
            return Company.builder()
                    .auth(AuthConst.ADMIN)
                    .companyCd(adminId)
                    .companyName(SystemConst.ADMIN_NM)
                    .email(sysCong.get(SystemConst.MAIL_FROM))
                    .build();
        }
        return companyRepository.findByCompanyCdAndPassword(companyCd, pass).orElse(null);
    }
}
