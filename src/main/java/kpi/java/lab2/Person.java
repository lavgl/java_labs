package kpi.java.lab2;

public class Person {

    private final String name;
    private final String surname;
    private final int age;
    private final String mail;

    public Person(String name, String surname, int age, String mail) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        return new Person(name, this.surname, this.age, this.mail);
    }

    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        return new Person(this.name, surname, this.age, this.mail);
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        return new Person(this.name, this.surname, age, this.mail);
    }

    public String getMail() {
        return mail;
    }

    public Person setMail(String mail) {
        return new Person(this.name, this.surname, this.age, mail);
    }

    @Override
    public final boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Person)) return false;

        Person person = (Person) other;

        return  (null == person.getName() ? null == this.name : person.getName().equals(this.name)) &&
                (null == person.getSurname() ? null == this.surname : person.getSurname().equals(this.surname)) &&
                (null == person.getMail() ? null == this.mail : person.getMail().equals(this.mail)) &&
                person.getAge() == this.age;

    }

    @Override
    public final int hashCode() {
        int hash = 1;
        hash += this.name == null ? 0 : 31 * this.name.hashCode();
        hash += this.surname == null ? 0 : 31 * this.surname.hashCode();
        hash += this.mail == null ? 0 : 31 * this.mail.hashCode();
        hash += 31 * this.age;
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": name: " + this.name +
                ", surname: " + this.surname +
                ", mail: " + this.mail +
                ", age: " + this.age;
    }
}
