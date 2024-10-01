package model.HumanBilder;

import model.human.Genger;
import model.human.Human;

import java.time.LocalDate;
import java.util.List;

public class HumanBuilder {
    private int maxId;
    private Human human;
    private String humanName;
    private Genger humanGender;
    private LocalDate HumanBirthDay;
    private LocalDate deathDate;
    private Human humanMother;
    private Human humanFather;
    private List<Human> humanChildren;
    public HumanBuilder(){
        createHuman();
    }

    public HumanBuilder setHumanBirthDay(LocalDate humanBirthDay){
        this.HumanBirthDay = humanBirthDay;
        return this;
    }

    public HumanBuilder setHumanGender(Genger humanGender) {
        this.humanGender = humanGender;
        return this;
    }

    public HumanBuilder setHumanName(String humanName){
        this.humanName = humanName;
        return this;
    }

    public HumanBuilder setHumanMother(Human humanMother) {
        this.humanMother = humanMother;
        return this;
    }

    public HumanBuilder setHumanFather(Human humanFather) {
        this.humanFather = humanFather;
        return this;
    }

    public HumanBuilder setHumanChildren(List<Human> humanChildren) {
        this.humanChildren = humanChildren;
        return this;
    }

    private void createHuman(){
        human = new Human();
    }
    private void createName(){
        human.setName(humanName);
    }
    public void createBirthDay(){
        human.setBirthDay(HumanBirthDay);
    }
    public void createGender(){
        human.setGenger(humanGender);
    }
    public void createMother(){
        human.setMother(humanMother);
    }
    public void createFather(){
        human.setFather(humanFather);
    }
    public void createChildren(){
        human.addChildren((Human) humanChildren);
    }
    private void nextId(){
        human.setId(maxId++);
    }
    public Human build(){
        createHuman();
        createName();
        createGender();
        createBirthDay();
        createMother();
        createFather();
        createChildren();
        nextId();
        return human;
    }
}
