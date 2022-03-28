package com.bazhan;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RepeatedTimePrinter extends TimePrinter{
        public void repeated(ActionEvent event) {
            //дополняющий с ссылкой на метод
            Timer timer = new Timer(1000, super::actionPerformed);
            timer.start();
    }
}
