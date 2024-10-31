import java.text.SimpleDateFormat;
import java.util.Date;

public class SalariedEmployee extends Employee{
    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }

    public void retire(){
        // need to change endDate to today's date and set isRetired to true
        this.isRetired = true;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        terminate(formatter.format(date));
        // Calculate years of service
        int endYear = Integer.parseInt(endDate.substring(6));
        int hireYear = Integer.parseInt(hireDate.substring(6));
        System.out.println(name + " has retired after " + (endYear - hireYear) + " years! Congratulations!");
    }

    @Override
    public double collectPay() {

        double paycheck = annualSalary / 26;
        double adjustedPay = isRetired ? 0.9 * paycheck : paycheck;

        return (int) adjustedPay;
    }
}
