package com.bazhan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.Instant;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;

public class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent event){
        System.out.println("Время по звуовому сигналу ..."+ Instant.ofEpochMilli(event.getWhen()));
        //System.out.println("Время по звуовому сигналу ..."+new Date());
        Toolkit.getDefaultToolkit().beep();
    }

    //область видимости переменных
    public static void repeatMessage(String text, int delay){
        ActionListener listener=event ->{
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };
        new javax.swing.Timer(delay, listener).start();
    }
}
