package com.example.pocketofficepool.account;

import com.example.pocketofficepool.system.Result;
import com.example.pocketofficepool.system.StatusCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint.base-url}/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public Result createAccount(Account account) {
        this.accountService.save(account);
        return new Result(true, StatusCode.SUCCESS, "Successfully created account", account);
    }

}
