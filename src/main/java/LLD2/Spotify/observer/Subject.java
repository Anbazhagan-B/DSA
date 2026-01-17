package LLD2.Spotify.observer;

import LLD2.Spotify.entities.*;
import java.util.*;

public abstract class Subject {
    final List<ArtistObserver> observers = new ArrayList<>();

    public void addObserver(ArtistObserver observer)
    {
        observers.add(observer);
    }

    public void removeObserver(ArtistObserver observer)
    {
        observers.add(observer);
    }

    public void notifyObservers(Artist artist, Album album)
    {
        for(ArtistObserver observer : observers)
        {
            observer.update(artist, album);
        }
    }
}
