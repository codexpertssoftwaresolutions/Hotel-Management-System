package gui.hr;

/**
 *
 * @author thipu
 */
public class Employee {

    private String NIC;
    private String FULLNAME;
    private double BASIC_SALARY;
    private String DEPARTMENT;
    private double epf;
    private double etf;
    private double tax;
    private double netsalary;

    public Employee(String NIC, String fullname, double basic_salary,String department) {
        this.NIC = NIC;
        this.FULLNAME = fullname;
        this.BASIC_SALARY = basic_salary;
        this.DEPARTMENT = department;

    }

    /**
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    /**
     * @return the FULLNAME
     */
    public String getFULLNAME() {
        return FULLNAME;
    }

    /**
     * @param FULLNAME the FULLNAME to set
     */
    public void setFULLNAME(String FULLNAME) {
        this.FULLNAME = FULLNAME;
    }

    /**
     * @return the BASIC_SALARY
     */
    public double getBASIC_SALARY() {
        return BASIC_SALARY;
    }

    /**
     * @param BASIC_SALARY the BASIC_SALARY to set
     */
    public void setBASIC_SALARY(double BASIC_SALARY) {
        this.BASIC_SALARY = BASIC_SALARY;
    }

    /**
     * @return the epf
     */
    public double getEpf() {
        return epf;
    }

    /**
     * @param epf the epf to set
     */
    public void setEpf(double epf) {
        this.epf = epf;
    }

    /**
     * @return the etf
     */
    public double getEtf() {
        return etf;
    }

    /**
     * @param etf the etf to set
     */
    public void setEtf(double etf) {
        this.etf = etf;
    }

    /**
     * @return the tax
     */
    public double getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     * @return the netsalary
     */
    public double getNetsalary() {
        return netsalary;
    }

    /**
     * @param netsalary the netsalary to set
     */
    public void setNetsalary(double netsalary) {
        this.netsalary = netsalary;
    }

    /**
     * @return the DEPARTMENT
     */
    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    /**
     * @param DEPARTMENT the DEPARTMENT to set
     */
    public void setDEPARTMENT(String DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

}
