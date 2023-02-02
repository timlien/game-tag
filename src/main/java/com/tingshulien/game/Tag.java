package com.tingshulien.game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Tag implements TagQuery {

    private static final Map<String, String[]> arrayByTag = new ConcurrentHashMap<>();

    String[] array;

    public Tag(String tag) {
        if (!arrayByTag.containsKey(tag)) {
            arrayByTag.put(tag, tag.split("\\."));
        }

        array = arrayByTag.get(tag);
    }

    @Override
    public boolean MatchesTag(Tag tag) {
        int length = this.array.length;
        if (length > tag.array.length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (!this.array[i].equals(tag.array[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean MatchesTag(TagContainer container) {
        return false;
    }

    @Override
    public boolean MatchesTagExact(Tag tag) {
        return false;
    }

    @Override
    public boolean MatchesTagExact(TagContainer container) {
        return false;
    }

}
