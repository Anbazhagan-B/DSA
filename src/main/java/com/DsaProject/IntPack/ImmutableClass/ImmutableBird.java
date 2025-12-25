package com.DsaProject.IntPack.ImmutableClass;

public final class ImmutableBird {
    private  String id;
    private  String name;

    private ImmutableBird instance;

    public synchronized ImmutableBird getInstance()
    {
        if(instance == null)
        {
            return new ImmutableBird();
        }

        return instance;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
