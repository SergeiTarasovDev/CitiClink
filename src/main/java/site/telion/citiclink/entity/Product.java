package site.telion.citiclink.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ctl_product")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProductType typeId;

    private String name;
    private String seriasNumber;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
    private BigDecimal price;
    private Integer stock;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "ctl_product_option",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id"))
    private Set<AdditionalOption> options = new HashSet<>();

    public void addOption(AdditionalOption option) {
        this.options.add(option);
        option.getProducts().add(this);
    }

    public void removeOption(AdditionalOption option) {
        this.options.remove(option);
        option.getProducts().remove(this);
    }
}
