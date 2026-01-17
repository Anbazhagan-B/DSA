package LLD2.Spotify.entities;


import LLD2.Spotify.enums.PlayerStatus;
import LLD2.Spotify.state.PlayerState;
import LLD2.Spotify.state.PlayingState;
import LLD2.Spotify.state.StoppedState;

import java.util.*;

public class Player {
    PlayerState state;
    PlayerStatus status;
    List<Song> queue = new ArrayList<>();
    int currentIndex = -1;
    Song currentSong;
    User currentUser;

    public Player()
    {
        this.state = new StoppedState();
        this.status = PlayerStatus.STOPPED;
    }

    public void load(Playable playable, User user)
    {
        this.currentUser = user;
        this.queue = playable.getTracks();
        this.currentIndex = 0;
        this.state = new StoppedState();
    }

    public void playCurrentSongInQueue()
    {
        if(currentIndex >= 0 && currentIndex < queue.size())
        {
            Song songToPlay = queue.get(currentIndex);
            currentUser.getPlaybackStrategy().play(songToPlay, this);
        }
    }

    public void clickPlay()
    {
        state.play(this);
    }

    public void clickPause()
    {
        state.pause(this);
    }

    public void clickNext()
    {
        if(currentIndex < queue.size() - 1)
        {
            currentIndex++;
            playCurrentSongInQueue();
        }
        else
        {
            System.out.println("End of queue");
            state.stop(this);
        }

    }

    public void changeState(PlayerState state)
    {
        this.state = state;
    }

    public void setStatus(PlayerStatus status){ this.status = status;}

    public void setCurrentSong(Song song) { this.currentSong = song; }

    public boolean hasQueue() { return !queue.isEmpty(); }
}
