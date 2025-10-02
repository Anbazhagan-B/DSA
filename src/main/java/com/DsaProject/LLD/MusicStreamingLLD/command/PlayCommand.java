package com.DsaProject.LLD.MusicStreamingLLD.command;

import com.DsaProject.LLD.MusicStreamingLLD.entities.Player;

public class PlayCommand implements Command {
    private final Player player;

    public PlayCommand(Player player) { this.player = player; }

    @Override
    public void execute() { player.clickPlay(); }
}
