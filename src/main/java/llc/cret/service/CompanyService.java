package llc.cret.service;

import jakarta.transaction.Transactional;
import llc.cret.external.EmailComponent;
import llc.cret.repository.CompanyRepository;
import llc.cret.repository.entity.Company;
import llc.cret.repository.specication.CompanySpeciification;
import llc.cret.util.Password;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {
    private final CompanySpeciification companySpeciification;
    private final CompanyRepository companyRepository;
    private final EmailComponent emailComponent;

    /**
     * 会社登録.
     * @param company 会社.
     * @return 更新後会社.
     */
    public Company regist(Company company) {
        if (StringUtils.isEmpty(company.getCompanyCd())) {
            String preFix = RandomStringUtils.randomAlphabetic(3).toUpperCase();
            company.setCompanyCd(String.format("%s%05d", preFix, companyRepository.getSequence()));
            company.setPassword(Password.generate());
        }
        companyRepository.save(company);
        // 登録会社へのメール通知
        emailComponent.send(company.getEmail(), "ご登録完了のお知らせ", createMailContents(company));

        return company;
    }

    /**
     * 会社登録.
     * @param company 会社.
     * @return 更新後会社.
     */
    public Company update(Company company) {

        Optional<Company> companyOpt = companyRepository.findById(company.getCompanyCd());
        if (companyOpt.isEmpty()) {
            throw new RuntimeException("No Data");
        }
        company.setPassword(companyOpt.get().getPassword());
        companyRepository.save(company);

        return company;
    }

    /**
     * 会社削除.
     * @param company 会社.
     * @return 更新後会社.
     */
    public void remove(Company company) {
        companyRepository.deleteById(company.getCompanyCd());
    }

    /**
     * 会社検索.
     * @param company 会社.
     * @return 検索結果.
     */
    public List<Company> find(Company company) {
        return companyRepository.findAll(companySpeciification.createConditions(company));
    }

    /**
     * 登録完了メール文面の作成.
     * @param company 会社情報
     * @return メール文面
     */
    private String createMailContents(Company company) {
        StringBuilder msg = new StringBuilder();
        msg.append(String.format("%s 様\r\n", company.getCompanyName()));
        msg.append("登録が完了しましたのでお知らせいたします。\r\n");
        msg.append(String.format("会社コード：%s\r\n",company.getCompanyCd()));
        msg.append(String.format("パスワード：%s\r\n",company.getPassword()));
        return msg.toString();
    }

}
