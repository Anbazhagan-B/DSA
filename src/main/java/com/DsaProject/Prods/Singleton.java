package com.DsaProject.Prods;

public class Singleton {
     static Singleton instance;

    transient long id;

    public static synchronized Singleton getInstance() {
        if(instance == null)
        {
            return new Singleton();
        }

        //System.
        return instance;

    }

}
