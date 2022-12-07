package com.promoterartistsocialapp.services;

import com.promoterartistsocialapp.domains.Venue;
import com.promoterartistsocialapp.domains.VenueDTO;
import com.promoterartistsocialapp.exceptions.VenueNotFoundException;
import com.promoterartistsocialapp.repositories.VenueRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueService {

   @Autowired
   VenueRepo repo;

   @Autowired
   ModelMapper mapper;

   // mapToDTO
    private VenueDTO mapToDTO(Venue venue) {
        return this.mapper.map(venue, VenueDTO.class);
    }

    // create venue
    public VenueDTO createVenue(Venue venue) {
        Venue newVenue = this.repo.save(venue);
        return this.mapToDTO(newVenue);
    }

    // get venue by id
    public VenueDTO getVenueById(Long id) throws VenueNotFoundException {
        Venue foundVenue = this.repo.findById(id).orElseThrow(VenueNotFoundException::new);
        return this.mapToDTO(foundVenue);
    }

    // get all venues
    public List<VenueDTO> getAllVenues() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // update venue by id
    public VenueDTO updateVenue(Long id, Venue venue) {
        Venue venueToUpdate = repo.findById(id).orElse(new Venue());

        venueToUpdate.setVenueName(venue.getVenueName());
        venueToUpdate.setVenueCapacity(venue.getVenueCapacity());
        venueToUpdate.setVenueLocation(venue.getVenueLocation());
        venueToUpdate.setVenueListings(venue.getVenueListings());
        venueToUpdate.setVenueImagePath(venue.getVenueImagePath());
        venueToUpdate.setVenueTechSpec(venue.getVenueTechSpec());

        Venue updatedVenue = repo.save(venueToUpdate);
        return this.mapToDTO(updatedVenue);
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
