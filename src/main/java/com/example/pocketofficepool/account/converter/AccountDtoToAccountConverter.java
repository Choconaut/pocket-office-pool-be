package com.example.pocketofficepool.account.converter;

import com.example.pocketofficepool.account.Account;
import com.example.pocketofficepool.account.dto.AccountDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoToAccountConverter implements Converter<AccountDto, Account> {

    @Override
    public Account convert(AccountDto source) {
        Account account = new Account();
        account.setName(source.name());
        return account;
    }

}
