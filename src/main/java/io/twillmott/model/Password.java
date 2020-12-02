package io.twillmott.model;

import lombok.Data;

@Data
public class Password {
    private final String password;
    // The letter which the password must contain
    private final String policyLetter;
    // Minimum occurrences of the policyLetter
    private final int minAllowed;
    // Maximum occurrences of the policyLetter
    private final int maxAllowed;
}
