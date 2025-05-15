package llc.cret.controller.admin;

import llc.cret.controller.dto.AccountDto;
import llc.cret.controller.dto.AccountRequestDto;
import llc.cret.controller.dto.AccountResponsetDto;
import llc.cret.repository.entity.Account;
import llc.cret.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

/**
 * 口座 Restコントローラ.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 口座検索.
     * @param body
     * @return 会社情報.
     */
    @RequestMapping(value = "/rest/account-query", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<AccountResponsetDto> doFind(@RequestBody AccountRequestDto body) {
        Account conditions = toEntity(body.getForm());
        List<Account> result = accountService.find(conditions);
        ArrayList<AccountDto> resultDto = new ArrayList<>();
        for (Account account : result) {
            resultDto.add(toDto(account));
        }
        AccountResponsetDto res = AccountResponsetDto.builder().result(resultDto).build();

        return ResponseEntity.ok(res);
    }

    private Account toEntity(AccountDto dto) {
        LocalDate openDate = null;
        if (!StringUtils.isEmpty(dto.getOpenDate())) {
            openDate = LocalDate.parse(dto.getOpenDate().trim(), DF);
        }
        return Account.builder()
                .branch(dto.getBranch())
                .account(dto.getAccount())
                .branchNm(dto.getBranchNm())
                .accountNm(dto.getAccountNm())
                .openDate(openDate)
                .status(dto.getStatus())
                .memo(dto.getMemo())
                .build();
    }

    private AccountDto toDto(Account entity) {
        LocalDate openDate = entity.getOpenDate();
        return AccountDto.builder()
                .accountSeq(entity.getAccountSeq().toString())
                .branch(entity.getBranch())
                .account(entity.getAccount())
                .branchNm(entity.getAccountNm())
                .accountNm(entity.getAccountNm())
                .openDate(isNull(openDate) ? "" : openDate.format(DF))
                .status(entity.getStatus())
                .memo(entity.getMemo())
                .build();
    }
}
