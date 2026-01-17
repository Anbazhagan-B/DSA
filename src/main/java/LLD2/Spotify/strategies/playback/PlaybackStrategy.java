package LLD2.Spotify.strategies.playback;

import LLD2.Spotify.entities.*;
import LLD2.Spotify.enums.SubscriptionTier;

public interface PlaybackStrategy {
    void play(Song song, Player player);

    static PlaybackStrategy getStrategy(SubscriptionTier tier, int songsPlayed)
    {
        return tier == SubscriptionTier.PREMIUM ? new PremiumPlaybackStrategy() : new FreePlaybackStrategy(songsPlayed);
    }
}
