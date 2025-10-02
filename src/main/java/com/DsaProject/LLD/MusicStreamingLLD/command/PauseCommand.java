package com.DsaProject.LLD.MusicStreamingLLD.command;

import com.DsaProject.LLD.MusicStreamingLLD.entities.Player;

public class PauseCommand implements Command {
    private final Player player;

    public PauseCommand(Player player) { this.player = player; }

    @Override
    public void execute() { player.clickPause(); }
}