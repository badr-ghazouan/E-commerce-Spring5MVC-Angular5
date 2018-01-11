package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    protected long id;
    @Column(name = "CUSTOMER_FIRST_NAME")
    protected String firstName;
    @Column(name = "CUSTOMER_LAST_NAME")
    protected String lastName;
    @Column(name = "CUSTOMER_TELEPHONE")
    protected String telephone;
    @Column(name = "CUSTOMER_PASSWORD")
    protected String password;
    @Column(name = "CUSTOMER_EMAIL")
    protected String email;
    @Column(name = "CUSTOMER_LOGIN")
    protected String login;
    @Column(name = "CUSTOMER_BIRTH_DATE")
    protected Date   birthDate;


    @OneToOne
    @JoinColumn(name = "CUSTOMER_ADDRESS_FK")
    protected Address address;

    public Customer() {}

    public Customer(String firstName, String lastName, String telephone, String password, String email, String login, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.password = password;
        this.email = email;
        this.login = login;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", birthDate=" + birthDate +
                ", address=" + address +
                '}';
    }
}
