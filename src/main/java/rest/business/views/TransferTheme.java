package rest.business.views;

public class TransferTheme {
	private String themeName;
	
	private double average;

	public TransferTheme(String themeName, double average) {
	        this.themeName = themeName;
	        this.average = average;
	    }

	public String getThemeName() {
		return themeName;
	}
	
	public double getAverage() {
		return average;
	}
	
	 @Override
	    public String toString() {
	        return "ThemeTransfer [themeName=" + themeName + ", average=" + average + "]"; 
	    }
}
