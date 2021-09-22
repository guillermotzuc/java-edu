package testcodes;

public class ExcelSecuence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getIndexColum("AAB".toLowerCase()));
	}
	
	static int getIndexColum(String column) {
	
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		char[] array = column.toCharArray();
		char[] alphabetArray = alphabet.toCharArray();
		int result = 0;
		
		if(array.length == 1){
			return alphabet.indexOf(column) + 1;
		}
		
		result += alphabet.indexOf(array[array.length - 1]) + 1;
		for(int i =0; i< array.length - 1; i++) {
			for(int j =0; j < alphabetArray.length; j ++){
				result+= (26 * (j + 1));
				if(array[i] == alphabetArray[j]){
					break;
				}
			}
		}
		return result;
	}

}
