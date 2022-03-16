import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangshu
 * @date 2022-03-16 9:54
 */
public class AllOne {

    Map<Integer, Set<String>> countToSet;
    Map<String, Integer> keyToCount;

    public AllOne() {
        countToSet = new HashMap<>();
        keyToCount = new HashMap<>();
    }

    public void inc(String key) {
        Integer count = keyToCount.getOrDefault(key, 0);
        Set<String> old_set = countToSet.getOrDefault(count, new HashSet<>());
        old_set.remove(key);
        countToSet.put(count, old_set);
        count++;
        Set<String> new_set = countToSet.getOrDefault(count, new HashSet<>());
        new_set.add(key);
        countToSet.put(count, new_set);
        keyToCount.put(key, count);
    }

    public void dec(String key) {

    }

    public String getMaxKey() {
        return "";
    }

    public String getMinKey() {
        return "";
    }


}
