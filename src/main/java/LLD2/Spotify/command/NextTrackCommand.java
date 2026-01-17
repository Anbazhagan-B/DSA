package LLD2.Spotify.command;

import LLD2.Spotify.entities.Playable;
import LLD2.Spotify.entities.Player;

public class NextTrackCommand implements Command{
    final Player player;

    public NextTrackCommand(Player player)
    {
        this.player = player;
    }

    @Override
    public void execute() {
        player.clickNext();
    }
}
