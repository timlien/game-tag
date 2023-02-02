package com.tingshulien.game;

public interface TagQuery {

    boolean MatchesTag(Tag tag);

    boolean MatchesTag(TagContainer container);

    boolean MatchesTagExact(Tag tag);

    boolean MatchesTagExact(TagContainer container);

}
