package LLD2.Spotify.command;

import LLD2.Spotify.entities.Player;

public class PauseCommand implements Command{
    private final Player player;

    public PauseCommand(Player player) { this.player = player; }

    @Override
    public void execute() { player.clickPause(); }
}
