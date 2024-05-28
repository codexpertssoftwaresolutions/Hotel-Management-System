package gui.hr;

/**
 *
 * @author thipu
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.MySQL;

public class DataRetrieval {

    public static List<Employee> getEmployeesByDepartment(String department) {
        List<Employee> employees = new ArrayList<>();
        try {
            String query = "SELECT * FROM employee \n"
                    + "INNER JOIN employee_role ON (employee.employee_role_id=employee_role.employee_role_id)\n"
                    + "INNER JOIN department ON (employee_role.department_id=department.department_id)\n"
                    + "WHERE department.department_name='" + department + "'";

            ResultSet resultSet = MySQL.execute(query);

            while (resultSet.next()) {
                String employeeNIC = resultSet.getString("nic");
                String full_name = resultSet.getString("employee_fname") + " " + resultSet.getString("employee_lname");
                Double basic_salary = resultSet.getDouble("basic_salary");

                Employee employee = new Employee(employeeNIC, full_name, basic_salary,department);
                employees.add(employee);

            }
        } catch (Exception e) {
            HRDashBoard.log1.warning(e.toString());
        }
        return employees;
    }
}
