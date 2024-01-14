package enums;

public enum Months {

	January("01"),
	February("02"),
	March("03"),
	April("04"),
	May("05"),
	June("06"),
	July("07"),
	August("08"),
	September("09"),
	October("10"),
	November("11"),
	December("12");
	
	private String value;
    private Months(String value) {
        this.value = value;	
    }
    public String getValue() {
        return value;
    }
    
   
}
