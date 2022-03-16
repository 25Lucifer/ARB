import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangshu
 * @date 2022-03-16 10:16
 */
public class LFUCache {

    Map<Integer, ListNode> map;
    Map<Integer, DLinkedList> count;
    int capacity;
    int size = 0;
    int minFreq = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        count = new HashMap<>();
    }

    public int get(int key) {


        return 0;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            updateNode(node);
        } else {

        }


        ListNode target = map.getOrDefault(key, new ListNode(value));
        target.freq++;
        target.val = value;
        // remove from old
        if (target.pre != null) {
            target.pre.next = target.next;
        }
        if (target.next != null) {
            target.next.pre = target.pre;
        }
        // add to new's head
        DLinkedList list = count.getOrDefault(target.freq, new DLinkedList());

        target.next = list.head.next;
        list.head.next.pre = target;
        target.pre = list.head;
        list.head.next = target;

        count.put(target.freq, list);
    }

    class ListNode {
        int val;
        int freq = 0;
        ListNode pre;
        ListNode next;
        ListNode() {}
        ListNode (int val) {
            this.val = val;
        }
    }

    class DLinkedList {
        ListNode head;
        ListNode pair;
        int count = 0;
        DLinkedList() {
            head = new ListNode();
            pair = new ListNode();
            head.next = pair;
            pair.pre = head;
        }



    }
}
