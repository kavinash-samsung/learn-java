package com.avinashh.vehicle;

/**
 * Car
 */
public class Car implements Vehicle{

    private DiscountService discountService;
    private Double maximumRetailPrice;
    
    public void setMaximumRetailPrice(Double maximumRetailPrice) {
        this.maximumRetailPrice = maximumRetailPrice;
    }
    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    private String brandName;

    public Car(DiscountService discountService){
        this.discountService = discountService;
    }
    Car(){

    }

    @Override
    public String getMileage() {
        return "20KMPL";
    }

    @Override
    public String getDiscountMessage() {
        return this.discountService.getDiscountMessage();
    }

    @Override
    public String getBrandName() {
        return this.brandName;
    }
    @Override
    public Double getMaximumRetailPrice() {
        return this.maximumRetailPrice;
    }

    
}