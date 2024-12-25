import java.util.Arrays;

public class ComputeThresholdSalary {

    /**
     * You are working in the finance office for ABC corporation. ABC needs to cut payroll
     * expenses to a specified target. The chief executive officer wants to do this by putting
     * a cap on last year's salaries. Every employee who earned more than the cap last year
     * will be paid the cap this year; employees who earned no more than the cap will see
     * no change in their salary.
     * For example, if there were five employees with salaries last year were
     * $90,$30,$100,$40, and $20, and the target payroll this year is $210, then 60 is a
     * suitable salary cap, since 60 + 30 + 60 + 40 + 20 = 210.
     * Design an algorithm for computing the salary cap, given existing salaries and the
     * target payroll.
     */

    /**
     * Time Complexity: O(n*log(n))
     * Space Complexity: O(1)
     */

    public static double findSalaryCap(double[] salaries, double targetPayroll) {
        Arrays.sort(salaries);
        double unadjustedSalarySum = 0.0;
        for (int i = 0; i < salaries.length; i++) {
            double adjustedPeople = salaries.length - i;
            double adjustedSalarySum = salaries[i] * adjustedPeople;
            if (unadjustedSalarySum + adjustedSalarySum >= targetPayroll) {
                return (targetPayroll - unadjustedSalarySum) / adjustedPeople;
            }
            unadjustedSalarySum += salaries[i];
        }
        return -1.0;
    }

    public static void main(String[] args) {
        double[] salaries = {90, 30, 100, 40, 20};
        double targetPayroll = 210;
        System.out.println(findSalaryCap(salaries, targetPayroll));
    }
}
