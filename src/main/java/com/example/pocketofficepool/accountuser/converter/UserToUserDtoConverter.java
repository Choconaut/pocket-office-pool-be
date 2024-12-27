package com.example.pocketofficepool.accountuser.converter;

import com.example.pocketofficepool.accountuser.AccountUser;
import com.example.pocketofficepool.accountuser.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<AccountUser, UserDto> {
    @Override
    public UserDto convert(AccountUser source) {
        return new UserDto(
                source.getUsername(),
                source.getEmail(),
                source.getRole()
        );
    }
}
