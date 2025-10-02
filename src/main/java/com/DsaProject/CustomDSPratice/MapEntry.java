package com.DsaProject.CustomDSPratice;

public class MapEntry<TK, TV>  {
    public TK key;
    public TV value;

    public MapEntry<TK, TV> next;

    public MapEntry(TK key, TV value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
