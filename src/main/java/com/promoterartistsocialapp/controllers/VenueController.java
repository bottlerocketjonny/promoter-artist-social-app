package com.promoterartistsocialapp.controllers;

import com.promoterartistsocialapp.domains.Venue;
import com.promoterartistsocialapp.services.VenueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venue")
public class VenueController {

    private final VenueService service;

    public VenueController(VenueService service) {
        this.service = service;
    }

    // create venue
    @PostMapping("/createVenue")
    public Venue createVenue(@RequestBody Venue venue) {
        return service.createVenue(venue);
    }

    // get venue by id
    @GetMapping("/getVenueById/{id}")
    public Venue getVenueById(@PathVariable("id") Long id) {
        return service.getVenueById(id);
    }

    // get all venues
    @GetMapping("/getAllVenues")
    public List<Venue> getAllVenues() {
        return service.getAllVenues();
    }

    // update venue
    @PutMapping("/updateVenue/{id}")
    public Venue updateVenue(@RequestBody Venue venue, @PathVariable("id") Long id) {
        return service.updateVenue(id, venue);
    }

    // delete venue
    @DeleteMapping("/deleteVenue/{id}")
    public boolean deleteVenue(@PathVariable("id") Long id) {
        return service.deleteVenue(id);
    }
}
