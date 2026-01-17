package LLD2.Spotify.observer;

import LLD2.Spotify.entities.*;

public interface ArtistObserver {
    void update(Artist artist, Album newAlbum);
}
