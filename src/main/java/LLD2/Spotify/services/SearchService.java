package LLD2.Spotify.services;

import LLD2.Spotify.entities.Artist;
import LLD2.Spotify.entities.Song;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
    public List<Song> searchSongsByTitle(List<Song> songs, String query)
    {
        return songs.stream().filter(s -> s.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Artist> searchSongsByName(List<Artist> artists, String query)
    {
        return artists.stream().filter(s -> s.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
