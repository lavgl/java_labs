package kpi.java.lab3.skipass;

import kpi.java.lab3.skipass.type.SkiPassTypes;

import java.time.LocalDate;

public class SkiPassModifier {
    public static SkiPass makeStudentType(SkiPass skiPass) {
        return skiPass
                .setType(SkiPassTypes.STUDENT)
                .setAccount(0);
    }

    public static SkiPass makeSchoolerType(SkiPass skiPass) {
        return skiPass
                .setType(SkiPassTypes.SCHOOLER)
                .setAccount(0);
    }

    public static SkiPass makeNormalType(SkiPass skiPass) {
        return skiPass
                .setType(SkiPassTypes.NORMAL)
                .setAccount(0);
    }

    public static SkiPass makeAcumulative(SkiPass skiPass) {
        return skiPass
                .setType(SkiPassTypes.NORMAL_ACCUMULATIVE)
                .setTotalNumberOfPassages(Integer.MAX_VALUE)
                .setExpireDate(LocalDate.MAX);
    }

    public static SkiPass makeMonthTerm(SkiPass skiPass) {
        return skiPass.setExpireDate(LocalDate.now().plusMonths(1));
    }

    public static SkiPass makeTenDayTerm(SkiPass skiPass) {
        return skiPass.setExpireDate(LocalDate.now().plusDays(10));
    }

    public static SkiPass makeFivePassages(SkiPass skiPass) {
        return skiPass.setTotalNumberOfPassages(5);
    }

    public static SkiPass makeTenPassages(SkiPass skiPass) {
        return skiPass.setTotalNumberOfPassages(10);
    }

    public static SkiPass setAccount(SkiPass skiPass, int amount) {
        return skiPass.setAccount(amount);
    }

    public static SkiPass fillAccount(SkiPass skiPass, int amount) {
        return skiPass.setAccount(skiPass.getAccount() + amount);
    }
}
