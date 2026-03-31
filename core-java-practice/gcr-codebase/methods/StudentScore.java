import java.util.*;
class StudentScore {
    public static int[][] generateMarks(int students) {
        int[][] marks = new int[students][3];
        for (int i = 0; i < students; i++) {
            marks[i][0] = (int) (Math.random() * 90) + 10;
            marks[i][1] = (int) (Math.random() * 90) + 10;
            marks[i][2] = (int) (Math.random() * 90) + 10;
        }
        return marks;
    }
    public static double[][] calculateResults(int[][] marks) {
        double[][] result = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;
            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }
    public static String getGrade(double percentage) {
        if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "R";
    }
    public static void displayScorecard(int[][] marks, double[][] result) {
        System.out.println("--------------------------------------------------");
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < marks.length; i++) {
            String grade = getGrade(result[i][2]);

            System.out.println((i + 1) + "\t" +marks[i][0] + "\t" +marks[i][1] + "\t" +marks[i][2] + "\t" +result[i][0] + "\t" +result[i][1] + "\t" +result[i][2] + "\t" +grade);
        }

        System.out.println("-------------------------------------------------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int students = sc.nextInt();
        int[][] marks = generateMarks(students);
        double[][] result = calculateResults(marks);
        displayScorecard(marks, result);
    }
}
