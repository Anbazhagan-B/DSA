package LLD2.Spotify.command;

import LLD2.Spotify.entities.Player;

public class PlayCommand implements Command{
    private final Player player;

    public PlayCommand(Player player) { this.player = player; }

    @Override
    public void execute() { player.clickPlay(); }
}
