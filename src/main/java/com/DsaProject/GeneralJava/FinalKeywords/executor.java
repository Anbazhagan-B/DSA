package com.DsaProject.GeneralJava.FinalKeywords;

import java.lang.reflect.Field;

public class executor {
    public static void main(String[] args) throws Exception
    {
       Field field = Constants.class.getDeclaredField("MAX_size");
        field.setAccessible(true);

        field.setInt(null, 200);

        System.out.println("normal " + Constants.getMaxSize() +", reflection :- "+ field.getInt(null));

    }
}
