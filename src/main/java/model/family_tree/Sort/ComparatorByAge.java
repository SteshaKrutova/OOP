package family_tree.family_tree.Sort;

import family_tree.family_tree.TreeNode;
import family_tree.human.Human;

import java.util.Comparator;

public class ComparatorByAge<T extends TreeNode<T>> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDay().compareTo(o2.getBirthDay());
    }
}
