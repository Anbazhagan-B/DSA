package LLD2.Spotify;


import LLD2.Spotify.entities.Artist;
import LLD2.Spotify.entities.Player;
import LLD2.Spotify.entities.Song;
import LLD2.Spotify.entities.User;
import LLD2.Spotify.services.RecommendationService;
import LLD2.Spotify.services.SearchService;
import LLD2.Spotify.strategies.recommendation.GenreBasedRecommendationStrategy;

import java.util.*;

public class MusicStreamingSystem {
    private static volatile MusicStreamingSystem instance;

    final Map<String, User> users = new HashMap<>();
    final Map<String, Song> songs = new HashMap<>();
    final Map<String, Artist> artists = new HashMap<>();

    final Player player;
    final SearchService searchService;
    final RecommendationService recommendationService;

    private MusicStreamingSystem()
    {
        this.player = new Player();
        this.searchService = new SearchService();
        this.recommendationService = new RecommendationService(new GenreBasedRecommendationStrategy());
    }

    public static MusicStreamingSystem getInstance()
    {
        if(instance == null)
        {
            synchronized (MusicStreamingSystem.class)
            {
                if(instance == null)
                {
                    instance = new MusicStreamingSystem();
                }
            }
        }
        return instance;
    }

    public void registerUser(User user)
    {
        users.put(user.getId(), user);
    }

    public Song addSong(String id, String title, String artistId, int duration)
    {
        Song song = new Song(id, title, artists.get(artistId), duration);
        songs.put(song.getId(), song);
        return song;
    }

    public void addArtist(Artist artist)
    {
        artists.put(artist.getId(), artist);
    }

    public List<Song> searchSongsByTitle(String title)
    {
        return searchService.searchSongsByTitle(new ArrayList<>(songs.values()), title);
    }

    public List<Song> getSongRecommendations()
    {
        return recommendationService.generateRecommendations(new ArrayList<>(songs.values()));
    }

    public Player getPlayer()
    {
        return player;
    }
}
