package me.ihdeveloper.spigot.devtools.mod.tool;

import java.util.LinkedList;

public class Logger {
    private static final int MAX_LOG_CACHE = 100;

    private final LinkedList<Message> linkedList = new LinkedList<>();

    public void add(byte type, String message) {
        Message log = new Message();
        log.type = type;
        log.message = message;
        linkedList.addLast(log);

        if (linkedList.size() > MAX_LOG_CACHE) {
            linkedList.removeFirst();
        }
    }

    public LinkedList<Message> all() {
        return linkedList;
    }

    public static class Message {
        private byte type;
        private String message;

        public byte getType() {
            return type;
        }

        public String getMessage() {
            return message;
        }
    }
}
