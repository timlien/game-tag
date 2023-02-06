package com.tingshulien.game;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class TagTest {

    @Test
    void GivenFlatOtherTag_WhenInvokeMatchesTag_ThenReturnTrue() {
        Tag tag = new Tag("A.1");
        Tag other = new Tag("A");

        boolean result = tag.matchesTag(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenDeepOtherTag_WhenInvokeMatchesTag_ThenReturnFalse() {
        Tag tag = new Tag("A");
        Tag other = new Tag("A.1");

        boolean result = tag.matchesTag(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenSameOtherTag_WhenInvokeMatchesTag_ThenReturnTrue() {
        Tag tag = new Tag("A.1");
        Tag other = new Tag("A.1");

        boolean result = tag.matchesTag(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenDifferentOtherTag_WhenInvokeMatchesTag_ThenReturnFalse() {
        Tag tag = new Tag("A");
        Tag other = new Tag("C");

        boolean result = tag.matchesTag(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenEmptyOtherTag_WhenInvokeMatchesTag_ThenReturnFalse() {
        Tag tag = new Tag("A");
        Tag other = new Tag("");

        boolean result = tag.matchesTag(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenFlatOtherTag_WhenInvokeMatchesTagExact_ThenReturnFalse() {
        Tag tag = new Tag("A.1");
        Tag other = new Tag("A");

        boolean result = tag.matchesTagExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenDeepOtherTag_WhenInvokeMatchesTagExact_ThenReturnFalse() {
        Tag tag = new Tag("A");
        Tag other = new Tag("A.1");

        boolean result = tag.matchesTagExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenSameOtherTag_WhenInvokeMatchesTagExact_ThenReturnTrue() {
        Tag tag = new Tag("A.1");
        Tag other = new Tag("A.1");

        boolean result = tag.matchesTagExact(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenDifferentOtherTag_WhenInvokeMatchesTagExact_ThenReturnFalse() {
        Tag tag = new Tag("A");
        Tag other = new Tag("C");

        boolean result = tag.matchesTagExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenEmptyOtherTag_WhenInvokeMatchesTagExact_ThenReturnFalse() {
        Tag tag = new Tag("A");
        Tag other = new Tag("");

        boolean result = tag.matchesTagExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenFlatOtherContainer_WhenInvokeMatchesTagAny_ThenReturnTrue() {
        Tag tag = new Tag("A.1");

        TagContainer other = new TagContainer();
        Tag flatOneTag = new Tag("A");
        Tag flatTwoTag = new Tag("B");
        other.addTag(flatOneTag);
        other.addTag(flatTwoTag);

        boolean result = tag.matchesAny(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenDeepOtherContainer_WhenInvokeMatchesTagAny_ThenReturnFalse() {
        Tag tag = new Tag("A");

        TagContainer other = new TagContainer();
        Tag deepOneTag = new Tag("A.1");
        Tag deepTwoTag = new Tag("B.1");
        other.addTag(deepOneTag);
        other.addTag(deepTwoTag);

        boolean result = tag.matchesAny(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenSameOtherContainer_WhenInvokeMatchesTagAny_ThenReturnTrue() {
        Tag tag = new Tag("A.1");

        TagContainer other = new TagContainer();
        Tag sameOneTag = new Tag("A.1");
        Tag sameTwoTag = new Tag("B.1");
        other.addTag(sameOneTag);
        other.addTag(sameTwoTag);

        boolean result = tag.matchesAny(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenDifferentOtherContainer_WhenInvokeMatchesTagAny_ThenReturnFalse() {
        Tag tag = new Tag("A");

        TagContainer other = new TagContainer();
        Tag differentOneTag = new Tag("B");
        Tag differentTwoTag = new Tag("C");
        other.addTag(differentOneTag);
        other.addTag(differentTwoTag);

        boolean result = tag.matchesAny(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenEmptyParentTag_WhenInvokeMatchesTagAny_ThenReturnFalse() {
        Tag tag = new Tag("");

        TagContainer other = new TagContainer();
        Tag otherOneTag = new Tag("A");
        Tag otherTwoTag = new Tag("B");
        other.addTag(otherOneTag);
        other.addTag(otherTwoTag);

        boolean result = tag.matchesAny(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenEmptyOtherContainer_WhenInvokeMatchesTagAny_ThenReturnFalse() {
        Tag tag = new Tag("A");

        TagContainer other = new TagContainer();

        boolean result = tag.matchesAny(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenFlatOtherContainer_WhenInvokeMatchesTagAnyExact_ThenReturnFalse() {
        Tag tag = new Tag("A.1");

        TagContainer other = new TagContainer();
        Tag flatOneTag = new Tag("A");
        Tag flatTwoTag = new Tag("B");
        other.addTag(flatOneTag);
        other.addTag(flatTwoTag);

        boolean result = tag.matchesAnyExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenDeepOtherContainer_WhenInvokeMatchesTagAnyExact_ThenReturnFalse() {
        Tag tag = new Tag("A");

        TagContainer other = new TagContainer();
        Tag deepOneTag = new Tag("A.1");
        Tag deepTwoTag = new Tag("B.1");
        other.addTag(deepOneTag);
        other.addTag(deepTwoTag);

        boolean result = tag.matchesAnyExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenSameOtherContainer_WhenInvokeMatchesTagAnyExact_ThenReturnTrue() {
        Tag tag = new Tag("A.1");

        TagContainer other = new TagContainer();
        Tag sameOneTag = new Tag("A.1");
        Tag sameTwoTag = new Tag("B.1");
        other.addTag(sameOneTag);
        other.addTag(sameTwoTag);

        boolean result = tag.matchesAnyExact(other);

        assertThat(result, is(true));
    }

    @Test
    void GivenDifferentOtherContainer_WhenInvokeMatchesTagAnyExact_ThenReturnFalse() {
        Tag tag = new Tag("A");

        TagContainer other = new TagContainer();
        Tag differentOneTag = new Tag("B");
        Tag differentTwoTag = new Tag("C");
        other.addTag(differentOneTag);
        other.addTag(differentTwoTag);

        boolean result = tag.matchesAnyExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenEmptyParentTag_WhenInvokeMatchesTagAnyExact_ThenReturnFalse() {
        Tag tag = new Tag("");

        TagContainer other = new TagContainer();
        Tag otherOneTag = new Tag("A");
        Tag otherTwoTag = new Tag("B");
        other.addTag(otherOneTag);
        other.addTag(otherTwoTag);

        boolean result = tag.matchesAnyExact(other);

        assertThat(result, is(false));
    }

    @Test
    void GivenEmptyOtherContainer_WhenInvokeMatchesTagAnyExact_ThenReturnFalse() {
        Tag tag = new Tag("A");

        TagContainer other = new TagContainer();

        boolean result = tag.matchesAnyExact(other);

        assertThat(result, is(false));
    }

}