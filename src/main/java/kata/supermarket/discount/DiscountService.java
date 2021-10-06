package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiscountService {
    private List<Discount> activeDiscounts;

    public void setActiveDiscounts(final List<Discount> activeDiscounts) {
        this.activeDiscounts = activeDiscounts;
    }

    public BigDecimal getTotalDiscounts(List<Item> items) {
        List<Item> unconsumedEntries = new ArrayList<>(items);
        List<Item> consumedEntries = new ArrayList<>();
        return activeDiscounts.stream().map(discount -> discount.evaluate(unconsumedEntries,consumedEntries)).reduce(BigDecimal.ZERO,BigDecimal::add);

    }
}
