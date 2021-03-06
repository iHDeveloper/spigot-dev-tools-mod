package me.ihdeveloper.spigot.devtools.mod.tool;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Profiler {

    private Map<String, Item> items = new TreeMap<>();
    private long totalTicks;
    private long totalMilliseconds;

    public Item get(String name) {
        return items.computeIfAbsent(name, (key) -> new Item(name));
    }

    public Collection<Item> all() {
        return items.values();
    }

    public void setTotalTicks(long totalTicks) {
        this.totalTicks = totalTicks;
    }

    public long getTotalTicks() {
        return totalTicks;
    }

    public void setTotalMilliseconds(long totalMilliseconds) {
        this.totalMilliseconds = totalMilliseconds;
    }

    public long getTotalMilliseconds() {
        return totalMilliseconds;
    }

    public static class Item {
        private final String name;
        private boolean updated;
        private long ticks;
        private long milliseconds;
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

        public void setMilliseconds(long milliseconds) {
            this.milliseconds = milliseconds;
        }

        public long getMilliseconds() {
            return milliseconds;
        }

        public void setPercent(double percent) {
            this.percent = percent;
        }

        public double getPercent() {
            return percent;
        }
    }
}
