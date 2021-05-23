package me.ihdeveloper.spigot.devtools.mod.tool;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ServerWall {

    private final Map<String, String> wall = new TreeMap<>();

    public void put(String name, String value) {
        this.wall.put(name, value);
    }

    public void remove(String name) {
        this.wall.remove(name);
    }

    public void clear() {
        this.wall.clear();
    }

    public Set<Map.Entry<String, String>> all() {
        return this.wall.entrySet();
    }

}
