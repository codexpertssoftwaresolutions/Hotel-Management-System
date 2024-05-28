package gui.hr;

import java.util.List;

/**
 *
 * @author thipu
 */
public class SalaryCalculator {

    private static final double EPF_PERCENTAGE = 0.08;
    private static final double ETF_PERCENTAGE = 0.03;
    private static final double TAX_PERCENTAGE = 0.1;

    public static void calculateSalaries(List<Employee> employees) {
        for (Employee employee : employees) {
              double epf = employee.getBASIC_SALARY()* EPF_PERCENTAGE;
            double etf = employee.getBASIC_SALARY()* ETF_PERCENTAGE;
            double tax = employee.getBASIC_SALARY()* TAX_PERCENTAGE;
            double deductions = epf + etf + tax;

            double netSalary = employee.getBASIC_SALARY()- deductions;

            employee.setEpf(epf);
            employee.setEtf(etf);
            employee.setTax(tax);
            employee.setNetsalary(netSalary);
        }
    }
}
