package pc.appemp.isilenrollment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Product {
    private Integer sku;
    private String name;
    private Integer stock;
    private double price;
}
