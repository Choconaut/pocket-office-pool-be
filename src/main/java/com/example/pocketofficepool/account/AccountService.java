package com.example.pocketofficepool.account;

import com.example.pocketofficepool.system.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
@Transactional
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findById(UUID accountId) {
        return this.accountRepository.findById(accountId)
                .orElseThrow(() -> new ObjectNotFoundException("account", accountId));
    }

    public Account save(Account account) {
        return this.accountRepository.save(account);
    }

    public Account update(UUID accountId, Account update) {
        Account account = this.findById(accountId);

        account.setName(update.getName());
        account.setStatus(update.getStatus());
        return this.save(account);
    }

    public Account delete(UUID accountId) {
        Account account = this.findById(accountId);

        account.setDeletedAt(ZonedDateTime.now());
        return this.accountRepository.save(account);
    }
}
