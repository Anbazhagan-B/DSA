package com.DsaProject.LLD.MusicStreamingLLD.state;

import com.DsaProject.LLD.MusicStreamingLLD.entities.Player;

public interface PlayerState {
    void play(Player player);
    void pause(Player player);
    void stop(Player player);
}
