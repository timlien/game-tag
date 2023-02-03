package com.tingshulien.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class TagNode {

    final String value;

    int overlap;

    final Map<String, TagNode> children;

    public TagNode(String value) {
        this.value = value;
        this.overlap = 1;
        this.children = new HashMap<>();
    }

    public boolean hasChildren(String value) {
        return children.containsKey(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TagNode tagNode = (TagNode) o;
        return Objects.equals(value, tagNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
