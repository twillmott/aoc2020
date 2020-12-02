package io.twillmott.service;

import io.twillmott.model.Password;

public class PasswordService {

    /**
     * Map a string input to a password
     */
    public static Password mapFromString(String input) {

        String[] splitInput = input.split(" ");
        int minValue = Integer.valueOf(splitInput[0].split("-")[0]);
        int maxValue = Integer.valueOf(splitInput[0].split("-")[1]);
        String policyLetter = splitInput[1].split(":")[0];
        String password = splitInput[2];

        return new Password(password, policyLetter, minValue, maxValue);
    }

    /**
     * Tests if a password meets its policy for the number of occurrences of the policy letter.
     */
    public static boolean isValidCount(Password password) {

        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = password.getPassword().indexOf(password.getPolicyLetter(), lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += password.getPolicyLetter().length();
            }
        }

        return count >= password.getMinAllowed() && count <= password.getMaxAllowed();
    }

    /**
     * Tests if a password meets its policy of having the policy letter in the position of either the min or max value.
     */
    public static boolean isValidPosition(Password password) {
        char policyLetter = password.getPolicyLetter().charAt(0);

        if (password.getMinAllowed() > password.getPassword().length()) {
            return false;
        } else if (password.getPassword().length() < password.getMaxAllowed()) {
            return policyLetter == password.getPassword().charAt(password.getMinAllowed() - 1);
        } else {
            boolean minMatch = policyLetter == password.getPassword().charAt(password.getMinAllowed() - 1);
            boolean maxMatch = policyLetter == password.getPassword().charAt(password.getMaxAllowed() - 1);

            return minMatch ^ maxMatch;
        }
    }



}
