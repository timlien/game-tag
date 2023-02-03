package com.tingshulien.game;

public interface TagQuery {

    boolean MatchesTag(Tag tag);

    boolean MatchesTagExact(Tag tag);

    boolean MatchesAny(Tag tag);

    boolean MatchesAnyExact(Tag tag);

    boolean MatchesAll(Tag tag);

    boolean MatchesAllExactMatchesAll(Tag tag);

}
