package com.example.unity.discount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSet {
    private List<Product> productList;
    private double discount;

    public void calculateDiscounts() {
        calculateDiscountForEveryProduct();
        addDiscountRemainderToLastProductDiscount();
    }

    private void calculateDiscountForEveryProduct() {
        double allProductPrices = sumAllProductPrices();

        this.getProductList().forEach(product -> {
            double discountForProduct = (product.getPrice() / allProductPrices) * this.discount;
            product.setDiscount(Precision.round(discountForProduct, 2));
        });


    }

    private void addDiscountRemainderToLastProductDiscount() {
        double discountRemainder = calculateDiscountRemainder();

        if (discountRemainder > 0) {
            this.productList
                    .get(productList.size() - 1)
                    .setDiscount(Precision.round(getDiscount() + discountRemainder, 2));
        }
    }

    private double calculateDiscountRemainder() {
        return this.discount - sumAllProductDiscounts();
    }

    public double sumAllProductPrices() {
        return productList.stream().mapToDouble(Product::getPrice).sum();
    }

    public double sumAllProductDiscounts() {
        return productList.stream().mapToDouble(Product::getDiscount).sum();
    }
}
