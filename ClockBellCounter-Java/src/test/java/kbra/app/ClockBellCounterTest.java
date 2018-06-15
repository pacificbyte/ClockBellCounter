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
    Integer expectedBells;
    Integer bells;
    
    @Before
    public void init() {
        bellCounter = new ClockBellCounter();
    }

    @Test
    public void countBells_exactHoursMorning()
    {
        startTime = LocalTime.of(2, 0);
        endTime = LocalTime.of(3, 0);
        expectedBells = 5;
        bells = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedBells, bells );
    }
    
    @Test
    public void countBells_exactHoursAfternoon()
    {
        startTime = LocalTime.of(14, 0);
        endTime = LocalTime.of(15, 0);
        expectedBells = 5;
        bells = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedBells, bells );
    }
    
    @Test
    public void countBells_notTheExactHours()
    {
        startTime = LocalTime.of(14, 23);
        endTime = LocalTime.of(15, 42);
        expectedBells = 3;
        bells = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedBells, bells );
    }
    
    @Test
    public void countBells_oneDaytoAnother()
    {
        startTime = LocalTime.of(23, 0);
        endTime = LocalTime.of(1, 0);
        expectedBells = 24;
        bells = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedBells, bells );
    }
    
    @Test
    public void countBells_withinSameHour()
    {
        startTime = LocalTime.of(12, 15);
        endTime = LocalTime.of(12, 19);
        expectedBells = 0;
        bells = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedBells, bells );
    }
    
    @Test
    public void countBells_sameHourDifferentDay()
    {
        startTime = LocalTime.of(16, 20);
        endTime = LocalTime.of(16, 20);
        expectedBells = 158;
        bells = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedBells, bells );
    }
    
    @Test
    public void countBells_sameHourDifferentMinuteDifferentDay()
    {
        startTime = LocalTime.of(1, 25);
        endTime = LocalTime.of(1, 1);
        expectedBells = 156;
        bells = bellCounter.countBells(startTime.toString(), endTime.toString());
        assertEquals( expectedBells, bells );
    }
}
