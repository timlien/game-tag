package com.tingshulien.game;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class TagContainerTest {

    @Test
    void addTag() {
        TagContainer container = new TagContainer();

        Tag tag = new Tag("action.move");
        container.add(tag);
        container.remove(tag);

        assertThat(container.isEmpty(), is(true));
    }

}