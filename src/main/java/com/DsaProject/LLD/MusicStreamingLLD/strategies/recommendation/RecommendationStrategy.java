package com.DsaProject.LLD.MusicStreamingLLD.strategies.recommendation;

import com.DsaProject.LLD.MusicStreamingLLD.entities.Song;

import java.util.List;

public interface RecommendationStrategy {
    List<Song> recommend(List<Song> allSongs);
}
