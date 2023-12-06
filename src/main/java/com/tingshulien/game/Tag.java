package com.tingshulien.game;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Tag implements TagQuery {

    private static final Map<String, Tag> tagByName = new ConcurrentHashMap<>();

    private static final Map<String, String[]> arrayByTag = new ConcurrentHashMap<>();

    final String name;

    final String[] array;

    Tag(String name) {
        this.name = name;
        if (!arrayByTag.containsKey(name)) {
            arrayByTag.put(name, name.split("\\."));
        }

        array = arrayByTag.get(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean matchesTag(Tag other) {
        if (isEmpty()) {
            return false;
        }

        if (this.array.length < other.array.length) {
            return false;
        }

        for (int i = 0; i < other.array.length; i++) {
            if (!other.array[i].equals(this.array[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean matchesTagExact(Tag other) {
        if (isEmpty()) {
            return false;
        }

        return Arrays.equals(this.array, other.array);
    }

    @Override
    public boolean matchesAny(TagContainer container) {
        if (isEmpty()) {
            return false;
        }

        Map<String, TagNode> current = container.root;
        for (int i = 0; i < array.length; i++) {
            TagNode node = current.get(array[i]);

            if (node == null) {
                return i != 0;
            }

            current = node.children;
        }

        return current.isEmpty();
    }

    @Override
    public boolean matchesAnyExact(TagContainer container) {
        if (isEmpty()) {
            return false;
        }

        Map<String, TagNode> current = container.root;
        for (String nodeName : array) {
            TagNode node = current.get(nodeName);

            if (node == null) {
                return false;
            }

            current = node.children;
        }

        return current.isEmpty();
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

    public static Tag getInstance(String name) {
        if (!tagByName.containsKey(name)) {
            tagByName.put(name, new Tag(name));
        }

        return tagByName.get(name);
    }

}
