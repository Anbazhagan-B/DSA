package com.DsaProject.IntPack.supports;

public class MutatedCharWithIndices {
    Character c;
    Integer index;

    public MutatedCharWithIndices(Character c, Integer index)
    {
        this.c = c;
        this.index = index;
    }

    public char getCharacter()
    {
        return this.c;
    }

    public Integer getIndex()
    {
        return this.index;
    }
}
