package Common;

public class Util {
	public static boolean StringEquals(String val1, String val2) {
		if (val1 == null) {
			return false;
		}
		if (val2 == null) {
			return false;
		}
		return val1.equals(val2);
	}

	public static boolean StringIsEmptyOrNull(String val) {
		if (val == null) {
			return true;
		}
		if (val.trim().length() == 0) {
			return true;
		}
		return false;
	}
}
