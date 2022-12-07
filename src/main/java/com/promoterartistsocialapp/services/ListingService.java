package com.promoterartistsocialapp.services;

import com.promoterartistsocialapp.domains.Listing;
import com.promoterartistsocialapp.domains.ListingDTO;
import com.promoterartistsocialapp.domains.Venue;
import com.promoterartistsocialapp.domains.VenueDTO;
import com.promoterartistsocialapp.exceptions.ListingNotFoundException;
import com.promoterartistsocialapp.exceptions.VenueNotFoundException;
import com.promoterartistsocialapp.repositories.ListingRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListingService {

    @Autowired
    ListingRepo repo;

    @Autowired
    ModelMapper mapper;

    // mapToDTO
    private ListingDTO mapToDTO(Listing listing) {
        return this.mapper.map(listing, ListingDTO.class);
    }

    // create listing
    public ListingDTO createListing(Listing listing) {
        Listing newListing = this.repo.save(listing);
        return this.mapToDTO(newListing);
    }

    // get listing by id
    public ListingDTO getListingById(Long id) throws ListingNotFoundException {
        Listing foundListing = this.repo.findById(id).orElseThrow(VenueNotFoundException::new);
        return this.mapToDTO(foundListing);
    }

    // get all listings
    public List<ListingDTO> getAllListings() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // update listing by id
    public ListingDTO updateListing(Long id, Listing listing) {
        Listing listingToUpdate = repo.findById(id).orElse(new Listing());

        listingToUpdate.setListingDate(listing.getListingDate());
        listingToUpdate.setListingLineup(listing.getListingLineup());
        listingToUpdate.setListingBaseOffer(listing.getListingBaseOffer());
        listingToUpdate.setListingEntryCost(listing.getListingEntryCost());

        Listing updatedListing = repo.save(listingToUpdate);
        return this.mapToDTO(updatedListing);
    }

    // delete listing by id
    public boolean deleteListing(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
