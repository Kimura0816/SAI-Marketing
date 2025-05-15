package llc.cret.controller.admin;

import llc.cret.controller.dto.AccountDto;
import llc.cret.controller.dto.AccountImportResponseDto;
import llc.cret.controller.dto.ImportResultDto;
import llc.cret.repository.entity.Account;
import llc.cret.service.AccountImportService;
import llc.cret.service.dto.AccountImportResult;
import llc.cret.util.CsvUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 口座 Restコントローラ.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountImportController {
    private final AccountImportService accountImportService;

    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @PostMapping("import-account")
    public ResponseEntity<AccountImportResponseDto> doImport(
            @RequestParam("uploadFile") MultipartFile multipartFile){

        if (multipartFile.isEmpty()) {
            log.error("multipartFile isEmpty");
            return ResponseEntity.badRequest().body(null);
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream(), "Shift-JIS"));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().body(null);
        }

        List<CSVRecord> importData = CsvUtil.parse(reader);

        AccountImportResult result = accountImportService.importAccount(importData);

        // 応答データ設定
        AccountImportResponseDto res = AccountImportResponseDto.builder()
                .imported(toDto(result.getImported()))
                .rejected(createResult(result.getRejectData()))
                .build();

        return ResponseEntity.ok(res);
    }

    private List<ImportResultDto> createResult(List<CSVRecord> data) {
        List<ImportResultDto> result = new ArrayList<>();
        for (CSVRecord rec : data) {
            result.add(
                    ImportResultDto.builder()
                            .recordNumber(rec.getRecordNumber())
                            .values(rec.values())
                            .build()
            );
        }
        return result;
    }

    private List<AccountDto> toDto(List<Account> entities) {
        List<AccountDto> accountDtos = new ArrayList<>();
        for(Account account : entities) {
            accountDtos.add(AccountDto.builder()
                    .accountSeq(account.getAccountSeq().toString())
                    .branch(account.getBranch())
                    .branchNm(account.getBranchNm())
                    .account(account.getAccount())
                    .accountNm(account.getAccountNm())
                    .openDate(account.getOpenDate().format(DF))
                    .status(account.getStatus())
                    .memo(account.getMemo())
                    .build());
        }
        return accountDtos;
    }

}
