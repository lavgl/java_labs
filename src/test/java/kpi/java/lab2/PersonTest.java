package kpi.java.lab2;

import com.google.gson.Gson;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void equalsPerson() {
        EqualsVerifier.forClass(Person.class).verify();
    }

    @Test
    public void equalsPersonAfterTransform() {
        Gson gson = new Gson();
        Person person = new Person("name", "surname", 18, "mail.co.ua");
        String json = gson.toJson(person);
        Person fromJSON = gson.fromJson(json, Person.class);

        Assert.assertEquals(person, fromJSON);
    }
}
