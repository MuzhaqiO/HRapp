package com.internship.HRapp.configuration.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -809187909192046844L;
    private final String jwtToken;
}
