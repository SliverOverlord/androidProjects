package edu.mnstate.rm8834yy.denioa3intentspassdata;

import java.util.Comparator;

public class Employee {
    private String name;
    private double hours;
    private double payrate;

    public Employee(String tmpName,double tmpHours, double tmpPayrate) {
        this.name = tmpName;
        this.hours = tmpHours;
        this.payrate = tmpPayrate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getPayrate() {
        return payrate;
    }

    public void setPayrate(double payrate) {
        this.payrate = payrate;
    }


    public static Comparator<Employee> empNameComp = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            String EmployeeName1 = o1.getName().toUpperCase();
            String EmployeeName2 = o2.getName().toUpperCase();
            return EmployeeName1.compareTo(EmployeeName2);







        }};




    public String toString(){
        return name + "\n" + "Hours: $" +
                String.format("%.2f", getHours()) +
                "\n"+ "Pay Rate: $"+
                String.format("%.2f", getPayrate())
                +"\n";
    }
}
