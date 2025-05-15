package llc.cret.service;

import jakarta.transaction.Transactional;
import llc.cret.repository.AccountRepository;
import llc.cret.repository.entity.Account;
import llc.cret.repository.specication.AccountSpeciification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountSpeciification accountSpeciification;
    private final AccountRepository accountRepository;

    /**
     * 口座検索.
     * @param conditions 検索条件
     * @return 検索結果
     */
    public List<Account> find(Account conditions) {
        return accountRepository.findAll(accountSpeciification.createConditions(conditions));
    }
}
