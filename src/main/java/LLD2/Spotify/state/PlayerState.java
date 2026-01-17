package LLD2.Spotify.state;

import LLD2.Spotify.entities.Player;

public interface PlayerState {
    void play(Player player);
    void pause(Player player);
    void stop(Player player);
}
