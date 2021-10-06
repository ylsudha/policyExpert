package kata.supermarket;

import kata.supermarket.discount.Discount;
import kata.supermarket.discount.DiscountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketDiscountTest {

    @DisplayName("basket provides its total value when containing discounts...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValueAfterDiscount(String description, String expectedTotal, Iterable<Item> items , DiscountService discountService) {
        final Basket basket = new Basket();
        basket.setDiscountService(discountService);
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValueAfterDiscount() {
        return Stream.of(
                singleVegetableItemPriceByWeightWithNoActiveDiscounts());

    }

    private static Arguments singleVegetableItemPriceByWeightWithNoActiveDiscounts() {
        return Arguments.of("a single weighed vegetable item", "10.00",
                Collections.singleton(twoKiloOfVegetableProduct(aKiloOfVegetableProduct())),
                getDiscountService(Collections.emptyList())
        );
    }

    private static WeighedProduct aKiloOfVegetableProduct() {
        return new WeighedProduct(new BigDecimal("5.00"));
    }

    private static Item twoKiloOfVegetableProduct(WeighedProduct aKiloOfVegetableProduct) {
       return aKiloOfVegetableProduct.weighing(new BigDecimal("2.00"));
    }

    private static DiscountService getDiscountService(List<Discount> activeDiscounts){
        DiscountService discountService= new DiscountService();
        discountService.setActiveDiscounts(activeDiscounts);
        return discountService;
    }



}