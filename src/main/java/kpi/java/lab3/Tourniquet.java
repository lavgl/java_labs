package kpi.java.lab3;

import kpi.java.lab3.skipass.SkiPass;
import kpi.java.lab3.skipass.type.SkiPassType;

import java.util.*;

public class Tourniquet {
    private List<StatisticDatum> history = new ArrayList<StatisticDatum>();

    public List<StatisticDatum> getHistory() {
        return this.history;
    }

    public SkiPass processSkiPass(SkiPass skiPass) /*throws InvalidSkiPassException*/ {
        boolean isValid = skiPass.validate();
        if (isValid) {
            SkiPass processedSkiPass = skiPass.process();
            history.add(new StatisticDatum(processedSkiPass, true));
            return processedSkiPass;
        } else {
            history.add(new StatisticDatum(skiPass, false));
            return skiPass;
            /*throw new InvalidSkiPassException();*/
        }
    }

    public boolean tryPassThrough(SkiPass skiPass) {
        SkiPass processedSkiPass = processSkiPass(skiPass);
        return !skiPass.equals(processedSkiPass);
    }

    public Map<Boolean, Integer> getGeneralStatistic() {
        Map<Boolean, Integer> statistic = new HashMap<>();
        statistic.put(true, 0);
        statistic.put(false, 0);

        for (StatisticDatum datum : this.history) {
            statistic.put(datum.getResult(), statistic.get(datum.getResult()) + 1);
        }
        System.out.println(statistic);
        return statistic;
    }

    public Map<Boolean, Integer> getStatisticByType(SkiPassType type) {
        Map<Boolean, Integer> statistic = new HashMap<>();
        statistic.put(true, 0);
        statistic.put(false, 0);

        for (StatisticDatum datum : this.history) {
            if (datum.getSkiPass().getType() == type) {
                statistic.put(datum.getResult(), statistic.get(datum.getResult()) + 1);
            }
        }

        return statistic;
    }
}
