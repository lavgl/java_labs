package kpi.java.lab3;

import kpi.java.lab3.skipass.SkiPass;

public class StatisticDatum {
    private final SkiPass skiPass;
    private final boolean result;

    public StatisticDatum(SkiPass skiPass, boolean result) {
        this.skiPass = skiPass;
        this.result = result;
    }

    public SkiPass getSkiPass() {
        return skiPass;
    }

    public boolean getResult() {
        return result;
    }
}
