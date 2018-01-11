package entities;

import javax.persistence.*;


@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard {

    @Id
    @Column(name = "CREDIT_CARD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name = "CREDIT_CARD_TYPE")
    protected String creditCardType;
    @Column(name = "CREDIT_CARD_NUMBER")
    protected String creditCardNumber;
    @Column(name = "CREDIT_CARD_EXPIRY_DATE")
    protected String creditCardExpiryDate;

    public CreditCard() {}

    public CreditCard(String creditCardType, String creditCardNumber, String creditCardExpiryDate) {
        this.creditCardType = creditCardType;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpiryDate = creditCardExpiryDate;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardExpiryDate() {
        return creditCardExpiryDate;
    }

    public void setCreditCardExpiryDate(String creditCardExpiryDate) {
        this.creditCardExpiryDate = creditCardExpiryDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", creditCardType='" + creditCardType + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", creditCardExpiryDate='" + creditCardExpiryDate + '\'' +
                '}';
    }
}

