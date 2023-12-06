## About Game Tag

---

Game Tags are conceptual, hierarchical labels with user-defined names. These tags can have any number of hierarchical levels, separated by
the "." character; for example, a Game Tag with three levels would take the form of "Family.Genus.Species", with "Family" being the broadest
identifier in the hierarchy, and "Species" being the most specific. Note that the existence of "Family.Genus.Species" implicitly means
that "Family.Genus" and "Family" Game Tags also exist.

Individual tags are lightweight and use the type Tag. Since game objects frequently have multiple tags, Game Tag Containers (using the type
TagContainer) are provided and can handle a variety of additional queries. Game Tags (or Game Tag Containers) can be added to any project,
associating objects with conceptual labels that can then be used to identify, match, categorize, or filter them (as needed) for your
project.

## Game Tag Test Operations

---

There are a number of test operations, all based on the concept of matching tags to other tags, that can be performed on Game Tags and Game
Tag Containers. Each of these functions will be called on a Game Tag or Game Tag Container and will take a single Game Tag or Game Tag
Container as a parameter.

The following table details the operations available for tags and tag containers. In this table, the format "A.1" represents a single Game
Tag, while "{A.1}" represents that same tag as part of a Game Tag Container. A container with multiple tags will be of the format "{A.1,
B.1}".

| Source     | Function/Operation | Input Parameter | Return Value |
|------------|--------------------|-----------------|--------------|
| A.1        | MatchesTag         | A               | true         |
| A.1        | MatchesTagExact    | A               | false        |
| A.1        | MatchesAny         | {A, C}          | true         |
| A.1        | MatchesAnyExact    | {A, C}          | false        |
| {A.1, B.1} | HasTag             | A               | true         |
| {A.1, B.1} | HasTagExact        | A               | false        |
| {A.1, B.1} | HasAny             | {A, C}          | true         |
| {A.1, B.1} | HasAnyExact        | {A, C}          | false        |
| {A.1, B.1} | HasAll             | {A, B}          | true         |
| {A.1, B.1} | HasAllExact        | {A, B}          | false        |

Note that providing empty or default Game Tag Containers as the input parameter will cause all operations to return false, except for
HasAll, HasAllExact, MatchesAll, and MatchesAllExact. The justification for this is that there are no tags in the parameter container that
are missing from the source set.