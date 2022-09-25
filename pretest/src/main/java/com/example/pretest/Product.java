package com.example.pretest;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Product")
public class Product {
    @Id
    private String _id;
    private String productName;
    private Double productCost;
    private Double productProfit;
    private Double productPrice;

    public Product() {
    }

    public Product(String _id, String productName, Double productCost, Double productProfit, Double productPrice) {
        this._id = _id;
        this.productName = productName;
        this.productCost = productCost;
        this.productProfit = productProfit;
        this.productPrice = productPrice;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }

    public Double getProductProfit() {
        return productProfit;
    }

    public void setProductProfit(Double productProfit) {
        this.productProfit = productProfit;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
