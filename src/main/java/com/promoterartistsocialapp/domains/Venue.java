package com.promoterartistsocialapp.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;

    @OneToMany(mappedBy = "venue", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Listing> venueListings;

    private String venueName;
    private String venueLocation;
    private int venueCapacity;
    private String venueTechSpec;
    private String venueImagePath;
}
