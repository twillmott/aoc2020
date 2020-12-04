package io.twillmott.service;

import io.twillmott.model.Passport;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class PassportService {

    public static Passport mapToPassport(Map<String, String> map) {
        return new Passport(
                map.get("byr") == null ? null : Integer.valueOf(map.get("byr")),
                map.get("iyr") == null ? null : Integer.valueOf(map.get("iyr")),
                map.get("eyr") == null ? null : Integer.valueOf(map.get("eyr")),
                map.get("hgt"),
                map.get("hcl"),
                map.get("ecl"),
                map.get("pid"),
                map.get("cid"));
    }

    public static Map<String, String> deserializeToMap(String string) {
        return Arrays.stream(string.split(" "))
                .map(p -> p.split(":"))
                .collect(Collectors.toMap(p -> p[0], p -> p[1]));
    }

    public static boolean isValidLenient(Passport passport) {
        return passport.getBirthYear() != null &&
                passport.getExpirationYear() != null &&
                passport.getEyeColor() != null &&
                passport.getHairColor() != null &&
                passport.getHeight() != null &&
                passport.getIssueYear() != null &&
                passport.getPassportId() != null;
    }

    public static boolean isValidStrict(Passport passport) {

        if (passport.getBirthYear() == null ||
                passport.getExpirationYear() == null ||
                passport.getEyeColor() == null ||
                passport.getHairColor() == null ||
                passport.getHeight() == null ||
                passport.getIssueYear() == null ||
                passport.getPassportId() == null) {
            return false;
        }

        // byr (Birth Year) - four digits; at least 1920 and at most 2002.
        if (passport.getBirthYear() < 1920 || passport.getBirthYear() > 2002) {
            return false;
        }
        // iyr (Issue Year) - four digits; at least 2010 and at most 2020.
        if (passport.getIssueYear() < 2010 || passport.getIssueYear() > 2020) {
            return false;
        }
        // eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
        if (passport.getExpirationYear() < 2020 || passport.getExpirationYear() > 2030) {
            return false;
        }
        // hgt (Height) - a number followed by either cm or in:
        // If cm, the number must be at least 150 and at most 193.
        // If in, the number must be at least 59 and at most 76.
        if (passport.getHeight().contains("in")) {
            int height = Integer.valueOf(passport.getHeight().replace("in", ""));
            if (height < 59 || height > 76) {
                return false;
            }
        } else if (passport.getHeight().contains("cm")) {
            int height = Integer.valueOf(passport.getHeight().replace("cm", ""));
            if (height < 150 || height > 193) {
                return false;
            }
        } else {
            return false;
        }
        // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
        if (!passport.getHairColor().matches("#[0-9a-f]{6}")) {
            return false;
        }
        // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
        if (!passport.getEyeColor().contains("amb") &&
                !passport.getEyeColor().contains("blu") &&
                !passport.getEyeColor().contains("brn") &&
                !passport.getEyeColor().contains("gry") &&
                !passport.getEyeColor().contains("grn") &&
                !passport.getEyeColor().contains("hzl") &&
                !passport.getEyeColor().contains("oth")
        ) {
            return false;
        }
        // pid (Passport ID) - a nine-digit number, including leading zeroes.
        if (!passport.getPassportId().matches("\\d{9}")) {
            return false;
        }
        // cid (Country ID) - ignored, missing or not.

//        System.out.println("byr:" + passport.getBirthYear() + " iyr:" + passport.getIssueYear() + " eyr:" + passport.getExpirationYear() + " hgt:" + passport.getHeight() + " hcl:" + passport.getHairColor() + " ecl:" + passport.getEyeColor() + " pid:" + passport.getPassportId());
        System.out.println();
        return true;

    }
}
