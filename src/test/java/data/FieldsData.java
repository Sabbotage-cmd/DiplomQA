package data;

public class FieldsData {
    private String cardNumber;
    private String month;
    private String year;
    private String cardHolder;
    private String CVV;

    public FieldsData(String cardNumber, String month, String year, String cardHolder, String CVV) {
        this.cardNumber = cardNumber;
        this.month = month;
        this.year = year;
        this.cardHolder = cardHolder;
        this.CVV = CVV;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getCVV() {
        return CVV;
    }
}