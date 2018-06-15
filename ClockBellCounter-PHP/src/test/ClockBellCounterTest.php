<?php

namespace test;

require "src/kbra/ClockBellCounter.php";

use PHPUnit\Framework\TestCase;
use kbra\ClockBellCounter;

class ClockBellCounterTest extends TestCase
{
    
    public function test_countBells_exactHoursMorning()
    {
        $clockBellCounter = new ClockBellCounter();
        $startTime = "2:00";
        $endTime = "3:00";
        $expectedBells = 5;
        
        $bells = $clockBellCounter->countBells($startTime, $endTime);
        
        $this->assertEquals($expectedBells, $bells);
    }
    
    public function test_countBells_exactHoursAfternoon()
    {
    	$clockBellCounter = new ClockBellCounter();
    	$startTime = "14:00";
    	$endTime = "15:00";
    	$expectedBells = 5;
    
    	$bells = $clockBellCounter->countBells($startTime, $endTime);
    
    	$this->assertEquals($expectedBells, $bells);
    }
    
    public function test_countBells_notTheExactHours()
    {
    	$clockBellCounter = new ClockBellCounter();
    	$startTime = "14:23";
    	$endTime = "15:42";
    	$expectedBells = 3;
    
    	$bells = $clockBellCounter->countBells($startTime, $endTime);
    
    	$this->assertEquals($expectedBells, $bells);
    }
    
    public function test_countBells_oneDaytoAnother()
    {
    	$clockBellCounter = new ClockBellCounter();
    	$startTime = "23:00";
    	$endTime = "1:00";
    	$expectedBells = 24;
    
    	$bells = $clockBellCounter->countBells($startTime, $endTime);
    
    	$this->assertEquals($expectedBells, $bells);
    }
    
    public function test_countBells_withinSameHour()
    {
    	$clockBellCounter = new ClockBellCounter();
    	$startTime = "12:15";
    	$endTime = "12:19";
    	$expectedBells = 0;
    
    	$bells = $clockBellCounter->countBells($startTime, $endTime);
    
    	$this->assertEquals($expectedBells, $bells);
    }
    
    public function test_countBells_sameHourDifferentDay()
    {
    	$clockBellCounter = new ClockBellCounter();
    	$startTime = "16:20";
    	$endTime = "16:20";
    	$expectedBells = 158;
    
    	$bells = $clockBellCounter->countBells($startTime, $endTime);
    
    	$this->assertEquals($expectedBells, $bells);
    }
    
    public function test_countBells_sameHourDifferentMinuteDifferentDay()
    {
    	$clockBellCounter = new ClockBellCounter();
    	$startTime = "1:25";
    	$endTime = "1:01";
    	$expectedBells = 156;
    
    	$bells = $clockBellCounter->countBells($startTime, $endTime);
    
    	$this->assertEquals($expectedBells, $bells);
    }
}