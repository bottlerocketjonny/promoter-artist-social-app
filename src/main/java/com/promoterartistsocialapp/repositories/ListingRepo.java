package com.promoterartistsocialapp.repositories;

import com.promoterartistsocialapp.domains.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepo extends JpaRepository<Listing, Long> {

}
