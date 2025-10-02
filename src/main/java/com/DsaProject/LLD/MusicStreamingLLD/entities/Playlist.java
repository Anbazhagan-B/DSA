package com.DsaProject.LLD.MusicStreamingLLD.entities;

import java.util.*;

public class Playlist implements Playable {
    String name;
    List<Song> tracks = new ArrayList<>();

    public Playlist(String name)
    {
        this.name = name;
    }

    public void addTrack(Song song)
    {
        tracks.add(song);
    }

    @Override
    public List<Song> getTracks()
    {
        return List.copyOf(tracks);
    }
}
