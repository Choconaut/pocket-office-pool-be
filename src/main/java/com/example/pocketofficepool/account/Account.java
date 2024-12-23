package com.example.pocketofficepool.account;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.Status;
import com.example.pocketofficepool.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Account extends BaseEntity {

    @OneToMany(mappedBy = "account")
    private List<User> users;

    private Status status;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
