package com.example.pocketofficepool.security;

import com.example.pocketofficepool.system.Result;
import com.example.pocketofficepool.system.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is a controller class that handles the login request. It will return the user information
 * and the JSON Web Token. The JWT is created by the AuthService class.
 */
@RestController
@RequestMapping("${api.endpoint.base-url}/users")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Result getLoginInfo(Authentication authentication) {
        LOGGER.debug("Authenticated user: '{}'", authentication.getName());
        return new Result(true,
                StatusCode.SUCCESS,
                "User Info and JSON Web Token",
                this.authService.createLoginInfo(authentication));
    }

}