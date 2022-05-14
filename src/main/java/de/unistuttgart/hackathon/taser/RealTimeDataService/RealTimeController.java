package de.unistuttgart.hackathon.taser.RealTimeDataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPooled;

@RestController
public class RealTimeController {

    @Value("${redis.location}")
    private String redisLocation;

    /**
     * Define new pool based on location in applications.properties
     */
    JedisPooled pool = new JedisPooled(redisLocation, 6379);

    // get Logger for this class
    private static final Logger LOGGER = LoggerFactory.getLogger(RealTimeController.class);


    /**
     * Offers Stats for a specified room
     *
     * If the specified room does not exist, this will return empty results, but doesn't fail.
     */
    @GetMapping("/stats/{roomIdentifier}")
    public String getStatsForRoom(@PathVariable final String roomIdentifier){
        LOGGER.info("Getting info for room " + roomIdentifier);
        return pool.get(roomIdentifier);
    }
}
