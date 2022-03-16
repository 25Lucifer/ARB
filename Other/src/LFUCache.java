import java.util.HashMap;
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
        ListNode node = new ListNode(-1, -1);
        if (map.containsKey(key)) {
            node = map.get(key);
            updateNodeFreq(node);
        }
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            updateNodeFreq(node);
        } else {
            if (capacity == size) {
                removeLastFreqNode();
            }
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            insertNode(node);
        }
    }

    private void insertNode(ListNode node) {
        node.freq = 1;
        this.minFreq = node.freq;
        DLinkedList list = count.getOrDefault(node.freq, new DLinkedList());
        node.next = list.head.next;
        list.head.next.pre = node;
        node.pre = list.head;
        list.head.next = node;
        list.count++;
        this.size++;
        count.put(node.freq, list);
    }

    private void removeLastFreqNode() {
        DLinkedList list = count.get(minFreq);
        ListNode rmNode = list.pair.pre;
        map.remove(rmNode.key);
        rmNode.next.pre = rmNode.pre;
        rmNode.pre.next = rmNode.next;
        count.put(minFreq, list);
        list.count--;
        if (list.count == 0) {
            this.minFreq++;
        }
        this.size--;
    }

    private void updateNodeFreq(ListNode node) {
        // remove from old
        DLinkedList oldList = count.get(node.freq);
        oldList.count--;
        node.next.pre = node.pre;
        node.pre.next = node.next;
        count.put(node.freq, oldList);
        // add to new's head
        node.freq++;
        DLinkedList newList = count.getOrDefault(node.freq, new DLinkedList());
        node.next = newList.head.next;
        newList.head.next.pre = node;
        node.pre = newList.head;
        newList.head.next = node;
        newList.count++;
        count.put(node.freq, newList);

    }

    class ListNode {
        int key;
        int val;
        int freq = 0;
        ListNode pre;
        ListNode next;
        ListNode() {}
        ListNode (int key, int val) {
            this.key = key;
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

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(4);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(1);
        cache.put(5, 5);
        cache.get(4);
    }
}
