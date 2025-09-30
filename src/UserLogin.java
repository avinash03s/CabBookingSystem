import java.util.Scanner;

public class UserLogin {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int setId=101;
        char arr[]={'a','v','i','@','1','2','3'};//password-avi@123
        String setPassword=new String(arr);
        //String setPassword="avi@123";

        while (true){
            System.out.println("Enter UserId");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Password");
            String password=sc.nextLine();
            if (setId==id && setPassword.equals(password)){
                System.out.println("Login Successful..");
                break;
            }else {
                System.out.println("Incorrect Please Try again...!");
            }
        }
    }
}
