package com.promoterartistsocialapp.domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;

    @OneToMany(mappedBy = "venue", cascade = {CascadeType.REMOVE})
    private List<Listing> venueListings;

    private String venueName;
    private String venueLocation;
    private int venueCapacity;
    private String venueTechSpec;
    private String venueImagePath;
}
