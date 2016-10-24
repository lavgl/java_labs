package kpi.java.lab3;

import kpi.java.lab3.skipass.SkiPass;
import kpi.java.lab3.skipass.SkiPassModifier;
import kpi.java.lab3.skipass.type.SkiPassTypes;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class NormalSkiPassTest {

    int DEFAULT_NORMAL_COST = 300;

    @Test
    public void getCostTest() {
        Assert.assertEquals(
                SkiPassTypes.NORMAL.getCost(new SkiPass(0)),
                DEFAULT_NORMAL_COST);
    }

    @Test
    public void correctValidateTest() {
        SkiPass skiPass = new SkiPass(0);
        skiPass = SkiPassModifier.makeTenDayTerm(skiPass);
        skiPass = SkiPassModifier.makeTenPassages(skiPass);

        Assert.assertTrue(SkiPassTypes.NORMAL.validate(skiPass));
    }

    @Test
    public void incorrectValidateExpireDateTest() {
        SkiPass skiPass = new SkiPass(
                0, SkiPassTypes.NORMAL,
                LocalDate.now().minusDays(1), // should fails here
                10, 10, 0);

        Assert.assertFalse(SkiPassTypes.NORMAL.validate(skiPass));
    }

    @Test
    public void incorrectValidateNumOfLeftPassagesTest() {
        SkiPass skiPass = new SkiPass(
                0, SkiPassTypes.NORMAL,
                LocalDate.now().plusDays(1),
                10,
                0, // should fails here
                0);

        Assert.assertFalse(SkiPassTypes.NORMAL.validate(skiPass));
    }

    @Test
    public void processTest() {
        SkiPass skiPass = new SkiPass(
                0, SkiPassTypes.NORMAL,
                LocalDate.now().plusDays(1),
                10, 10, 0);

        SkiPass afterProcessing = SkiPassTypes.NORMAL.process(skiPass);
        Assert.assertEquals(afterProcessing.getNumberOfPassagesLeft(), 9);
    }
}
