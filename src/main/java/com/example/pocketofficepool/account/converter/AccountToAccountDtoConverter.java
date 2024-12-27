package com.example.pocketofficepool.account.converter;

import com.example.pocketofficepool.account.Account;
import com.example.pocketofficepool.account.dto.AccountDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountToAccountDtoConverter implements Converter<Account, AccountDto> {
    @Override
    public AccountDto convert(Account source) {
        return new AccountDto(
                source.getName()
        );
    }
}
