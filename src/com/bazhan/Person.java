package com.bazhan;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public abstract class Person {
    public Person() {

    }

    public abstract String getDescription();
    private String name;

    public Person (String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

}
