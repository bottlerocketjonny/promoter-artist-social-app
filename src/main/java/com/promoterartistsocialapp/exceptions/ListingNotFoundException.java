package com.promoterartistsocialapp.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Listing not found! Please add a listing.")
public class ListingNotFoundException extends EntityNotFoundException {
}
