package entities;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_LINE")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_LINE_ID")
    protected long id;
    @Column(name = "ORDER_LINE_QUANTITY",nullable = false)
    protected long quantity;

    @OneToOne
    @JoinColumn(name = "ORDER_LINE_ITEM_FK",nullable = false)
    protected Item item;

    public OrderLine() {}

    public OrderLine(long quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", item=" + item +
                '}';
    }
}
