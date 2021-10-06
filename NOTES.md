# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

The initial draft of the base design with some assumptions and can always be changed according to actual requirement.
- Basket now takes a DiscountService class which calculates the discounts applicable to all items in the basket and gives the total discount which can be then subtracted from the subtotal
- DiscountService will have list of different types of discount (lets say active discounts)
- We would create Different Discount classes and each class will have its own set of input criteria and evaluation strategy for the basket items
- Interface Discount which have evaluate() method that needs be implemented by different Discount classes
- The items might be eligible for different Discount strategy . We want single item to be eligible for Single discount strategy. So we can go with priority on each DiscountClass
  And once a Single discount is applied based on priority on an eligible item , we move the item to a consumed list so that double or tripple discounts(so on..) are not applied on single item

Implemention
Trying to implement One Discount Stratergy - Buy one kilo of vegetables for half price
called BuyXKGForPercntagePriceDiscount
Inputs -ListOfAllEligibleForDiscountItems (ASSUMPTION - THIS DISCOUNT IS VALID FOR CERTAIN WEIGHTED PRODUCTS)
       -minWeight (ASSUMPTION - X IN KG )
       -discountPercentage (ASSUMPTION -  DISCOUNT IS IN PERCENTAGE)

@ TODO's
The actual consumed and unconsumed item's logic can be checked when we have another Discount strategy
We can take this a based extend it for n number of Discount strategy with little tweaks
When we have Multiple discounts classes , We can Priority to discount classes and the active discount list is sorted by Priority
This design might change a bit if our assumption are different from actual requirements