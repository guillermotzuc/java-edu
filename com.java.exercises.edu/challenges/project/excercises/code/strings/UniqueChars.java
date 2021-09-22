package project.excercises.code.strings;

public class UniqueChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(areUniqueChars("99"));
		System.out.println(areUniqueChars("1903aio9p"));
		System.out.println(areUniqueChars("29"));

	}

	public static boolean areUniqueChars(String str) {
		
		if(str.length() > 128) {
			
			return false;
		}
		
		boolean[] booleans = new boolean[128];
		for(int idx =0; idx <str.length();idx++) {
			
			int value = str.charAt(idx);
			if(booleans[value]) {
				
				return false;
			}
			
			booleans[value] = true;
		}
		
		return true;
	}
}
