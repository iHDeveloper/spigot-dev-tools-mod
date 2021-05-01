package me.ihdeveloper.spigot.devtools.mod;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Profiler {

    private Map<String, Item> items = new TreeMap<>();

    public Item get(String name) {
        return items.computeIfAbsent(name, (key) -> new Item(name));
    }

    public Collection<Item> all() {
        return items.values();
    }

    public static class Item {
        private final String name;
        private boolean updated;
        private long ticks;
        private double percent;

        public Item(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setUpdated(boolean updated) {
            this.updated = updated;
        }

        public boolean isUpdated() {
            return updated;
        }

        public void setTicks(long ticks) {
            this.ticks = ticks;
        }

        public long getTicks() {
            return ticks;
        }

        public void setPercent(double percent) {
            this.percent = percent;
        }

        public double getPercent() {
            return percent;
        }
    }
}
