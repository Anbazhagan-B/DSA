package com.DsaProject.LLD.MusicStreamingLLD.observer;

import com.DsaProject.LLD.MusicStreamingLLD.entities.*;

public interface ArtistObserver {
    void update(Artist artist, Album newAlbum);
}
