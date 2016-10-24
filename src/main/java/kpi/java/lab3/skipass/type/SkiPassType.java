package kpi.java.lab3.skipass.type;

import kpi.java.lab3.skipass.SkiPass;

public interface SkiPassType {
    int getCost(SkiPass skiPass);
    SkiPass process(SkiPass skiPass);
    boolean validate(SkiPass skiPass);
}
