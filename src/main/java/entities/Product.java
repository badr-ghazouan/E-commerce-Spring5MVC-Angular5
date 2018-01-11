package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    protected long id;
    @Column(name = "PRODUCT_NAME")
    protected String name;
    @Column(name = "PRODUCT_DESCRIPTION")
    protected String description;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_CATEGORY_FK",nullable = false)
    protected Category category;

    @OneToMany(mappedBy = "product" ,cascade = {CascadeType.ALL})
    @OrderBy("name ASC")
    protected List<Item> itemList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", itemList=" + itemList +
                '}';
    }
}
