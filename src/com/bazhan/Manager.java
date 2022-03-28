package com.bazhan;

public class Manager extends Employee {
    private double bonus;

    /**
     * @param n Имя работника
     * @param s Зарплата
     */

    public Manager(String n, double s) {
        super(n, s);
        bonus=0;
    }

    public void setBonus(double b){
        bonus=b;
    }

    public  double getSalary (){
        double baseSalary=super.getSalary();
        return baseSalary+bonus;
    }
}
