package TMRS.pojos;

public class gradingFormat {
	private static int formatId;
	private static String description;
	
	
	public static int getFormatId() {
		return formatId;
	}
	public static void setFormatId(int formatId) {
		gradingFormat.formatId = formatId;
	}
	
	
	public static String getDescription() {
		return description;
	}
	public static void setDescription(String description) {
		gradingFormat.description = description;
	}
}
