package family_tree.family_tree;


import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends TreeNode<T>> implements  Iterator<Human> {
    private int index;
    private List<Human> family;

    public FamilyTreeIterator(List<Human> family) {
        this.family = family;
        index =0;
    }

    @Override
    public boolean hasNext() {
        return index < family.size();
    }

    @Override
    public Human next() {
        return family.get(index++);
    }
}
