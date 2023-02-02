package com.tingshulien.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class TagNode {

    final String value;

    int overlap;

    final List<TagNode> children;

    public TagNode(String value) {
        this.value = value;
        this.overlap = 1;
        this.children = new ArrayList<>();
    }

    public boolean hasChildren(String value) {
        for (TagNode child : children) {
            if (value.equals(child.value)) {
                return true;
            }
        }

        return false;
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
