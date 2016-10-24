package kpi.java.lab3.skipass.type;

import kpi.java.lab3.skipass.SkiPass;

import java.time.LocalDate;

public enum SkiPassTypes implements SkiPassType {
    NORMAL {
        public int getCost(SkiPass skiPass) {
            return 300;
        }

        public boolean validate(SkiPass skiPass) {
            return  skiPass.getExpireDate().isAfter(LocalDate.now()) &&
                    skiPass.getNumberOfPassagesLeft() > 0;
        }

        public SkiPass process(SkiPass skiPass) {
            return skiPass.setNumberOfPassagesLeft(skiPass.getNumberOfPassagesLeft() - 1);
        }
    },

    NORMAL_ACCUMULATIVE {
        public int getCost(SkiPass skiPass) {
            return 300;
        }

        public boolean validate(SkiPass skiPass) {
            return skiPass.getAccount() > getCost(skiPass);
        }

        public SkiPass process(SkiPass skiPass) {
            return skiPass.setAccount(skiPass.getAccount() - getCost(skiPass));
        }
    },

    STUDENT {
        public int getCost(SkiPass skiPass) {
            return 200;
        }

        public boolean validate(SkiPass skiPass) {
            return  skiPass.getNumberOfPassagesLeft() > 0 &&
                    skiPass.getExpireDate().isAfter(LocalDate.now());
        }

        public SkiPass process(SkiPass skiPass) {
            return skiPass.setNumberOfPassagesLeft(skiPass.getNumberOfPassagesLeft() - 1);
        }
    },

    SCHOOLER {
        public int getCost(SkiPass skiPass) {
            return 100;
        }

        public boolean validate(SkiPass skiPass) {
            return  skiPass.getNumberOfPassagesLeft() > 0 &&
                    skiPass.getExpireDate().isAfter(LocalDate.now());
        }

        public SkiPass process(SkiPass skiPass) {
            return skiPass.setNumberOfPassagesLeft(skiPass.getNumberOfPassagesLeft() - 1);
        }
    }
}
