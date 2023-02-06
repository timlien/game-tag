package com.tingshulien.game;

public interface TagQuery {

    /**
     * Determine if this tag matches TagToCheck, expanding our parent tags
     * "A.1".MatchesTag("A") will return True,
     * "A".MatchesTag("A.1") will return False
     * If TagToCheck is not Valid it will always return False
     *
     * @param other TagToCheck
     * @return True if this tag matches TagToCheck
     */
    boolean matchesTag(Tag other);

    /**
     * Determine if TagToCheck is valid and exactly matches this tag
     * "A.1".MatchesTagExact("A") will return False
     * If TagToCheck is not Valid it will always return False
     *
     * @param other TagToCheck
     * @return True if TagToCheck is Valid and is exactly this tag
     */
    boolean matchesTagExact(Tag other);

    /**
     * Checks if this tag matches ANY of the tags in the specified container, also checks against our parent tags
     * "A.1".MatchesAny({"A","B"}) will return True,
     * "A".MatchesAny({"A.1","B"}) will return False
     * If ContainerToCheck is empty/invalid it will always return False
     *
     * @param container ContainerToCheck
     * @return True if this tag matches ANY of the tags of in ContainerToCheck
     */
    boolean matchesAny(TagContainer container);

    /**
     * Checks if this tag matches ANY of the tags in the specified container, only allowing exact matches
     * "A.1".MatchesAny({"A","B"}) will return False
     * If ContainerToCheck is empty/invalid it will always return False
     *
     * @param container ContainerToCheck
     * @return True if this tag matches ANY of the tags of in ContainerToCheck exactly
     */
    boolean matchesAnyExact(TagContainer container);

}
