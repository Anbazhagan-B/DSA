package com.DsaProject.DesignPattern.BuilderPattern;

import com.DsaProject.CustomDS.CustomHashMap;

public class Client {

    public static void main(String[] args)
    {
        Bird bird = Bird.getBuilder().setName("Anbu").build();
        System.out.println(bird);

        CustomHashMap<Bird, String> map = new CustomHashMap<>();
        map.put(bird, bird.getName());
    }


}
