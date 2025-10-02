package com.DsaProject.LLD.MusicStreamingLLD.strategies.playback;

import com.DsaProject.LLD.MusicStreamingLLD.entities.Player;
import com.DsaProject.LLD.MusicStreamingLLD.entities.Song;

public class PremiumPlaybackStrategy implements PlaybackStrategy {
    @Override
    public void play(Song song, Player player) {
        player.setCurrentSong(song);
        System.out.printf("Premium User is now playing: %s%n", song);
    }
}
