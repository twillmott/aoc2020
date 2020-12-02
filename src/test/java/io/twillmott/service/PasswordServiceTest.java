package io.twillmott.service;

import io.twillmott.model.Password;
import junit.framework.TestCase;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordServiceTest extends TestCase {

    public void testMap() {
        String input = "18-100 l: lrmlzpllllltlrblgcld";

        Password password = PasswordService.mapFromString(input);

        assertThat(password.getPassword()).isEqualTo("lrmlzpllllltlrblgcld");
        assertThat(password.getPolicyLetter()).isEqualTo("l");
        assertThat(password.getMinAllowed()).isEqualTo(18);
        assertThat(password.getMaxAllowed()).isEqualTo(100);
    }

    public void testIsValidCount_isTrue() {
        Password password = new Password("aaaaa", "a", 1, 9);
        assertThat(PasswordService.isValidCount(password)).isTrue();
    }

    public void testIsValidCount_whenMoreThanMax_isFalse() {
        Password password = new Password("aaaaa", "a", 1, 2);
        assertThat(PasswordService.isValidCount(password)).isFalse();
    }

    public void testIsValidCount_whenLessThanMin_isFalse() {
        Password password = new Password("aaaaa", "a", 8, 9);
        assertThat(PasswordService.isValidCount(password)).isFalse();
    }

    public void testIsValidPosition_isTrue() {
        Password password = new Password("abb", "a", 1, 9);
        assertThat(PasswordService.isValidPosition(password)).isTrue();
    }

    public void testIsValidPosition_whenNotMinOrMax_isFalse() {
        Password password = new Password("zzzzzzzzzz", "a", 1, 9);
        assertThat(PasswordService.isValidPosition(password)).isFalse();
    }

    public void testIsValidPosition_whenPasswordTooShort() {
        Password password = new Password("abb", "a", 5, 9);
        assertThat(PasswordService.isValidPosition(password)).isFalse();
    }

    public void testIsValidPosition_whenMoreThanOneOccurance() {
        Password password = new Password("aaa", "a", 1, 3);
        assertThat(PasswordService.isValidPosition(password)).isFalse();
    }

}