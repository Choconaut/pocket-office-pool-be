package com.example.pocketofficepool.security;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriTemplate;

import java.util.Map;
import java.util.function.Supplier;

@Component
public class UserRequestAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    private static final UriTemplate USER_URI_TEMPLATE = new UriTemplate("/users/{username}");

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authenticationSupplier, RequestAuthorizationContext context) {
        // Extract the username from the request URI: /users/{username}
        Map<String, String> uriVariables = USER_URI_TEMPLATE.match(context.getRequest().getRequestURI());
        String requestUriUsername = uriVariables.get("username");

        // Extract the username from the authentication object, which is a JWT object
        Authentication authentication = authenticationSupplier.get();
        String jwtUsername = authentication.getName();

        // Compare two usernames
        boolean usernamesMatch = requestUriUsername != null && requestUriUsername.equals(jwtUsername);

        // Check if user has role "ROLE_admin"
        boolean hasAdminRole = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_admin"));

        // Check if user has role "ROLE_user"
        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_user"));

        return new AuthorizationDecision(hasAdminRole || (hasUserRole && usernamesMatch));
    }
}
