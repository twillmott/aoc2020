package io.twillmott.model;

import lombok.Data;

@Data
public class Passport {
    private final Integer birthYear;
    private final Integer issueYear;
    private final Integer expirationYear;
    private final String height;
    private final String hairColor;
    private final String eyeColor;
    private final String passportId;
    private final String countryId;
}
