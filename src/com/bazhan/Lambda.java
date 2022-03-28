package com.bazhan;

import java.util.function.IntConsumer;

public class Lambda implements IntConsumer {
    public static void repeat(int n, IntConsumer action){
        for (int i=0; i<n; i++) action.accept(i);
    }

    public void accept(int value) {
    }
}
