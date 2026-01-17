package LLD2.Spotify.strategies.recommendation;

import LLD2.Spotify.entities.Song;

import java.util.*;
import java.util.stream.Collectors;

public class GenreBasedRecommendationStrategy  implements RecommendationStrategy{

    @Override
    public List<Song> recommend(List<Song> allSongs)
    {
        System.out.println("Generating genre-based recommendations (simulated)...");
        List<Song> shuffled = new ArrayList<>(allSongs);
        Collections.shuffle(shuffled);

        return shuffled.stream().limit(5).collect(Collectors.toList());
    }
}
