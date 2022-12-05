package com.promoterartistsocialapp.services;

import com.promoterartistsocialapp.domains.Listing;
import com.promoterartistsocialapp.exceptions.ListingNotFoundException;
import com.promoterartistsocialapp.repositories.ListingRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListingService {

    private final ListingRepo repo;

    public ListingService(ListingRepo repo) {
        this.repo = repo;
    }

    // create listing
    public Listing createListing(Listing listing) {
        return this.repo.save(listing);
    }

    // get listing by id
    public Listing getListingById(Long id) throws ListingNotFoundException {
        return this.repo.findById(id).orElseThrow(ListingNotFoundException::new);
    }

    // get all listings
    public List<Listing> getAllListings() {
        List<Listing> allListings = new ArrayList<>();
        allListings.addAll(repo.findAll());
        return allListings;
    }

    // update listing by id
    public Listing updateListing(Long id, Listing listing) {
        Listing listingToUpdate = repo.findById(id).orElse(new Listing());

        listingToUpdate.setListingDate(listing.getListingDate());
        listingToUpdate.setListingLineup(listing.getListingLineup());
        listingToUpdate.setListingBaseOffer(listing.getListingBaseOffer());
        listingToUpdate.setListingEntryCost(listing.getListingEntryCost());

        return repo.save(listingToUpdate);
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
