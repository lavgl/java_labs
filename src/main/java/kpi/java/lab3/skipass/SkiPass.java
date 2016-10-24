package kpi.java.lab3.skipass;

import kpi.java.lab3.skipass.type.SkiPassType;
import kpi.java.lab3.skipass.type.SkiPassTypes;

import java.time.LocalDate;
import java.util.Objects;

public class SkiPass {
    private final int id;
    private final LocalDate expire;
    private final int totalNumberOfPassages;
    private final int numberOfPassagesLeft;
    private final SkiPassType type;
    private final int account;

    public SkiPass(int id) {
        this.id = id;
        this.expire = LocalDate.now().plusDays(10);
        this.totalNumberOfPassages = 5;
        this.numberOfPassagesLeft = 5;
        this.type = SkiPassTypes.NORMAL;
        this.account = 0;
    }

    public SkiPass(
            int id,
            SkiPassType type,
            LocalDate expire,
            int totalNumberOfPassages,
            int numberOfPassagesLeft,
            int account) {
        this.id = id;
        this.type = type;
        this.expire = expire;
        this.totalNumberOfPassages = totalNumberOfPassages;
        this.numberOfPassagesLeft = numberOfPassagesLeft;
        this.account = account;
    }

    public SkiPass process() {
        return this.type.process(this);
    }

    public boolean validate() {
        return this.type.validate(this);
    }

    public int getId() { return this.id; }
    public SkiPassType getType() { return this.type; }
    public LocalDate getExpireDate() {
        return this.expire;
    }
    public int getTotalNumberOfPassages() { return this.totalNumberOfPassages; }
    public int getNumberOfPassagesLeft() { return this.numberOfPassagesLeft; }
    public int getAccount() { return this.account; }

    public SkiPass setType(SkiPassType type) {
        return type.equals(this.type) ?
                this : new SkiPass(
                this.id,
                type,
                this.expire,
                this.totalNumberOfPassages,
                this.numberOfPassagesLeft,
                this.account);
    }
    public SkiPass setExpireDate(LocalDate expire) {
        return expire.equals(this.expire) ?
                this : new SkiPass(
                this.id,
                this.type,
                expire,
                this.totalNumberOfPassages,
                this.numberOfPassagesLeft,
                this.account);
    }
    public SkiPass setTotalNumberOfPassages(int totalNumberOfPassages) {
        return totalNumberOfPassages == this.totalNumberOfPassages ?
                this : new SkiPass (
                this.id,
                this.type,
                this.expire,
                totalNumberOfPassages,
                this.numberOfPassagesLeft,
                this.account);
    }
    public SkiPass setNumberOfPassagesLeft(int numberOfPassagesLeft) {
        return numberOfPassagesLeft == this.numberOfPassagesLeft
                ? this : new SkiPass(
                this.id,
                this.type,
                this.expire,
                this.totalNumberOfPassages,
                numberOfPassagesLeft,
                this.account);
    }
    public SkiPass setAccount(int account) {
        return account == this.account ?
                this : new SkiPass(
                this.id,
                this.type,
                this.expire,
                this.totalNumberOfPassages,
                this.numberOfPassagesLeft,
                account);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkiPass)) return false;
        SkiPass skiPass = (SkiPass) o;
        return id == skiPass.id &&
                totalNumberOfPassages == skiPass.totalNumberOfPassages &&
                numberOfPassagesLeft == skiPass.numberOfPassagesLeft &&
                account == skiPass.account &&
                Objects.equals(expire, skiPass.expire) &&
                Objects.equals(type, skiPass.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expire, totalNumberOfPassages, numberOfPassagesLeft, type, account);
    }
}
