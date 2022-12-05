package com.promoterartistsocialapp.repositories;

import com.promoterartistsocialapp.domains.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepo extends JpaRepository<Venue, Long> {

}
