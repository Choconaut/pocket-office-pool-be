package com.example.pocketofficepool.pooltype;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.pool.Pool;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class PoolType extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "poolType")
    private List<Pool> pools;

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

    public List<Pool> getPools() {
        return pools;
    }

    public void setPools(List<Pool> pools) {
        this.pools = pools;
    }
}
