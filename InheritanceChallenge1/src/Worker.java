public class Worker {
    protected String name;
    private String birthDate;
    protected String endDate;

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge(){
        //Calculate the worker's age based on their birthdate
        int birthYear = Integer.parseInt(birthDate.substring(6));
        int currentYear = 2024;
        return currentYear - birthYear;
    }

    public double collectPay(){
        return 0.0;
    }

    public void terminate(String endDate){
        this.endDate = endDate;
        System.out.println(name + " has ended his employment on " + endDate);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
