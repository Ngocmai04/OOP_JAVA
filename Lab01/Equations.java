import java.util.Scanner;

public class Equations {
    
    public static void cal1() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("1. The first-degree equation (linear equation) with one variable\n");
            System.out.print("Enter a1, b1 (a1x + b1 = 0): ");
            double a1 = scanner.nextDouble();
            double b1 = scanner.nextDouble();

            if (a1 == 0) {
                if (b1 != 0) {
                    System.err.println("Invalid: No solution.");
                } else {
                    System.out.println("Infinite solutions.");
                }
            } else {
                System.out.printf("x = %.2f\n", (-b1 / a1));
            }
        }
    }

    public static void cal2() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("2. The system of first-degree equations (linear system) with two variables\n");
            System.out.print("Enter a11, a12, b1, a21, a22, b2 (equations: a11*x1 + a12*x2 = b1 and a21*x1 + a22*x2 = b2): ");
            
            double a11 = scanner.nextDouble();
            double a12 = scanner.nextDouble();
            double b1 = scanner.nextDouble();
            double a21 = scanner.nextDouble();
            double a22 = scanner.nextDouble();
            double b2 = scanner.nextDouble();


            double D = a11 * a22 - a21 * a12;  
            double D1 = b1 * a22 - b2 * a12;   
            double D2 = a11 * b2 - a21 * b1;   

          
            if (D == 0) {
                if (D1 == 0 && D2 == 0) {
                    System.out.println(" many solutions.");
                } else {
                    System.out.println("No solution.");
                }
            } else {
                
                double x1 = D1 / D;
                double x2 = D2 / D;
                System.out.printf(" x1 = %.2f, x2 = %.2f\n", x1, x2);
            }
        }
    }

    public static void cal3() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("3. The second-degree equation with one variable\n");
            System.out.print("Enter a1, b1, c1 (a1x^2 + b1x + c1 = 0): ");
            double a1 = scanner.nextDouble();
            double b1 = scanner.nextDouble();
            double c1 = scanner.nextDouble();
            double delta = b1 * b1 - 4 * a1 * c1;

            if (a1 == 0) {
                if (b1 != 0) {
                    System.out.printf("x = %.2f\n", (-c1 / b1));
                } else {
                    System.err.println("Invalid: No solution.");
                }
            } else {
                if (delta > 0) {
                    double x1 = (-b1 + Math.sqrt(delta)) / (2 * a1);
                    double x2 = (-b1 - Math.sqrt(delta)) / (2 * a1);
                    System.out.printf("x1 = %.2f, x2 = %.2f\n", x1, x2);
                } else if (delta == 0) {
                    double x = -b1 / (2 * a1);
                    System.out.printf("x = %.2f (double root)\n", x);
                } else {
                    System.err.println("Invalid: No solutions.");
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Choose an option:\n1. First-degree equation\n2. System of first-degree equations\n3. Second-degree equation\n");
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    cal1();
                    break;
                case 2:
                    cal2();
                    break;
                case 3:
                    cal3();
                    break;
                default:
                    System.err.println("Invalid option.");
                    break;
            }
        }
    }
}
