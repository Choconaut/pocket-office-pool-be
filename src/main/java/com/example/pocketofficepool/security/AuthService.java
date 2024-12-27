package com.example.pocketofficepool.security;

import com.example.pocketofficepool.accountuser.AccountUser;
import com.example.pocketofficepool.accountuser.AccountUserPrincipal;
import com.example.pocketofficepool.accountuser.converter.UserToUserDtoConverter;
import com.example.pocketofficepool.accountuser.dto.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final JwtProvider jwtProvider;

    private final UserToUserDtoConverter userToUserDtoConverter;

    public AuthService(JwtProvider jwtProvider, UserToUserDtoConverter userToUserDtoConverter) {
        this.jwtProvider = jwtProvider;
        this.userToUserDtoConverter = userToUserDtoConverter;
    }

    public Map<String, Object> createLoginInfo(Authentication authentication) {
        // Create User info
        AccountUserPrincipal principal = (AccountUserPrincipal)authentication.getPrincipal();
        AccountUser user = principal.getAccountUser();
        UserDto userDto = this.userToUserDtoConverter.convert(user);

        // Create JWT
        String token = this.jwtProvider.createToken(authentication);

        Map<String, Object> loginResultMap = new HashMap<>();

        loginResultMap.put("userInfo", userDto);
        loginResultMap.put("token", token);

        return loginResultMap;
    }
}
