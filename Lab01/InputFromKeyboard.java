import java.util.Scanner;
public class InputFromKeyboard {
    public static void main(String args[]) {
        Scanner s =new Scanner(System.in);
        System.out.print("What's your name?");
        String strName=s.nextLine();

        System.out.print("How old are you");
        int iAge =s.nextInt();
        System.out.print("How tall are you(m)?");
        double dHeight=s.nextDouble();

        System.out.print("Mrs/Mr "+ strName+", "+ iAge+" year old "+ " Your height is " + dHeight+" . ");
        System.out.println();

    }
}
