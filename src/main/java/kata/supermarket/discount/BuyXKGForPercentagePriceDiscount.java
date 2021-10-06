package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.ItemByWeight;
import kata.supermarket.WeighedProduct;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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
    public BigDecimal evaluate(List<Item> unconsumedEntries, List<Item> consumedEntries) {
        List<Item> promotionAppliedList = new ArrayList<>();
        BigDecimal discount =  unconsumedEntries.stream()
                .filter(item -> item instanceof ItemByWeight)
                .filter(item -> discountEligibleProductList.contains(item.product()))
                .filter(item -> ((ItemByWeight) item).weightInKilos().compareTo(minWeight) >= 0)
                .map(item -> {
                    promotionAppliedList.add(item);
                    return item.price().multiply(discountPercent.divide(BigDecimal.valueOf(100)));
                })
                .reduce(BigDecimal.ZERO,BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
        unconsumedEntries.removeAll(promotionAppliedList);
        consumedEntries.addAll(promotionAppliedList);
        return discount;
    }
}
