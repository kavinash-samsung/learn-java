package com.avinashh.vehicle;

/**
 * Bus
 */
public class Bus implements Vehicle{
    private DiscountService discountService;
    private Double maximumRetailPrice;
    public void setMaximumRetailPrice(Double maximumRetailPrice) {
        this.maximumRetailPrice = maximumRetailPrice;
    }
    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    private String brandName;

    public Bus(DiscountService discountService){
        this.discountService = discountService;
    }
    public Bus(){}
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