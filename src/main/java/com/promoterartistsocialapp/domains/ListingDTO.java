package com.promoterartistsocialapp.domains;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListingDTO {
    private Long listingId;
    private LocalDate listingDate;
    private double listingEntryCost;
    private double listingBaseOffer;
    private String listingLineup;
}
