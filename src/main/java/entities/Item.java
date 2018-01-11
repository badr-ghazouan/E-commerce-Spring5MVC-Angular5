package entities;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    protected long id;
    @Column(name = "ITEM_NAME")
    protected String name;
    @Column(name = "ITEM_UNIT_COST")
    protected double unitCost;
    @Column(name = "ITEM_IMAGE_PATH")
    protected String imagePATH;

    @ManyToOne
    @JoinColumn(name = "ITEM_PRODUCT_FK",nullable = false)
    protected Product product;



    public Item() {}

    public Item(String name, double unitCost, String imagePATH) {
        this.name = name;
        this.unitCost = unitCost;
        this.imagePATH = imagePATH;
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

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public String getImagePATH() {
        return imagePATH;
    }

    public void setImagePATH(String imagePATH) {
        this.imagePATH = imagePATH;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitCost=" + unitCost +
                ", imagePATH='" + imagePATH + '\'' +
                ", product=" + product +
                '}';
    }
}
