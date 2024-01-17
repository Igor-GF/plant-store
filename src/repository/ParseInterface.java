package repository;

import enums.BestelStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface ParseInterface {

    default int parseStringIntoInteger(String s) {
        if (s != null) {
            return Integer.parseInt(s);
        } else {
            return 0;
        }
    };

    default double parseStringIntoDouble(String s) {
        if (s != null) {
            return Double.parseDouble(s);
        } else {
            return 0;
        }
    };

    default char parseStringIntoChar(String s) {
        if (s != null) {
            return s.charAt(0);
        } else {
            return '-';
        }
    };

    default LocalDate parseStringIntoDate(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (s != null) {
            return LocalDate.parse(s, formatter);
        } else {
            return LocalDate.of(0000, 0, 0);
        }
    }

    default BestelStatus parseStringIntoBestelStatus(String s) {
        String st = s.toUpperCase();
        if (s != null) {
            for (BestelStatus status : BestelStatus.values()) {
                if (st.equals(status.name())) return BestelStatus.valueOf(st);
            }
        }
        System.out.println("Ongeldige status: + '" + st + "' \nStatus is automatisch naar 'Open' gezet! \nStatus opties: \nO = open \nB = blocked \nC = closed \n");
        return BestelStatus.O;
    }
}
