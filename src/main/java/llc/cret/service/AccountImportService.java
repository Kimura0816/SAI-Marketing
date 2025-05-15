package llc.cret.service;

import jakarta.transaction.Transactional;
import llc.cret.repository.AccountRepository;
import llc.cret.repository.entity.Account;
import llc.cret.repository.entity.EntityValueConst;
import llc.cret.repository.specication.AccountSpeciification;
import llc.cret.service.dto.AccountImportResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AccountImportService {
    private final AccountSpeciification accountSpeciification;
    private final AccountRepository accountRepository;

    /**
     * 口座インポート.
     * @param csvData インポートファイル
     * @return 取込結果
     */
    public AccountImportResult importAccount(List<CSVRecord> csvData) {
        /** 取込データ */
        List<CSVRecord> importData = new LinkedList<>();
        /** リジェクトデータ */
        List<CSVRecord> rejectData = new LinkedList<>();

        // 口座生成
        List<Account> accounts = new ArrayList<>();
        for (CSVRecord rec : csvData) {
            String[] values = rec.values();
            if (values.length != 7) {
                rejectData.add(rec);
                continue;
            }
            String branch = values[0].trim();
            String account = values[2].trim();
            List<Account> exists = accountRepository.findByBranchAndAccountAndStatusNot(
                    branch, account, EntityValueConst.ACCOUNT_STATUS_USED);
            if (!CollectionUtils.isEmpty(exists)) {
                rejectData.add(rec);
                continue;
            }
            String[] date = values[4].split("/");
            if (date.length != 3) {
                rejectData.add(rec);
                continue;
            }
            accounts.add(Account.builder()
                    .branch(branch)
                    .branchNm(values[1].trim())
                    .account(account)
                    .accountNm(values[3].trim())
                    .openDate(LocalDate.of(parseInt(date[0]), parseInt(date[1]), parseInt(date[2])))
                    .status(EntityValueConst.ACCOUNT_STATUS_UNUSED)
                    .memo(values[6].trim())
                    .build());
        }
        return AccountImportResult.builder()
                .imported(accountRepository.saveAll(accounts))
                .rejectData(rejectData)
                .build();
    }
}
