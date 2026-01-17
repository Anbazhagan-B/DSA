package LLD2.Spotify.entities;

import LLD2.Spotify.observer.Subject;

import java.util.*;

public class Artist extends Subject {

    final String id;
    final String name;
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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
