package com.example.pocketofficepool.account;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.Status;
import com.example.pocketofficepool.accountuser.AccountUser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Account extends BaseEntity {
    String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "account")
    private List<AccountUser> accountUsers;

    private Status status;

    public List<AccountUser> getUsers() {
        return accountUsers;
    }

    public void setUsers(List<AccountUser> accountUsers) {
        this.accountUsers = accountUsers;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
