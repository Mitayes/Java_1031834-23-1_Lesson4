package org.example.entity;

import org.example.enumClasses.Sex;

import java.util.Objects;

public class NPC extends Character{
    private String locationName;
    private Coordinate coordinates;

    protected NPC(String name, Sex sex, String locationName, Coordinate coordinates) {
        super(name, sex);
        this.locationName = locationName;
        this.coordinates = coordinates;
    }

    @Override
    public void sayHello() {

    }

    // Getter setter
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    // default functions override
    @Override
    public String toString() {
        return "NPC{" +
                "name='" + getName() +
                ", sex='" + getSex() +
                ", locationName='" + getLocationName() +
                ", coordinates=" + getCoordinates() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NPC npc = (NPC) o;
        return Objects.equals(getName(), npc.getName())
                && Objects.equals(getSex(), npc.getSex())
                && Objects.equals(getLocationName(), npc.getLocationName())
                && Objects.equals(getCoordinates(), npc.getCoordinates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSex(), getLocationName(), getCoordinates());
    }
}
