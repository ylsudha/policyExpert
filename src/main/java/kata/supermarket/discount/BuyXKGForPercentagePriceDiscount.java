package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.WeighedProduct;

import java.math.BigDecimal;
import java.util.List;

public class BuyXKGForPercentagePriceDiscount  implements Discount{
    private List<WeighedProduct> discountEligibleProductList;
    private BigDecimal minWeight;
    private BigDecimal discountPercent;


    public BuyXKGForPercentagePriceDiscount(List<WeighedProduct> discountEligibleProductList, BigDecimal minWeight, BigDecimal discountPercent) {

        this.discountEligibleProductList = discountEligibleProductList;
        this.minWeight = minWeight;
        this.discountPercent = discountPercent;
    }

    @Override
    public BigDecimal evaluate(List<Item> consumedEntries, List<Item> unconsumedEntries) {
        return BigDecimal.valueOf(5);
    }
}
