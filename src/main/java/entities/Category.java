package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    protected long id;
    @Column(name = "CATEGORY_NAME")
    protected String name;
    @Column(name = "CATEGORY_DESCRIPTION")
    protected String description;

    @OneToMany(mappedBy = "category",cascade = {CascadeType.ALL},
                fetch = FetchType.LAZY)
    @OrderBy("name ASC")
    protected List<Product> productList;


    public Category() {}

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

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
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", productList=" + productList +
                '}';
    }
}
