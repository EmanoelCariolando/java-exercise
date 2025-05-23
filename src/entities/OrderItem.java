package entities;

import java.awt.color.ProfileDataException;

public class OrderItem {
    private Integer quantity;
    private Product product;

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getTotal(){
        return this.quantity * this.product.getPrice();
    }

    @Override
    public String toString() {
        return product + "," + "quantity: " +  quantity + "," + "subTotal: $" + getTotal() ;
    }
}
