package kpi.java.lab3;

import kpi.java.lab3.skipass.SkiPass;
import kpi.java.lab3.skipass.type.SkiPassType;

import java.time.LocalDate;

public class Register {
    private static int skiPassCounter = 0;

    public SkiPass releaseSkiPass (
            SkiPassType type,
            LocalDate expire,
            int totalNumberOfPassages,
            int numberOfPassagesLeft,
            int account) {

        return new SkiPass (
                skiPassCounter++,
                type,
                expire,
                totalNumberOfPassages,
                numberOfPassagesLeft,
                account
        );
    }
}
