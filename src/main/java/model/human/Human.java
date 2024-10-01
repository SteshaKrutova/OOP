package family_tree.human;

import family_tree.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, TreeNode<Human> {
    private long id;
    private String name;
    private Genger gender;
    private LocalDate birthDay;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human spouse;

//дефолтный конструктор без аргументов без всего для билдера
    public Human(){

    }
//    public Human(String name, Genger genger, LocalDate birthDay, LocalDate deathDate,
//                 Human mother, Human father) {
//        //человек ещё ни где
//        this.id = -1;
//        this.name = name;
//        this.gender = genger;
//        this.birthDay = birthDay;
//        this.deathDate = deathDate;
//        this.mother = mother;
//        this.father = father;
//         children = new ArrayList<>();
//    }
//    // пререгрузка
//    public Human(String name, Genger genger, LocalDate birthDay) {
//        this(name, genger,  birthDay, null,  null,  null);
//    }
//
//    public Human(String name, Genger genger, LocalDate birthDay, Human mother, Human father) {
//        this(name, genger,  birthDay, null,  mother,  father);
//    }
//

    public boolean addChildren(Human child){
        //contains - входит ли в список значение
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        else
            return false;
    }

    public boolean addParent (Human parant){
        if(parant.getGenger().equals(Genger.Male)){
            setFather(parant);
        }
        else if (parant.getGenger().equals(Genger.Female)){
            setMother(parant);
        }
        return true;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Genger getGenger() {
        return gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }


    public List<Human> getChildren() {
        return children;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setGenger(Genger genger) {
        this.gender = genger;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }


    public List<Human> getParents(){
        ArrayList<Human> parents = new ArrayList<>(2);
        if (getFather()!= null) {
            parents.add(getFather());
        }
        if (getMother()!=null)
            parents.add(getMother());
        return parents;
    }


    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDay,LocalDate.now());
        }
        else {
            return getPeriod(birthDay,deathDate);
        }
    }

    private int getPeriod (LocalDate birthDay, LocalDate deathDate){
        Period diff = Period.between(birthDay,deathDate);
        return diff.getYears();
    }

    public String getMotherInfo(){
        String str = "мать: ";
        Human mother = getMother();
        if(mother!=null){
            str+=mother.getName();
        }
        else {
            str+="неизвестна";
        }
        return str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ");
        stringBuilder.append(id);
        stringBuilder.append(", имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", пол: ");
        stringBuilder.append(gender);
        stringBuilder.append(", возраст: ");
        stringBuilder.append(getAge());
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getFatherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getChildrenInfo());
        return stringBuilder.toString();
    }

    public String getSopouseInfo() {
        String res = "супруг(а):";
        if(spouse==null){
            res+="нет!";
        }
        else {
            res+=spouse.getName();
        }
        return res;
    }



    public String getFatherInfo(){
        String str = "отец: ";
        Human father = getFather();
        if(father != null){
            str= father.getName();
        }
        else {
            str+="неизвестен";
        }
        return str;
    }

    public String getChildrenInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Дети: ");
        if(children.size()!=0){
            sb.append(children.get(0).getName());
            for (int i=1;i<children.size();i++){
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        } else {
            sb.append("отсутствуют");
        }
        return sb.toString();
    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + l +
//                '}';
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return human.getId() == getId();
    }

}
