package site.telion.citiclink.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ctl_additional_option")
@Data
@NoArgsConstructor
public class AdditionalOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProductType availableFor;

    @ManyToMany(mappedBy = "options")
    private Set<Product> products = new HashSet<>();
}
