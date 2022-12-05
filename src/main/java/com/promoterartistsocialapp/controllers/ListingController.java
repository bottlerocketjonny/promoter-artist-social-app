package com.promoterartistsocialapp.controllers;

import com.promoterartistsocialapp.domains.Listing;
import com.promoterartistsocialapp.services.ListingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listing")
public class ListingController {

    private final ListingService service;

    public ListingController(ListingService service) {
        this.service = service;
    }

    // create listing
    @PostMapping("/createListing")
    public Listing createListing(@RequestBody Listing listing) {
        return service.createListing(listing);
    }

    // get listing by id
    @GetMapping("/getListingById/{id}")
    public Listing getListingById(@PathVariable("id") Long id) {
        return service.getListingById(id);
    }

    // get all listing
    @GetMapping("/getAllListings")
    public List<Listing> getAllListings() {
        return service.getAllListings();
    }

    // update listing
    @PutMapping("/updateListing/{id}")
    public Listing updateListing(@RequestBody Listing listing, @PathVariable("id") Long id) {
        return service.updateListing(id, listing);
    }

    // delete listing
    @DeleteMapping("/deleteListing/{id}")
    public boolean deleteListing(@PathVariable("id") Long id) {
        return service.deleteListing(id);
    }
}
