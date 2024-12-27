package com.example.pocketofficepool.accountuser.converter;

import com.example.pocketofficepool.accountuser.AccountUser;
import com.example.pocketofficepool.accountuser.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, AccountUser> {
    @Override
    public AccountUser convert(UserDto source) {
        AccountUser accountUser = new AccountUser();
        accountUser.setUsername(source.username());
        accountUser.setEmail(source.email());
        accountUser.setRole(source.role());
        return accountUser;
    }
}
