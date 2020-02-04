import java.util.Scanner;

public class Encrypter {
	static void encrypt() {
			//takes input from the user and parses it to an integer array
			System.out.println("Input the 4 digit code to be encrypted: ");
			Scanner s = new Scanner(System.in);
			int UserInput = s.nextInt();
			String parseNum = Integer.toString(UserInput);
			String code[] = parseNum.split("");		
			int EncryptedCode[] = new int[4];
			int i;
			//encrypts the code
			for(i = 0; i < code.length; i++) {
				EncryptedCode[i] = Integer.parseInt(code[i]);
				EncryptedCode[i] = EncryptedCode[i] + 7;
				EncryptedCode[i] = EncryptedCode[i] % 10;
			}
			
			//swaps the numbers positions around as part of the encyrption
			int tempNum = 0;
			
			tempNum = EncryptedCode[0];
			EncryptedCode[0] = EncryptedCode[2];
			EncryptedCode[2] = tempNum;
			
			tempNum = EncryptedCode[1];
			EncryptedCode[1] = EncryptedCode[3];
			EncryptedCode[3] = tempNum;
			
			//prints out the newly encrypted code
			for(i = 0; i < EncryptedCode.length; i++) {
				System.out.print(EncryptedCode[i]);
			}
	}
}
