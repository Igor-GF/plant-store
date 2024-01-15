package repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Repository {

    static int parseStringIntoInteger(String s) {
        if (s != null) {
            return Integer.parseInt(s);
        } else {
            return 0;
        }
    };

    static double parseStringIntoDouble(String s) {
        if (s != null) {
            return Double.parseDouble(s);
        } else {
            return 0;
        }
    };

    static char parseStringIntoChar(String s) {
        if (s != null) {
            return s.charAt(0);
        } else {
            return '-';
        }
    };

    static LocalDate parseStringIntoDate(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (s != null) {
            return LocalDate.parse(s, formatter);
        } else {
            return LocalDate.of(0000, 0, 0);
        }
    }
}
