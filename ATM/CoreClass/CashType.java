package CoreClass;
public enum CashType {
    FIVE(5), TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);
    private final int value;
    CashType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    
}
