package LLD2.Spotify.entities;

import java.util.*;

public class Playlist implements Playable{

    final String name;
    final List<Song> tracks = new ArrayList<>();

    public Playlist(String name)
    {
        this.name = name;
    }

    public void addTrack(Song song)
    {
        tracks.add(song);
    }

    @Override
    public List<Song> getTracks(){
        return List.copyOf(tracks);
    }
}
