import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng nhân viên và các tham số chung
        int employeeCount = scanner.nextInt();
        long maxSalary = scanner.nextLong();
        long baseSalary = scanner.nextLong();
        double startingCoefficient = scanner.nextDouble();
        double incrementCoefficient = scanner.nextDouble();
        scanner.nextLine(); // Bỏ qua dòng trống

        // Tạo mảng để lưu thông tin nhân viên
        String[] names = new String[employeeCount];
        int[] birthYears = new int[employeeCount];
        int[] workingYears = new int[employeeCount];
        long[] currentSalaries = new long[employeeCount];

        // Nhập thông tin từng nhân viên và tính lương
        for (int i = 0; i < employeeCount; i++) {
            names[i] = scanner.nextLine();
            birthYears[i] = Integer.parseInt(scanner.nextLine());
            workingYears[i] = Integer.parseInt(scanner.nextLine());

            // Tính lương hiện tại
            double salary = baseSalary * startingCoefficient +
                    baseSalary * incrementCoefficient * (workingYears[i] / 5);
            currentSalaries[i] = Math.min((long) salary, maxSalary);
        }

        // In thông tin nhân viên và tính tổng lương
        long totalSalary = 0;
        for (int i = 0; i < employeeCount; i++) {
            System.out.printf("%s %d %d %d", names[i], birthYears[i], workingYears[i], currentSalaries[i]);
            totalSalary += currentSalaries[i];
        }

        // In tổng lương
        System.out.println(totalSalary);

        scanner.close();
    }
}
