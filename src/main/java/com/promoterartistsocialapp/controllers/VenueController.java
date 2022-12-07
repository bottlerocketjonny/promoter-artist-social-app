package com.promoterartistsocialapp.controllers;

import com.promoterartistsocialapp.domains.Venue;
import com.promoterartistsocialapp.domains.VenueDTO;
import com.promoterartistsocialapp.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venue")
public class VenueController {

    @Autowired
    VenueService service;

    // create venue
    @PostMapping("/createVenue")
    public VenueDTO createVenue(@RequestBody Venue venue) {
        return service.createVenue(venue);
    }

    // get venue by id
    @GetMapping("/getVenueById/{id}")
    public VenueDTO getVenueById(@PathVariable("id") Long id) {
        return service.getVenueById(id);
    }

    // get all venues
    @GetMapping("/getAllVenues")
    public List<VenueDTO> getAllVenues() {
        return service.getAllVenues();
    }

    // update venue
    @PutMapping("/updateVenue/{id}")
    public VenueDTO updateVenue(@RequestBody Venue venue, @PathVariable("id") Long id) {
        return service.updateVenue(id, venue);
    }

    // delete venue
    @DeleteMapping("/deleteVenue/{id}")
    public boolean deleteVenue(@PathVariable("id") Long id) {
        return service.deleteVenue(id);
    }
}
