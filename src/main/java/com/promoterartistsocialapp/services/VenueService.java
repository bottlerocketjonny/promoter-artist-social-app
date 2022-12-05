package com.promoterartistsocialapp.services;

import com.promoterartistsocialapp.domains.Venue;
import com.promoterartistsocialapp.exceptions.VenueNotFoundException;
import com.promoterartistsocialapp.repositories.VenueRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VenueService {

    private final VenueRepo repo;

    public VenueService(VenueRepo repo) {
        this.repo = repo;
    }

    // create venue
    public Venue createVenue(Venue venue) {
        return this.repo.save(venue);
    }

    // get venue by id
    public Venue getVenueById(Long id) throws VenueNotFoundException {
        return this.repo.findById(id).orElseThrow(VenueNotFoundException::new);
    }

    // get all venues
    public List<Venue> getAllVenues() {
        List<Venue> allVenues = new ArrayList<>();
        allVenues.addAll(repo.findAll());
        return allVenues;
    }

    // update venue by id
    public Venue updateVenue(Long id, Venue venue) {
        Venue venueToUpdate = repo.findById(id).orElse(new Venue());

        venueToUpdate.setVenueName(venue.getVenueName());
        venueToUpdate.setVenueCapacity(venue.getVenueCapacity());
        venueToUpdate.setVenueLocation(venue.getVenueLocation());
        venueToUpdate.setVenueListings(venue.getVenueListings());
        venueToUpdate.setVenueImagePath(venue.getVenueImagePath());
        venueToUpdate.setVenueTechSpec(venue.getVenueTechSpec());

        return repo.save(venueToUpdate);
    }

    // delete venue by id
    public boolean deleteVenue(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
