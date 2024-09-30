package family_tree.family_tree;

import family_tree.family_tree.Sort.ComparatorByAge;
import family_tree.family_tree.Sort.ComparatorByName;
import family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Family_tree<E extends TreeNode<E>> implements Serializable, Iterable<Human> {
    private long humansId;
    private List<E> familyTree;

    public Family_tree() {
        this(new ArrayList<>());
    }

    public Family_tree(List<E> familyTree) {
        this.familyTree = familyTree;
    }

    public boolean add (E human){
        if(human == null){
            return false;
        }
        if(!(familyTree.contains(human))){
            familyTree.add(human);
            human.setId(humansId++);

            addtoParants(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addtoParants (E human){
        for(E parent: human.getParents()){
            parent.addChildren(human);
        }
    }

    private void addToChildren(E human){
        for(E child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: familyTree){
            if(human.getName()==name){
                res.add(human);
            }
        }
        return res;
    }

    public E getById(long id){
        for(E human:familyTree){
            if(human.getId()==id){
                return human;
            }
        }
        return null;
    }

    private boolean checkId(long id){
        return id<humansId && humansId>=0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дерево:\n");
        for (E human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.sort(new ComparatorByName());
    }

    public void sortByAge() {
        familyTree.sort(new ComparatorByAge());
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(familyTree);
    }
//
//    class HumanIterator implements Iterator<E>{
//        private int curIndex;
//        @Override
//        public boolean hasNext() {
//            return humanList.size()>curIndex;
//        }
//
//        @Override
//        public E next() {
//            return humanList.get(curIndex++);
//        }
//    }
}
