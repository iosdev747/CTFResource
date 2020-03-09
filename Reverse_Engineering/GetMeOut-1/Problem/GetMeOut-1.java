import java.util.*;

class GetMeOut1 {
    public static void main(String args[]) {
        GetMeOut1 obj = new GetMeOut1();
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter username: ");
        String user = sc.next();
		if(!user.equals("admin")) {
			System.out.println("Not a Admin account");
			return;
		}
		System.out.print("Enter password: ");
        String pass = sc.next();
		if(pass.equals("iKn0Wj4v4")) {
			System.out.println("Cams Disabled");
			System.out.println("Flag{j4j4_is_e4sY_to_D3C0mp1Le}");
		}
   }
}