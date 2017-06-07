/**
 * Sai Ram Thota
 * CWID 11573236
 * Data Structures Project
 *
 */

import java.util.ArrayList;
import java.util.List;


public class AVLTreeNodeData<V> {

    V val;
    List<Integer> occurs;


    public AVLTreeNodeData(V val) {
        this.val = val;
        this.occurs = new ArrayList<>();
    }


    public AVLTreeNodeData(V val, List<Integer> occurs) {
        this.val = val;
        this.occurs = occurs;
    }


    public V getValue() {
        return val;
    }


    public AVLTreeNodeData<V> setValue(V val) {
        this.val = val;
        return this;
    }


    public List<Integer> getOccurrences() {
        return occurs;
    }


    public AVLTreeNodeData<V> setOccurrences(List<Integer> occurs) {
        this.occurs = occurs;
        return this;
    }


    public int getCount() {
        return occurs.size();
    }


    public AVLTreeNodeData<V> addOccurrence(int position) {
        this.occurs.add(position);
        return this;
    }

    @Override
    public String toString() {
        return "AVLTreeNodeData{" +
                "val=" + val +
                ", occurs=" + occurs +
                '}';
    }
}
