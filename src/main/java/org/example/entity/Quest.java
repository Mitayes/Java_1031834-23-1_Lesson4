package org.example.entity;

import java.util.Objects;

public class Quest {
    private String name;
    private Float reward;

    public Quest(String name, Float reward) {
        this.name = name;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getReward() {
        return reward;
    }

    public void setReward(Float reward) {
        this.reward = reward;
    }

    // default functions override
    @Override
    public String toString() {
        return "Quest{" +
                "name='" + name +
                ", reward=" + reward +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quest quest = (Quest) o;
        return Objects.equals(getName(), quest.getName()) && Objects.equals(getReward(), quest.getReward());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getReward());
    }
}
