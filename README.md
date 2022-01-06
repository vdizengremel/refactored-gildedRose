# So what is it ?
This is a refactored GildedRose (see https://github.com/emilybache/GildedRose-Refactoring-Kata). I refactored in 2 different ways :
- one using inheritance
- one using composition

I think the one using composition is better because it does not change contract with Item class (same constructor).

If you imagine the Item class to be used in a bigger system, the inheritance solution would have impact at every code which needs to instantiate items.


# Hypothesis taken
The quality of an item is always between 0 and 50 whatever the type of item.
