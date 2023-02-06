package com.tingshulien.game;

import java.util.HashMap;
import java.util.Map;

public class TagContainer implements TagContainerQuery {

    final Map<String, TagNode> root;

    public TagContainer() {
        root = new HashMap<>();
    }

    public void addTag(Tag tag) {
        Map<String, TagNode> current = root;
        for (String value : tag.array) {
            TagNode node = find(value, current);

            if (node == null) {
                final TagNode newNode = new TagNode(value);
                current.put(value, newNode);
                current = newNode.children;
            } else {
                node.overlap += 1;
                current = node.children;
            }
        }
    }

    public void removeTag(Tag tag) {
        Map<String, TagNode> current = root;
        for (String value : tag.array) {
            TagNode node = find(value, current);

            if (node == null) {
                return;
            } else {
                node.overlap -= 1;
                if (node.overlap == 0) {
                    current.remove(value);
                } else {
                    current = node.children;
                }
            }
        }
    }

    private TagNode find(String value, Map<String, TagNode> current) {
        return current.get(value);
    }

    public boolean isEmpty() {
        return root.isEmpty();
    }

    @Override
    public boolean hasTag(Tag tag) {
        Map<String, TagNode> current = root;
        for (String value : tag.array) {
            TagNode node = find(value, current);

            if (node == null) {
                return false;
            } else {
                current = node.children;
            }
        }

        return true;
    }

    @Override
    public boolean hasTagExact(Tag tag) {
        Map<String, TagNode> current = root;
        for (String value : tag.array) {
            TagNode node = find(value, current);

            if (node == null) {
                return false;
            } else {
                current = node.children;
            }
        }

        return current.isEmpty();
    }

    @Override
    public boolean hasAll(TagContainer other) {
        return matchAll(this.root, other.root);
    }

    private boolean matchAll(Map<String, TagNode> parent, Map<String, TagNode> other) {
        if (other.isEmpty()) {
            return true;
        }

        for (TagNode otherNode : other.values()) {
            final TagNode parentNode = parent.get(otherNode.value);
            if (parentNode == null) {
                return false;
            }

            if (!matchAll(parentNode.children, otherNode.children)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean hasAllExact(TagContainer other) {
        if (other.isEmpty()) {
            return true;
        }

        return matchAllExact(this.root, other.root);
    }

    private boolean matchAllExact(Map<String, TagNode> parent, Map<String, TagNode> other) {
        for (TagNode otherNode : other.values()) {
            final TagNode parentNode = parent.get(otherNode.value);
            if (parentNode == null) {
                return false;
            }

            if (!matchAllExact(parentNode.children, otherNode.children)) {
                return false;
            }
        }

        if (!parent.isEmpty() && other.isEmpty()){
            return false;
        } else if (parent.isEmpty() && !other.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean hasAny(TagContainer other) {
        return matchAny(this.root, other.root);
    }

    private boolean matchAny(Map<String, TagNode> parent, Map<String, TagNode> other) {
        if (other.isEmpty()) {
            return true;
        }

        for (TagNode otherNode : other.values()) {
            final TagNode parentNode = parent.get(otherNode.value);
            if (parentNode == null) {
                return false;
            }

            if (matchAny(parentNode.children, otherNode.children)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean hasAnyExact(TagContainer other) {
        if (other.isEmpty()) {
            return true;
        }

        return matchAnyExact(this.root, other.root);
    }

    private boolean matchAnyExact(Map<String, TagNode> parent, Map<String, TagNode> other) {
        for (TagNode otherNode : other.values()) {
            final TagNode parentNode = parent.get(otherNode.value);
            if (parentNode == null) {
                return false;
            }

            if (!matchAny(parentNode.children, otherNode.children)) {
                return false;
            }
        }

        if (!parent.isEmpty() && other.isEmpty()){
            return false;
        } else if (parent.isEmpty() && !other.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValid() {
        return !isEmpty();
    }

}
