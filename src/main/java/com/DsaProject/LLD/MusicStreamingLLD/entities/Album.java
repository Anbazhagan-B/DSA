package com.DsaProject.LLD.MusicStreamingLLD.entities;

import java.util.*;

public class Album implements Playable{
    String title;
    List<Song> tracks = new ArrayList<>();

    public Album(String title)
    {
        this.title = title;
    }

    @Override
    public List<Song> getTracks(){
        return List.copyOf(tracks);
    }

    public void addTrack(Song song){ tracks.add(song); }

    public String getTitle()
    {
        return title;
    }
}
