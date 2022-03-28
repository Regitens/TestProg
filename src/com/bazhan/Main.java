package com.bazhan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.Instant;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Stream;
import javax.swing.Timer;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Manager boss=new Manager("Карл Крекер",10000);
        boss.setBonus(5000);
        Employee[] stuff=new Employee[3];
        stuff[0]=boss;
        stuff[1]=new Employee("Джек Хук", 7000);
        stuff[2]=new Employee("Мери Блек", 6000);
        Arrays.sort(stuff);
        for (Employee e:stuff) System.out.println("Имя="+e.getName()+",зарплата="+e.getSalary()+"$");

        //построение таймера
        /**TimePrinter listener = new TimePrinter();
        //построить таймер, вызывающий приемник событий каждую секунду
        Timer timer=new Timer(1000, listener);
        timer.start();
        JOptionPane.showMessageDialog(null,"Закрыть программу?");
        System.exit(0);*/

        /**использование сортировки по длине
        var comp=new LengthComparator();
        if (comp.compare(stuff[1], stuff[2]));*/
        String[] friends={"Mary", "Fraddy","So"};
        Arrays.sort(friends, new LengthComparator());
        System.out.println(Arrays.toString(friends));

        //клонирование
        var original=new Employee("Nory Black",50000);
        original.setHireDay(2000,1,1);
        Employee copy=original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2002,12,31);
        System.out.println("original"+original);
        System.out.println("copy"+copy );


        //лямбда-выражение
        String[] planets=new String[] {"Уран","Земля","Меркурий","Сатурн"};
        System.out.println(Arrays.toString(planets));
        //лексикографическая
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        //по длине
        Arrays.sort(planets, (first,second)->first.length()-second.length());
        System.out.println(Arrays.toString(planets));
        //лямбда выражение со ссылкой на метод класс::метод
        Arrays.sort(planets, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(planets));
        RepeatedTimePrinter newListener=new RepeatedTimePrinter();

        //с ссылкой на метод
        /**Timer timer=new Timer(1000, newListener::actionPerformed);
        timer.start();
        JOptionPane.showMessageDialog(null,"Закрыть программу?");
        System.exit(0);*/

        //ссылки на конструкторы
        ArrayList<String> namesPerson= new ArrayList<>();
        namesPerson.add("Nate");
        namesPerson.add("Bobby");
        namesPerson.add("Adeline");
        Stream<Person> stream;
        stream = namesPerson.stream().map(Employee::new);
        //List<Person> people=stream.collect(Collectors.toList());
        Person[] people = stream.toArray(Person[]::new);


        //область видимости переменных
        //TimePrinter.repeatMessage("Hello",1000);

        //обработка лямбда-выражений
        Lambda.repeat(2, i->
                System.out.println("Countdown: "+(1-i)));

        //компараторы
        //сравнение людей по именам с лямбда выражением
        Arrays.sort(stuff, comparing(Person::getName,
                Comparator.nullsFirst(naturalOrder())));
        System.out.println(Arrays.toString(stuff));
        //сравнение людей по длине имен с лямбда выражением
        Arrays.sort(stuff, comparingInt(
                p->p.getName().length()));
        System.out.println(Arrays.toString(stuff));
        Arrays.sort(stuff, comparing(Employee::getSalary));
        System.out.println(Arrays.toString(stuff));

        class TalkingClock {
            public void start(int interval, boolean beep){
                var localListener= new TimePrinter() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        System.out.println("AT the tone, the time is"
                                + Instant.ofEpochMilli(event.getWhen()));
                        if (beep) Toolkit.getDefaultToolkit().beep();
                    }
                };
                //не получилось
                Timer myTimer = new Timer(interval, localListener);
                myTimer.start();

            }
        }
        var clock=new TalkingClock();
        clock.start(1000,true);


        //статические внутренние классы
        class ArrayALg{
            public static class Pair{
                private double first;
                private double second;
                public Pair(double f, double s){
                    first=f;
                    second=s;
                }
                public double getFirst(){
                    return first;
                }
                public double getSecond(){
                    return second;
                }
                public static Pair minmax(double[] values){
                    double min = Double.POSITIVE_INFINITY;
                    double max=Double.NEGATIVE_INFINITY;
                    for (double v: values){
                        if (min>v) min=v;
                        if (max<v) max=v;
                    }
                    return new Pair(min,max);
                }
            }

        }
        double[] d=new double[20];
        for (int i=0; i<d.length; i++)
            d[i]=100*Math.random();
        ArrayALg.Pair p=ArrayALg.Pair.minmax(d);
        System.out.println("min="+p.getFirst());
        System.out.println("max="+p.getSecond());
    }
}

