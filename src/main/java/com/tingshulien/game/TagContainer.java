package com.tingshulien.game;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.unrealengine.com/4.27/en-US/API/Runtime/GameplayTags/FGameplayTagContainer/
 */
public class TagContainer {

    List<TagNode> root;

    public TagContainer() {
        root = new ArrayList<>();
    }

    public void add(Tag tag) {
        List<TagNode> nodes = root;
        for (String value : tag.array) {
            TagNode node = find(value, nodes);

            if (node == null) {
                final TagNode newNode = new TagNode(value);
                nodes.add(newNode);
                nodes = newNode.children;
            } else {
                node.overlap += 1;
                nodes = node.children;
            }
        }
    }

    public void remove(Tag tag) {
        List<TagNode> nodes = root;
        for (String value : tag.array) {
            TagNode node = find(value, nodes);

            if (node == null) {
                return;
            } else {
                node.overlap -= 1;
                if (node.overlap == 0) {
                    nodes.remove(node);
                } else {
                    nodes = node.children;
                }
            }
        }
    }

    TagNode find(String value, List<TagNode> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        for (TagNode node : nodes) {
            if (value.equals(node.value)) {
                return node;
            }
        }

        return null;
    }

    public boolean isEmpty() {
        return root.isEmpty();
    }

}
