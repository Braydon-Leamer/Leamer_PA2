import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		//takes in user input to decide which function they want to use
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 1 or 2 to select ecrypt or decrypt respectively: ");
		int UInput = 0;
		while(true) {
			UInput = s.nextInt();
			if(UInput == 1 || UInput == 2) {
				break;
			}
			else {
				System.out.println("invalid input, please enter 1 or 2 to select encrypt or decrypt");
			}
		}
		//runs the encrypt or decrypt functions
		if(UInput == 1) Encrypter.encrypt();
		
		if(UInput == 2) Decrypter.decrypt();
	}
}
