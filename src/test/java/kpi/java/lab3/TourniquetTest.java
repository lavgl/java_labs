package kpi.java.lab3;


import kpi.java.lab3.skipass.SkiPass;
import kpi.java.lab3.skipass.SkiPassModifier;
import kpi.java.lab3.skipass.type.SkiPassTypes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Map;

public class TourniquetTest {

    int DEFAULT_NUMBER_OF_PASSAGES = 10;
    int DEFAULT_ACCOUNT = 0;
    LocalDate DEFAULT_DATE = LocalDate.now().plusDays(1);

    Tourniquet tourniquet;
    SkiPass defaultSkiPass;

    @Before
    public void init() {
        tourniquet = new Tourniquet();
        defaultSkiPass = new SkiPass(
                0, SkiPassTypes.NORMAL,
                DEFAULT_DATE,
                DEFAULT_NUMBER_OF_PASSAGES,
                DEFAULT_NUMBER_OF_PASSAGES,
                DEFAULT_ACCOUNT);
    }

    @Test
    public void correctProcessSkiPassTest() {
        tourniquet.processSkiPass(defaultSkiPass);
        Assert.assertTrue(tourniquet.getHistory().get(0).getResult());
    }

    @Test
    public void incorrectProcessSkiPassTest() {
        defaultSkiPass = defaultSkiPass.setNumberOfPassagesLeft(0);
        tourniquet.processSkiPass(defaultSkiPass);
        Assert.assertFalse(tourniquet.getHistory().get(0).getResult());
    }

    @Test
    public void correctTryPassThroughTest() {
        Assert.assertTrue(tourniquet.tryPassThrough(defaultSkiPass));
    }

    @Test
    public void incorrectTryPassThroughTest() {
        SkiPass skiPass = new SkiPass(
                0, SkiPassTypes.NORMAL,
                DEFAULT_DATE,
                DEFAULT_NUMBER_OF_PASSAGES,
                0,
                DEFAULT_ACCOUNT);

        Assert.assertFalse(tourniquet.tryPassThrough(skiPass));
    }

    @Test
    public void getGeneralStatisticTest() {

        for (int i = 0; i < 20; i++) {
            defaultSkiPass = tourniquet.processSkiPass(defaultSkiPass);
        }

        Map statistic = tourniquet.getGeneralStatistic();

        Assert.assertEquals(statistic.get(true), 10);
        Assert.assertEquals(statistic.get(false), 10);
    }

    @Test
    public void getStatisticByTypeTest() {
        SkiPass studentSkiPass = new SkiPass(
                1, SkiPassTypes.STUDENT,
                DEFAULT_DATE,
                DEFAULT_NUMBER_OF_PASSAGES / 2,
                DEFAULT_NUMBER_OF_PASSAGES / 2,
                DEFAULT_ACCOUNT);

        SkiPass schoolerSkiPass = new SkiPass(
                2, SkiPassTypes.SCHOOLER,
                DEFAULT_DATE,
                DEFAULT_NUMBER_OF_PASSAGES / 2,
                DEFAULT_NUMBER_OF_PASSAGES / 2,
                DEFAULT_ACCOUNT);

        for (int i = 0; i < DEFAULT_NUMBER_OF_PASSAGES; i++) {
            defaultSkiPass = tourniquet.processSkiPass(defaultSkiPass);
            studentSkiPass = tourniquet.processSkiPass(studentSkiPass);
            schoolerSkiPass = tourniquet.processSkiPass(schoolerSkiPass);
        }

        Map statisticByNormalType = tourniquet.getStatisticByType(SkiPassTypes.NORMAL);
        Assert.assertEquals(statisticByNormalType.get(true), DEFAULT_NUMBER_OF_PASSAGES);
        Assert.assertEquals(statisticByNormalType.get(false), 0);

        Map statisticByStudentType = tourniquet.getStatisticByType(SkiPassTypes.STUDENT);
        Assert.assertEquals(statisticByStudentType.get(true), DEFAULT_NUMBER_OF_PASSAGES / 2);
        Assert.assertEquals(statisticByStudentType.get(false), DEFAULT_NUMBER_OF_PASSAGES / 2);

        Map statisticBySchoolerType = tourniquet.getStatisticByType(SkiPassTypes.SCHOOLER);
        Assert.assertEquals(statisticBySchoolerType.get(true), DEFAULT_NUMBER_OF_PASSAGES / 2);
        Assert.assertEquals(statisticBySchoolerType.get(false), DEFAULT_NUMBER_OF_PASSAGES / 2);
    }
}
