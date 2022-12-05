package com.promoterartistsocialapp.domains;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listingId;

    @ManyToOne
    private Venue venue;

    private LocalDate listingDate;
    private double listingEntryCost;
    private double listingBaseOffer;
    private String listingLineup;
}
