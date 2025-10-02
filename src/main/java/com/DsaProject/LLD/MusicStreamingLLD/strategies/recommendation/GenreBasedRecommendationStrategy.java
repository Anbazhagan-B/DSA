package com.DsaProject.LLD.MusicStreamingLLD.strategies.recommendation;

import com.DsaProject.LLD.MusicStreamingLLD.entities.Song;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GenreBasedRecommendationStrategy implements RecommendationStrategy {
    @Override
    public List<Song> recommend(List<Song> allSongs) {
        System.out.println("Generating genre-based recommendations (simulated)...");
        List<Song> shuffled = new java.util.ArrayList<>(allSongs);
        Collections.shuffle(shuffled);
        return shuffled.stream().limit(5).collect(Collectors.toList());
    }
}
