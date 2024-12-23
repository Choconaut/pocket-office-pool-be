package com.example.pocketofficepool.user;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.Role;
import com.example.pocketofficepool.account.Account;
import com.example.pocketofficepool.pick.Pick;
import com.example.pocketofficepool.pool.Pool;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User extends BaseEntity {

    @ManyToOne
    private Account account;

    private String username;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "participant")
    private List<Pick> picks;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "owner")
    private List<Pool> ownedPools;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Pick> getPicks() {
        return picks;
    }

    public void setPicks(List<Pick> picks) {
        this.picks = picks;
    }

    public List<Pool> getOwnedPools() {
        return ownedPools;
    }

    public void setOwnedPools(List<Pool> ownedPools) {
        this.ownedPools = ownedPools;
    }
}
