package gui.hr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.MySQL;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author thipu
 */
public class PayrollUpdater {

    private Salary s = new Salary();

    public static void updatePayrollRecords(List<Employee> employees) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {

            for (Employee employee : employees) {
                ResultSet resultSet = MySQL.execute("SELECT * FROM payroll \n"
                        + "INNER JOIN employee ON (employee.nic=payroll.employee_nic)\n"
                        + "INNER JOIN employee_role ON (employee_role.employee_role_id=employee.employee_role_id) \n"
                        + "INNER JOIN department ON (employee_role.department_id=department.department_id)\n"
                        + "WHERE department.department_name='" + employee.getDEPARTMENT() + "' AND payroll.payment_date LIKE '%" + date.getMonth() + "%'");

                if (resultSet.next()) {

                } else {
                    String updateQuery = "INSERT INTO Payroll (employee_nic, epf, etf, taxes, net_salary, payment_date) VALUES ('" + employee.getNIC() + "','" + employee.getEpf() + "','" + employee.getEtf() + "','" + employee.getTax() + "','" + employee.getNetsalary() + "','" + sdf.format(date) + "')";
                    MySQL.execute(updateQuery);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
