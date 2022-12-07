package com.promoterartistsocialapp.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VenueDTO {
    private Long venueId;
    private List<ListingDTO> venueListings;
    private String venueName;
    private String venueLocation;
    private int venueCapacity;
    private String venueTechSpec;
    private String venueImagePath;
}
