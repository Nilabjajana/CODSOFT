import java.util.Scanner;

public class MarkCal {
    public static void main(String[] args) {
        
        int totalMarks = 0;
        int numberOfSubjects = 0;

        System.out.println("Enter marks obtained (out of 100) in each subject:");
        while (true) {
            System.out.print("Subject " + (numberOfSubjects + 1) + ": ");
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                continue;
            }

            totalMarks += marks;
            numberOfSubjects++;

            System.out.print("Do you want to enter marks for another subject? (y/n): ");
            String response = scanner.next();

            if (!response.equalsIgnoreCase("y")) {
                break;
            }
        }

        double averagePercentage = (double) totalMarks / numberOfSubjects;
        String grade;

        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Total marks: " + totalMarks);
        System.out.println("Average percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
