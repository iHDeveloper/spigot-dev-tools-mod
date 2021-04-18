package me.ihdeveloper.spigot.devtools.mod.tool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Watcher {

    private HashMap<String, String> map = new HashMap<>();

    public void put(String key, String value) {
        map.put(key, value);
    }

    public void remove(String key) {
        map.remove(key);
    }

    public Set<Map.Entry<String, String>> entrySet() {
        return map.entrySet();
    }

}
