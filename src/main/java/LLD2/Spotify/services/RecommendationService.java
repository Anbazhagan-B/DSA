package LLD2.Spotify.services;

import LLD2.Spotify.entities.Song;
import LLD2.Spotify.strategies.recommendation.RecommendationStrategy;

import java.util.List;

public class RecommendationService {
    RecommendationStrategy strategy;

    public RecommendationService(RecommendationStrategy strategy)
    {
        this.strategy = strategy;
    }

    public void setStrategy(RecommendationStrategy strategy)
    {
        this.strategy = strategy;
    }

    public List<Song> generateRecommendations(List<Song> allSongs)
    {
        return strategy.recommend(allSongs);
    }
}
