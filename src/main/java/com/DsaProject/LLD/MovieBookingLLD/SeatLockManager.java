package com.DsaProject.LLD.MovieBookingLLD;

import com.DsaProject.LLD.MovieBookingLLD.entities.*;
import com.DsaProject.LLD.MovieBookingLLD.enums.SeatStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class SeatLockManager {
    Map<Show, Map<Seat, String>> lockedSeats = new HashMap<>();
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    long LOCK_TIMEOUT_MS = 500;

    public void lockSeats(Show show, List<Seat> seats, String userId)
    {
        synchronized (show)
        {
            for(Seat seat: seats)
            {
                if(seat.getStatus() != SeatStatus.AVAILABLE)
                {
                    System.out.println("Seat "+ seat.getId() + "is not available");
                    return;
                }
            }

            for(Seat seat: seats)
            {
                seat.setStatus(SeatStatus.LOCKED);
            }
            lockedSeats.computeIfAbsent(show, k -> new ConcurrentHashMap<>());

            for(Seat seat: seats)
            {
                lockedSeats.get(show).put(seat, userId);
            }

            scheduledExecutorService.schedule(() -> unlockSeats(show, seats, userId),LOCK_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            System.out.println("Locked seats: " + seats.stream().map(Seat::getId).toList() + " for user " + userId);
        }

    }


    public void unlockSeats(Show show, List<Seat> seats, String userId) {
        synchronized (show) {
            Map<Seat, String> showLocks = lockedSeats.get(show);
            if (showLocks != null) {
                for (Seat seat : seats) {
                    // Only unlock if it's still locked by the same user (prevents race conditions)
                    if (showLocks.containsKey(seat) && showLocks.get(seat).equals(userId)) {
                        showLocks.remove(seat);
                        if(seat.getStatus() == SeatStatus.LOCKED) {
                            seat.setStatus(SeatStatus.AVAILABLE);
                            System.out.println("Unlocked seat: " + seat.getId() + " due to timeout.");
                        } else {
                            showLocks.remove(seat);
                            System.out.println("Unlocked seat: " + seat.getId() + " due to booking completion.");
                        }
                    }
                }
                if (showLocks.isEmpty()) {
                    lockedSeats.remove(show);
                }
            }
        }
    }
    public void shutdown() {
        System.out.println("Shutting down SeatLockProvider scheduler.");
        scheduledExecutorService.shutdown();
        try {
            if (!scheduledExecutorService.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduledExecutorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
