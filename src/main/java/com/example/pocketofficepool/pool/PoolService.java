package com.example.pocketofficepool.pool;

import com.example.pocketofficepool.Status;
import com.example.pocketofficepool.pooltype.PoolType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class PoolService {

    @Autowired
    private PoolRepository poolRepository;

    @Scheduled(fixedRate = 60000) //Runs every 60 seconds
    public void updatePoolStatus() {
        List<Pool> pools = poolRepository.findAll();
        ZonedDateTime now = ZonedDateTime.now();

        for (Pool pool : pools) {
            if (pool.getOpenTime().isBefore(now) && pool.getCloseTime().isAfter(now)) {
                pool.setStatus(Status.ACTIVE);
            } else if (pool.getCloseTime().isBefore(now)) {
                pool.setStatus(Status.INACTIVE);
            } else {
                pool.setStatus(Status.SCHEDULED);
            }
            poolRepository.save(pool);
        }
    }

    public void fetchGameData(PoolType poolType) {
        //fetch game data from external API
    }

}
