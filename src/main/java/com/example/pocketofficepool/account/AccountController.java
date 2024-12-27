package com.example.pocketofficepool.account;

import com.example.pocketofficepool.account.converter.AccountDtoToAccountConverter;
import com.example.pocketofficepool.account.converter.AccountToAccountDtoConverter;
import com.example.pocketofficepool.account.dto.AccountDto;
import com.example.pocketofficepool.system.Result;
import com.example.pocketofficepool.system.StatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${api.endpoint.base-url}/accounts")
public class AccountController {

    private final AccountService accountService;

    private final AccountDtoToAccountConverter accountDtoToAccountConverter;

    private final AccountToAccountDtoConverter accountToAccountDtoConverter;

    public AccountController(AccountService accountService, AccountDtoToAccountConverter accountDtoToAccountConverter, AccountToAccountDtoConverter accountToAccountDtoConverter) {
        this.accountService = accountService;
        this.accountDtoToAccountConverter = accountDtoToAccountConverter;
        this.accountToAccountDtoConverter = accountToAccountDtoConverter;
    }

    @PostMapping()
    public Result createAccount(@RequestBody AccountDto accountDto) {
        Account account = accountDtoToAccountConverter.convert(accountDto);
        Account savedAccount = this.accountService.save(account);
        AccountDto savedAccountDto = accountToAccountDtoConverter.convert(savedAccount);
        return new Result(true, StatusCode.SUCCESS, "Successfully created account", savedAccountDto);
    }

    @GetMapping("/{accountId}")
    public Result findAccount(@PathVariable UUID accountId) {
        Account account = this.accountService.findById(accountId);
        AccountDto accountDto = accountToAccountDtoConverter.convert(account);
        return new Result(true, StatusCode.SUCCESS, "Successfully found account", accountDto);
    }

    @PutMapping("/{accountId}")
    public Result updateAccount(UUID accountId, @RequestBody AccountDto accountDto) {
        Account account = accountDtoToAccountConverter.convert(accountDto);
        assert account != null;
        Account updatedAccount = this.accountService.update(accountId, account);
        AccountDto updatedAccountDto = accountToAccountDtoConverter.convert(updatedAccount);
        return new Result(true, StatusCode.SUCCESS, "Successfully updated account", updatedAccountDto);
    }

    @DeleteMapping
    public Result deleteAccount(UUID accountId) {
        this.accountService.delete(accountId);
        return new Result(true, StatusCode.SUCCESS, "Successfully deleted account");
    }

}
