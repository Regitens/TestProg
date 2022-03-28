package com.bazhan;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends Person implements Comparable <Employee>, Cloneable {
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary){
        super(name);
        this.salary=salary;
        hireDay=new Date();
    }

    public Employee(Object o) {
    }

    public String getDescription() {
        return String.format("работник с зарплатой $%.2f", salary);
    }

    public double getSalary(){
        return salary;
    }

    /**public Date getHireDay(){
        return hireDay;
    }*/

    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary+=raise;
    }
    public int compareTo(Employee other){
        return Double.compare(salary, other.salary);
    }

    public void setHireDay(int year, int month, int day){
        Date newHireDay=new GregorianCalendar(year,month-1,day).getTime();
        //пример изменения поля класса
        hireDay.setTime(newHireDay.getTime());
    }
    //сделать метод открытым, изменить возвращаемый тип
    public Employee clone() throws CloneNotSupportedException{
        //вызвать метод Object.clone()
        Employee cloned=(Employee) super.clone();
        //клонировать изменяемые поля
        cloned.hireDay=(Date) hireDay.clone();
        return cloned;
    }
    public String toString(){
        return "Employee[name="+super.getName()+",salary="+salary+",hireDay="+hireDay+"]";
    }

}
