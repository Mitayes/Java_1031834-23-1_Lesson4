package org.example.entity;

import org.example.enumClasses.Sex;

import java.util.List;
import java.util.Objects;

public class QuestGiver extends NPC{
    private List<Quest> questList;
    protected QuestGiver(String name, Sex sex, String locationName, Coordinate coordinates, List<Quest> questList) {
        super(name, sex, locationName, coordinates);
        this.questList = questList;
    }

    // Getters setters
    public List<Quest> getQuestList() {
        return questList;
    }

    public void setQuestList(List<Quest> questList) {
        this.questList = questList;
    }

    // default functions override
    @Override
    public String toString() {
        return "QuestGiver{" +
                "name='" + getName() +
                ", sex='" + getSex() +
                ", locationName='" + getLocationName() +
                ", coordinates=" + getCoordinates() +
                ", questList=" + getQuestList() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        QuestGiver that = (QuestGiver) o;
        return Objects.equals(getQuestList(), that.getQuestList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getQuestList());
    }

    // Quest management
    public void addQuest(String name, Float reward){
        questList.add(new Quest(name, reward));
    }
    public void removeQuest(Quest quest){
        questList.remove(quest);
    }
    public void showQuests(){
        for(Quest quest : questList){
            System.out.println(quest);
        }
    }
    public void giveQuest(Quest questName){
        String message;
        if (questList.contains(questName)){
            message = "You have received a quest";
        } else {
            message = "The quest does not exist";
        }

        System.out.println(message);

    }
    public void completeQuest(Player player, Quest quest){
        String message;
        if (questList.contains(quest)){
            boolean result = player.increaseMoney(quest.getReward());
            if (result){
                removeQuest(quest);
                message = "Quest completed";
            } else {
                message = "An error occurred when calculating the reward";
            }
        } else {
            message = "The quest does not exist";
        }

        System.out.println(message);
    }
}
