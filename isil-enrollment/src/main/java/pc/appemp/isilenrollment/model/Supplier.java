package pc.appemp.isilenrollment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Supplier {
    private Integer ruc;
    private String name;
    private String contactEmail;
    private String contactMobilePhone;
    //private ArrayList products= new ArrayList(Product);
}
