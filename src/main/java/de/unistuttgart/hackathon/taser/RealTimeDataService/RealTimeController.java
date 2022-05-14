package de.unistuttgart.hackathon.taser.RealTimeDataService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealTimeController {

    /**
     * Offers Stats for a specified room
     *
     * If the specified room does not exist, this will return empty results, but doesn't fail.
     */
    @GetMapping("/stats/{roomIdentifier}")
    public void getStatsForRoom(@PathVariable final String roomIdentifier){

    }
}
