package family_tree.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    void setId(long id);
    long getId();
//    T getFather;
//    T getMother;
    boolean addChildren(T human);
    boolean addParent(T human);
    String getName();
    List<T> getParents();
    List<T> getChildren();
    LocalDate getBirthDay();
}
