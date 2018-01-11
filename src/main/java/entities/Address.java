package entities;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    protected long id;
    @Column(name = "ADDRESS_CITY")
    protected String city;
    @Column(name = "ADDRESS_STATE")
    protected String state;
    @Column(name = "ADDRESS_STREET_1")
    protected String street1;
    @Column(name = "ADDRESS_STREET_2")
    protected String street2;
    @Column(name = "ADDRESS_STREET_ZIP_CODE")
    protected String zipCode;
    @Column(name = "ADDRESS_COUNTRY")
    protected String country;



    public Address() {}

    public Address(String city, String state, String street1, String street2, String zipCode, String country) {
        this.city = city;
        this.state = state;
        this.street1 = street1;
        this.street2 = street2;
        this.zipCode = zipCode;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
