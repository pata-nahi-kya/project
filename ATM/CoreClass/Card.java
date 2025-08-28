package CoreClass;
public class Card {
    String cardNumber;
    int pin;
    String accountNumber;
    Card(String cardNumber, int pin, String accountNumber) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public boolean validatePin(int inputPin) {
        return this.pin == inputPin;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
}
