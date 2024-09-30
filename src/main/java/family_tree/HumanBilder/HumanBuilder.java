package family_tree.HumanBilder;

import family_tree.human.Genger;
import family_tree.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private int maxId;
    private Human human;

    public HumanBuilder(){
        createHuman();
    }

    public HumanBuilder setAge(int age){
        human.setAge(age);
        return this;
    }

    public HumanBuilder setName(int name){
        human.setName(name);
        return this;
    }

    private void createHuman(){
        human = new Human();
    }



}
