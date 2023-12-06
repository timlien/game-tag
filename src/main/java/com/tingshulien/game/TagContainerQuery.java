package com.tingshulien.game;

public interface TagContainerQuery {

    boolean has(Tag tag);

    boolean hasExact(Tag tag);

    /**
     * Checks if this container contains all the tags in the specified container, also checks against parent tags
     * {"A.1","B.1"}.HasAll({"A","B"}) will return true,
     * {"A","B"}.HasAll({"A.1","B.1"}) will return false.
     * If ContainerToCheck is empty/invalid it will always return true, because there were no failed checks
     *
     * @param other ContainerToCheck
     * @return true if this container has all the tags of in ContainerToCheck, including if ContainerToCheck is empty
     */
    boolean hasAll(TagContainer other);

    /**
     * Checks if this container contains all the tags in the specified container, only allowing exact matches
     * {"A.1","B.1"}.HasAll({"A","B"}) will return false.
     * If ContainerToCheck is empty/invalid it will always return true, because there were no failed checks
     *
     * @param other ContainerToCheck
     * @return true if this container has all the tags of in ContainerToCheck, including if ContainerToCheck is empty
     */
    boolean hasAllExact(TagContainer other);

    /**
     * Checks if this container contains any of the tags in the specified container, also checks against parent tags
     * {"A.1"}.HasAny({"A","B"}) will return true,
     * {"A"}.HasAny({"A.1","B"}) will return false.
     * If ContainerToCheck is empty/invalid it will always return False
     *
     * @param other ContainerToCheck
     * @return true if this container has any of the tags of in ContainerToCheck
     */
    boolean hasAny(TagContainer other);

    /**
     * Checks if this container contains any of the tags in the specified container, only allowing exact matches
     * {"A.1"}.HasAny({"A","B"}) will return false.
     * If ContainerToCheck is empty/invalid it will always return false.
     *
     * @param other ContainerToCheck
     * @return true if this container has any of the tags of in ContainerToCheck
     */
    boolean hasAnyExact(TagContainer other);

}
