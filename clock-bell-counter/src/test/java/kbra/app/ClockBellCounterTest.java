package kbra.app;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClockBellCounterTest
{
    ClockBellCounter bellCounter;
    LocalTime startTime;
    LocalTime endTime;
    Integer expectedRings;
    Integer rings;
    
    @Before
    public void init() {
        bellCounter = new ClockBellCounter();
    }

    @Test
    public void countBells_exactHoursMorning()
    {
        startTime = LocalTime.of(2, 0);
        endTime = LocalTime.of(3, 0);
        expectedRings = 5;
        rings = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedRings, rings );
    }
    
    @Test
    public void countBells_exactHoursAfternoon()
    {
        startTime = LocalTime.of(14, 0);
        endTime = LocalTime.of(15, 0);
        expectedRings = 5;
        rings = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedRings, rings );
    }
    
    @Test
    public void countBells_notTheExactHours()
    {
        startTime = LocalTime.of(14, 23);
        endTime = LocalTime.of(15, 42);
        expectedRings = 3;
        rings = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedRings, rings );
    }
    
    @Test
    public void countBells_oneDaytoAnother()
    {
        startTime = LocalTime.of(23, 0);
        endTime = LocalTime.of(1, 0);
        expectedRings = 24;
        rings = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedRings, rings );
    }
    
    @Test
    public void countBells_withinSameHour()
    {
        startTime = LocalTime.of(12, 15);
        endTime = LocalTime.of(12, 19);
        expectedRings = 0;
        rings = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedRings, rings );
    }
    
    @Test
    public void countBells_sameHourDifferentDay()
    {
        startTime = LocalTime.of(16, 20);
        endTime = LocalTime.of(16, 20);
        expectedRings = 158;
        rings = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedRings, rings );
    }
    
    @Test
    public void countBells_sameHourDifferentMinuteDifferentDay()
    {
        startTime = LocalTime.of(1, 25);
        endTime = LocalTime.of(1, 1);
        expectedRings = 156;
        rings = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedRings, rings );
    }
}
