class ZaraBonus {
    public static int[][] generateEmployeeData(int employees) {
        int[][] data = new int[employees][2];
        for (int i = 0; i < employees; i++) {
            data[i][0] = (int) (Math.random() * 90000) + 10000;
            data[i][1] = (int) (Math.random() * 10) + 1;
        }
        return data;
    }
    public static double[][] calculateBonus(int[][] employeeData) {
        double[][] result = new double[employeeData.length][3];
        for (int i = 0; i < employeeData.length; i++) {
            int salary = employeeData[i][0];
            int years = employeeData[i][1];
            double bonus;
            if (years > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }
            result[i][0] = salary;
            result[i][1] = bonus;
            result[i][2] = salary + bonus;
        }
        return result;
    }
    public static void displaySummary(int[][] employeeData, double[][] salaryData) {
        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;
        System.out.println("------------------------------------------------------------");
        System.out.println("Emp\tYears\tOld Salary\tBonus\t\tNew Salary");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < employeeData.length; i++) {
            int years = employeeData[i][1];
            double oldSalary = salaryData[i][0];
            double bonus = salaryData[i][1];
            double newSalary = salaryData[i][2];
            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;
            System.out.println((i + 1) + "\t" +years + "\t" +oldSalary + "\t\t" +bonus + "\t\t" +newSalary);
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("TOTAL\t\t" +totalOldSalary + "\t" +totalBonus + "\t\t" +totalNewSalary);
        System.out.println("------------------------------------------------------------");
    }
    public static void main(String[] args) {
        int employees = 10;
        int[][] employeeData = generateEmployeeData(employees);
        double[][] salaryData = calculateBonus(employeeData);
        displaySummary(employeeData, salaryData);
    }
}
