package com.DsaProject.LLD.MusicStreamingLLD.entities;

import com.DsaProject.LLD.MusicStreamingLLD.observer.Subject;

import java.util.*;

public class Artist extends Subject {
    String id;
    String name;
    List<Album> discography = new ArrayList<>();

    public Artist(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public void releaseAlbum(Album album)
    {
        discography.add(album);
        System.out.printf("[System] Artist %s has released a new album: %s%n", name, album.getTitle());
        notifyObservers(this, album);
    }

    public String getId() { return id; }
    public String getName() { return name; }
}
