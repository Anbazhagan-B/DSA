package LLD2.Spotify.strategies.playback;

import LLD2.Spotify.entities.*;

public class FreePlaybackStrategy implements PlaybackStrategy {
    int songsPlayed;
    static final int SONGS_BEFORE_AD = 3;

    public FreePlaybackStrategy(int initialSongsPlayed)
    {
        this.songsPlayed = initialSongsPlayed;
    }

    @Override
    public void play(Song song, Player player)
    {
        if(songsPlayed > 0 && songsPlayed % SONGS_BEFORE_AD == 0)
        {
            System.out.println("\n>>> Playing Advertisement: 'Buy Spotify Premium for ad-free music!' <<<\n");
        }

        player.setCurrentSong(song);
        System.out.printf("Free User is now playing: %s%n", song);
        songsPlayed++;

    }
}
