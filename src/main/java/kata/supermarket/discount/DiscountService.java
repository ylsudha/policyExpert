package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class DiscountService {
    private List<Discount> activeDiscounts;

    public void setActiveDiscounts(final List<Discount> activeDiscounts) {
        this.activeDiscounts = activeDiscounts;
    }

    public BigDecimal getTotalDiscounts(List<Item> items) {
        return BigDecimal.ZERO;
    }
}
