package com.example.pocketofficepool.accountuser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * This class is used by spring security to authenticate and authorize a user.
 * Users can only be authenticated if they are not marked as deleted.
 */
public class AccountUserPrincipal implements UserDetails {

    private AccountUser accountUser;

    public AccountUserPrincipal(AccountUser accountUser) {
        this.accountUser = accountUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convert a user's roles from space-delimited string to a list of SimpleGrantedAuthority objects.
        // E.g., john's roles are stored in a string like "admin user moderator", we need to convert it to a list of GrantedAuthority.
        // Before conversion, we need to add this "ROLE_" prefix to each role name.

        return List.of(new SimpleGrantedAuthority("ROLE_" + this.accountUser.getRole().name()));
    }

    @Override
    public String getPassword() {
        return this.accountUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.accountUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //Users are disabled if deleted_At is not null
    @Override
    public boolean isEnabled() {
        return Optional.ofNullable(this.accountUser.getDeletedAt())
                .isEmpty();
    }

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }
}
