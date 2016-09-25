package kpi.java.lab2;

import java.util.regex.Pattern;

public class Validator {
    public static boolean validateMail(String mail) {
        return Pattern.matches("^([a-z0-9_\\.-]+)@([a-z0-9)\\.-]+)\\.([a-z\\.]{2,7})$", mail);
    }
}
