package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    protected long id;
    @Column(name = "ORDER_ORDER_DATE")
    protected Date orderDate;

    @ManyToOne
    @JoinColumn(name = "ORDER_CUSTOMER_FK")
    protected Customer customer;

    @OneToOne
    @JoinColumn(name = "ORDER_ADDRESS_FK")
    protected Address address;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "ORDER_ORDER_LINE",
    joinColumns = {@JoinColumn(name = "ORDER_FK")},
    inverseJoinColumns = {@JoinColumn(name = "ORDER_LINE_FK")})
    protected List<OrderLine> orderLineList;

    public Order() {}

    public Order(Date orderDate, String creditCardType, String creditCardNumber, String creditCardExpiryDate) {
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", address=" + address +
                ", orderLineList=" + orderLineList +
                '}';
    }
}
