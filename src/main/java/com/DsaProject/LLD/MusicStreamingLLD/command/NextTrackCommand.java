package com.DsaProject.LLD.MusicStreamingLLD.command;

import com.DsaProject.LLD.MusicStreamingLLD.entities.Player;

public class NextTrackCommand implements Command {
    private final Player player;

    public NextTrackCommand(Player player) { this.player = player; }

    @Override
    public void execute() { player.clickNext(); }
}
