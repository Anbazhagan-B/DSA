package com.DsaProject.LLD.MusicStreamingLLD;

import com.DsaProject.LLD.MusicStreamingLLD.entities.*;
import com.DsaProject.LLD.MusicStreamingLLD.services.RecommendationService;
import com.DsaProject.LLD.MusicStreamingLLD.services.SearchService;
import com.DsaProject.LLD.MusicStreamingLLD.strategies.recommendation.GenreBasedRecommendationStrategy;

import javax.smartcardio.ATR;
import java.util.*;

public class MusicStreamingSystem {
    private static volatile MusicStreamingSystem instance;

    Map<String, User> users = new HashMap<>();
    Map<String, Song> songs = new HashMap<>();
    Map<String, Artist> artists = new HashMap<>();

    Player player;
    SearchService searchService;
    RecommendationService recommendationService;

    public MusicStreamingSystem()
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

    public void registerUser(User user){users.put(user.getId(), user); }

    public Song addSong(String id, String title, String artistId, int duration)
    {
        Song song = new Song(id, title, artists.get(artistId), duration);
        songs.put(song.getId(), song);
        return song;
    }

    public void addArtist(Artist artist){artists.put(artist.getId(), artist); }


    public List<Song> searchSongsByTitle(String title)
    {
        return searchService.searchSongsByTitle(new ArrayList<>(songs.values()), title);
    }

    public List<Song> getSongRecommendation()
    {
        return recommendationService.generateRecommendations(new ArrayList<>(songs.values()));
    }

    public Player getPlayer(){return player; }
}
