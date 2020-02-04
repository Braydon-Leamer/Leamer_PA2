import java.util.Scanner;

public class Decrypter {
	static void decrypt() {
		
		//Takes input from the user and parses the string input into an integer array
		System.out.println("Input the 4 digit code to be decrypted: ");
		Scanner s = new Scanner(System.in);
		int UserInput = s.nextInt();
		//System.out.println(UserInput);
		String parseNum = Integer.toString(UserInput);
		String code[] = parseNum.split("");		
		int DecryptedCode[] = new int[4];
		int i;
		
		for(i = 0; i < code.length; i++) {
			DecryptedCode[i] = Integer.parseInt(code[i]);
		}
		
		//Switches the first and third along with second and fourth numbers with each other
		int tempNum = 0;
		
		tempNum = DecryptedCode[0];
		DecryptedCode[0] = DecryptedCode[2];
		DecryptedCode[2] = tempNum;
		
		tempNum = DecryptedCode[1];
		DecryptedCode[1] = DecryptedCode[3];
		DecryptedCode[3] = tempNum;
		
		//decrypts the code using the formula provided
		for(i = 0; i < DecryptedCode.length; i++) {
			DecryptedCode[i] = DecryptedCode[i] + 3;
			DecryptedCode[i] = DecryptedCode[i] % 10;
		}
		
		//if the user inputed a code starting with the number '0' this is to shift the 
		//array so the numbers are properly formatted since java doesn't read the leading 0
		if(DecryptedCode[3] == 1) {
			int ZeroDecrypt[] = new int[DecryptedCode.length];
			
			int n = DecryptedCode[3];
			for(i = 0; i < DecryptedCode.length-1; i++) {
				ZeroDecrypt[i+1] = DecryptedCode[i];
			}
			ZeroDecrypt[0] = n;
			for(i = 0; i < ZeroDecrypt.length; i++) {
				System.out.print(ZeroDecrypt[i]);
			}
		}
		//prints the normal decrypted code given there was no leading 0
		else for(i = 0; i < DecryptedCode.length; i++) {
				System.out.print(DecryptedCode[i]);
			}
}
}
