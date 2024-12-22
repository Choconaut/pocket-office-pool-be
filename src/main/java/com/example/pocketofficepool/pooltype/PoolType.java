package com.example.pocketofficepool.pooltype;

import com.example.pocketofficepool.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class PoolType extends BaseEntity {
    private String name;
    private String apiEndpoint;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public void setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }
}
