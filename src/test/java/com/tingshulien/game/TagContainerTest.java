package com.tingshulien.game;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class TagContainerTest {

    @Test
    void GivenFlatOtherTag_WhenInvokeHasTag_ThenReturnTrue() {
        TagContainer container = new TagContainer();
        Tag tag = new Tag("A.1");
        container.addTag(tag);

        Tag target = new Tag("A");

        boolean result = container.hasTag(target);

        assertThat(result, is(true));
    }

    @Test
    void GivenDeepOtherTag_WhenInvokeHasTag_ThenReturnFalse() {
        TagContainer container = new TagContainer();
        Tag tag = new Tag("A");
        container.addTag(tag);

        Tag target = new Tag("A.1");

        boolean result = container.hasTag(target);

        assertThat(result, is(false));
    }

    @Test
    void GivenSameOtherTag_WhenInvokeHasTag_ThenReturnTrue() {
        TagContainer container = new TagContainer();
        Tag tag = new Tag("A.1");
        container.addTag(tag);

        Tag target = new Tag("A.1");

        boolean result = container.hasTag(target);

        assertThat(result, is(true));
    }

    @Test
    void GivenDifferentOtherTag_WhenInvokeHasTag_ThenReturnFalse() {
        TagContainer container = new TagContainer();
        Tag tag = new Tag("A");
        container.addTag(tag);

        Tag target = new Tag("C");

        boolean result = container.hasTag(target);

        assertThat(result, is(false));
    }

    @Test
    void GivenEmptyOtherTag_WhenInvokeHasTag_ThenReturnFalse() {
        TagContainer container = new TagContainer();
        Tag tag = new Tag("A.1");
        container.addTag(tag);

        Tag target = new Tag("");

        boolean result = container.hasTagExact(target);

        assertThat(result, is(false));
    }

    @Test
    void GivenFlatOtherTag_WhenInvokeHasTagExact_ThenReturnFalse() {
        TagContainer container = new TagContainer();
        Tag tag = new Tag("A.1");
        container.addTag(tag);

        Tag target = new Tag("A");

        boolean result = container.hasTagExact(target);

        assertThat(result, is(false));
    }

    @Test
    void GivenDeepOtherTag_WhenInvokeHasTagExact_ThenReturnFalse() {
        TagContainer container = new TagContainer();
        Tag tag = new Tag("A");
        container.addTag(tag);

        Tag target = new Tag("A.1");

        boolean result = container.hasTagExact(target);

        assertThat(result, is(false));
    }

    @Test
    void GivenSameOtherTag_WhenInvokeHasTagExact_ThenReturnTrue() {
        TagContainer container = new TagContainer();

        Tag tag = new Tag("A.1");
        container.addTag(tag);

        Tag target = new Tag("A.1");

        boolean result = container.hasTagExact(target);

        assertThat(result, is(true));
    }

    @Test
    void GivenDifferentOtherTag_WhenInvokeHasTagExact_ThenReturnFalse() {
        TagContainer container = new TagContainer();

        Tag tag = new Tag("A");
        container.addTag(tag);

        Tag target = new Tag("C");

        boolean result = container.hasTagExact(target);

        assertThat(result, is(false));
    }

    @Test
    void GivenEmptyOtherTag_WhenInvokeHasTagExact_ThenReturnFalse() {
        TagContainer container = new TagContainer();

        Tag tag = new Tag("A.1");
        container.addTag(tag);

        Tag target = new Tag("");

        boolean result = container.hasTagExact(target);

        assertThat(result, is(false));
    }

    @Test
    void GivenFlatOtherContainer_WhenInvokeHasAll_ThenReturnTrue() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));
        parent.addTag(new Tag("B.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A"));
        other.addTag(new Tag("B"));

        boolean result = parent.hasAll(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenDeepOtherContainer_WhenInvokeHasAll_ThenReturnFalse() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A"));
        parent.addTag(new Tag("B"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));
        other.addTag(new Tag("B.1"));

        boolean result = parent.hasAll(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenLessOtherContainer_WhenInvokeHasAll_ThenReturnTrue() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));
        parent.addTag(new Tag("B.1"));
        parent.addTag(new Tag("C.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A"));
        other.addTag(new Tag("B.1"));

        boolean result = parent.hasAll(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenMoreOtherContainer_WhenInvokeHasAll_ThenReturnFalse() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));
        parent.addTag(new Tag("B.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A"));
        other.addTag(new Tag("B.1"));
        other.addTag(new Tag("C.1"));

        boolean result = parent.hasAll(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenSameOtherContainer_WhenInvokeHasAll_ThenReturnTrue() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));
        parent.addTag(new Tag("B.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));
        other.addTag(new Tag("B.1"));

        boolean result = parent.hasAll(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenDifferentOtherContainer_WhenInvokeHasAll_ThenReturnFalse() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A"));
        parent.addTag(new Tag("B"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("C"));

        boolean result = parent.hasAll(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenFlatOtherContainer_WhenInvokeHasAllExact_ThenReturnFalse() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));
        parent.addTag(new Tag("B.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A"));
        other.addTag(new Tag("B"));

        boolean result = parent.hasAllExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenDeepOtherContainer_WhenInvokeHasAllExact_ThenReturnFalse() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A"));
        parent.addTag(new Tag("B"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));
        other.addTag(new Tag("B.1"));

        boolean result = parent.hasAllExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenLessOtherContainer_WhenInvokeHasAllExact_ThenReturnTrue() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));
        parent.addTag(new Tag("B.1"));
        parent.addTag(new Tag("C.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));
        other.addTag(new Tag("B.1"));

        boolean result = parent.hasAllExact(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenMoreOtherContainer_WhenInvokeHasAllExact_ThenReturnFalse() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));
        parent.addTag(new Tag("B.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));
        other.addTag(new Tag("B.1"));
        other.addTag(new Tag("C.1"));

        boolean result = parent.hasAllExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenSameOtherContainer_WhenInvokeHasAllExact_ThenReturnTrue() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));
        parent.addTag(new Tag("B.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));
        other.addTag(new Tag("B.1"));

        boolean result = parent.hasAll(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenDifferentOtherContainer_WhenInvokeHasAllExact_ThenReturnFalse() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));
        parent.addTag(new Tag("B.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("C"));

        boolean result = parent.hasAllExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenEmptyOtherContainer_WhenInvokeHasAllExact_ThenReturnTrue() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));
        parent.addTag(new Tag("B.1"));

        TagContainer other = new TagContainer();

        boolean result = parent.hasAllExact(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenEmptyTagParentContainer_WhenInvokeHasAllExact_ThenReturnFalse() {
        TagContainer parent = new TagContainer();

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));
        other.addTag(new Tag("B.1"));

        boolean result = parent.hasAllExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenFlatOtherContainer_WhenInvokeHaAny_ThenReturnTrue() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A"));
        other.addTag(new Tag("B"));

        boolean result = parent.hasAny(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenDeepOtherContainer_WhenInvokeHaAny_ThenReturnFalse() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));
        other.addTag(new Tag("B.1"));

        boolean result = parent.hasAny(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenSameOtherContainer_WhenInvokeHasAny_ThenReturnTrue() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));

        boolean result = parent.hasAny(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenDifferentOtherContainer_WhenInvokeHaAny_ThenReturnFalse() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("B"));

        boolean result = parent.hasAny(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenEmptyOtherContainer_WhenInvokeHaAny_ThenReturnTrue() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));

        TagContainer other = new TagContainer();

        boolean result = parent.hasAny(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenEmptyParentContainer_WhenInvokeHaAny_ThenReturnFalse() {
        TagContainer parent = new TagContainer();

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));

        boolean result = parent.hasAny(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenFlatOtherContainer_WhenInvokeHaAnyExact_ThenReturnFalse() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A"));
        other.addTag(new Tag("B"));

        boolean result = parent.hasAnyExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenDeepOtherContainer_WhenInvokeHaAnyExact_ThenReturnFalse() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));
        other.addTag(new Tag("B.1"));

        boolean result = parent.hasAnyExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenSameOtherContainer_WhenInvokeHasAnyExact_ThenReturnTrue() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));

        boolean result = parent.hasAnyExact(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenDifferentOtherContainer_WhenInvokeHaAnyExact_ThenReturnFalse() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A"));

        TagContainer other = new TagContainer();
        other.addTag(new Tag("B"));

        boolean result = parent.hasAnyExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenEmptyOtherContainer_WhenInvokeHaAnyExact_ThenReturnTrue() {
        TagContainer parent = new TagContainer();
        parent.addTag(new Tag("A.1"));

        TagContainer other = new TagContainer();

        boolean result = parent.hasAnyExact(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenEmptyParentContainer_WhenInvokeHaAnyExact_ThenReturnFalse() {
        TagContainer parent = new TagContainer();

        TagContainer other = new TagContainer();
        other.addTag(new Tag("A.1"));

        boolean result = parent.hasAnyExact(other);

        assertThat(result, is(false));
    }

}