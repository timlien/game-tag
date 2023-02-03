package com.tingshulien.game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Tag implements TagQuery {

    private static final Map<String, String[]> arrayByTag = new ConcurrentHashMap<>();

    final String[] array;

    public Tag(String tag) {
        if (!arrayByTag.containsKey(tag)) {
            arrayByTag.put(tag, tag.split("\\."));
        }

        array = arrayByTag.get(tag);
    }

    @Override
    public boolean MatchesTag(Tag tag) {
        return false;
    }

    @Override
    public boolean MatchesTagExact(Tag tag) {
        return false;
    }

    @Override
    public boolean MatchesAny(Tag tag) {
        return false;
    }

    @Override
    public boolean MatchesAnyExact(Tag tag) {
        return false;
    }

    @Override
    public boolean MatchesAll(Tag tag) {
        return false;
    }

    @Override
    public boolean MatchesAllExactMatchesAll(Tag tag) {
        return false;
    }

}
