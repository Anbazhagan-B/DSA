package com.DsaProject.CustomDS;

import java.util.Map;

public class MyEntry<TK, TV> {
    public TK key;
    public TV value;
    public MyEntry<TK, TV> next;

    public MyEntry(TK key, TV value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
