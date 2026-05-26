package csd230.s26.lab1.pojos;

import java.io.Serializable;
import java.util.UUID;

// Marked abstract because it implements SaleableItem but doesn't implement getPrice()
// (Price is defined in children: Ticket and Publication)
public abstract class Product extends Editable implements SaleableItem, Serializable {
    private String productId;

    public Product() {
        // generate a default productID
        setProductId(UUID.randomUUID().toString());
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                "} ";
    }
}
