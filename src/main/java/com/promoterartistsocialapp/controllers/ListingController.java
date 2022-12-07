package com.promoterartistsocialapp.controllers;

import com.promoterartistsocialapp.domains.Listing;
import com.promoterartistsocialapp.domains.ListingDTO;
import com.promoterartistsocialapp.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listing")
public class ListingController {

    @Autowired
    ListingService service;

    // create listing
    @PostMapping("/createListing")
    public ListingDTO createListing(@RequestBody Listing listing) {
        return service.createListing(listing);
    }

    // get listing by id
    @GetMapping("/getListingById/{id}")
    public ListingDTO getListingById(@PathVariable("id") Long id) {
        return service.getListingById(id);
    }

    // get all listing
    @GetMapping("/getAllListings")
    public List<ListingDTO> getAllListings() {
        return service.getAllListings();
    }

    // update listing
    @PutMapping("/updateListing/{id}")
    public ListingDTO updateListing(@RequestBody Listing listing, @PathVariable("id") Long id) {
        return service.updateListing(id, listing);
    }

    // delete listing
    @DeleteMapping("/deleteListing/{id}")
    public boolean deleteListing(@PathVariable("id") Long id) {
        return service.deleteListing(id);
    }
}
