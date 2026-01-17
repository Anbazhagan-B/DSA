package LLD2.Spotify.strategies.recommendation;

import LLD2.Spotify.entities.Song;

import java.util.List;

public interface RecommendationStrategy {
    List<Song> recommend(List<Song> allSongs);
}
