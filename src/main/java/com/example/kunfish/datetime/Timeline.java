package com.example.kunfish.datetime;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;


public class Timeline {

    @Test
    void demo_timeElapsedUsingDuration() throws InterruptedException {

    Instant start = Instant.now();
    Thread.sleep(2000);
    Instant end = Instant.now();
    Duration timeElapsed = Duration.between(start, end);

    long seconds = timeElapsed.toSeconds();
    System.out.printf("%d seconds\n", seconds);

    }
}
