package org.example.entity;

import org.example.enumClasses.Sex;
import org.example.enumClasses.PlayerClass;

import java.util.List;
import java.util.Objects;

public class Player extends Character{
    private Integer hp;
    private Integer mp;
    private PlayerClass playerClass;
    private List<String> skills;
    private Integer movementSpeed;
    private float money;

    protected Player(String name, Sex sex, Integer hp, Integer mp, PlayerClass playerClass, List<String> skills, Integer movementSpeed, float money) {
        super(name, sex);
        this.hp = hp;
        this.mp = mp;
        this.playerClass = playerClass;
        this.skills = skills;
        this.movementSpeed = movementSpeed;
        this.money = money;
    }

    @Override
    public void sayHello() {

    }

    // Getter setter
    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public PlayerClass getSpecialization() {
        return playerClass;
    }

    public void setSpecialization(PlayerClass playerClass) {
        this.playerClass = playerClass;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Integer getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(Integer movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    // default functions override
    @Override
    public String toString() {
        return "Player{" +
                "name=" + getName() +
                ", sex=" + getSex() +
                ", hp=" + getHp() +
                ", mp=" + getMp() +
                ", playerClass=" + getClass() +
                ", skills=" + getSkills() +
                ", movementSpeed=" + getMovementSpeed() +
                ", money=" + getMoney() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(player.getName(), getName())
                && Objects.equals(player.getSex(), getSex())
                && Float.compare(player.getMoney(), getMoney()) == 0
                && Objects.equals(getHp(), player.getHp())
                && Objects.equals(getMp(), player.getMp())
                && playerClass == player.playerClass
                && Objects.equals(getSkills(), player.getSkills())
                && Objects.equals(getMovementSpeed(), player.getMovementSpeed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSex(),
                getHp(), getMp(), playerClass, getSkills(), getMovementSpeed(), getMoney());
    }

    // Money management
    public boolean increaseMoney(float price){
        try {
            setMoney(getMoney() - price);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public boolean decreaseMoney(float price){
        try {
            setMoney(getMoney() - price);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
