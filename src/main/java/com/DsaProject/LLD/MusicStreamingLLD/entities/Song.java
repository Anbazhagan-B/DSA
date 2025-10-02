package com.DsaProject.LLD.MusicStreamingLLD.entities;

import java.util.List;

public class Song implements Playable{

    String id;
    String title;
    Artist artist;
    int durationInSeconds;

    public Song(String id, String title, Artist artist, int durationInSeconds)
    {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
    }

    @Override
    public List<Song> getTracks() {
        return List.of(this);
    }

    @Override
    public String toString() {
        return String.format("'%s' by %s", title, artist.getName());
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public Artist getArtist() { return artist; }
}
