package com.promoterartistsocialapp.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Venue not found! Please add a venue.")
public class VenueNotFoundException extends EntityNotFoundException {
}
