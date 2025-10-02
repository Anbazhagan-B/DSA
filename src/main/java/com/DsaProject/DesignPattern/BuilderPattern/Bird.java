package com.DsaProject.DesignPattern.BuilderPattern;

public class Bird {
    private Integer size;
    private String name;

    public String getName()
    {
        return this.name;
    }

    public Integer getSize()
    {
        return this.size;
    }

    public Bird(Builder builder)
    {
        this.size = builder.size;
        this.name = builder.name;
    }

    public static Builder getBuilder()
    {
        return new Builder();
    }

    public static class Builder
    {
        private Integer size;
        private String name;

        public Builder setSize(Integer size)
        {
            this.size = size;
            return this;
        }

        public Builder setName(String name)
        {
            this.name = name;
            return this;
        }

        public Bird build()
        {
            return  new Bird(this);
        }
    }
}
