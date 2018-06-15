<?php

namespace kbra;

class ClockBellCounter {
    
    /**
     * @param string $startTime
     * @param string $endTime
     */
    public function countBells ($startTime, $endTime) {
        $rings = 0;
        
        if( $startTime == $endTime ) {
            return 158;
        }
        
        $start = explode(":", $startTime);
        $end = explode(":", $endTime);
        
         $startHour = $this->militaryToStandard($start[0]);
         $startMinutes = $start[1];
         $endHour = $this->militaryToStandard($end[0]);
         $endMinutes = $end[1];
        
        
        if( $startMinutes == 0 ) {
            $rings += $startHour;
        }
        
        if($startHour == $endHour) {
            if($startMinutes > $endMinutes) {
                for($i = 1; $i <= 12; $i++) {
                    $rings += $i;
                }
                $rings *= 2;
            }
        }
        else {
            $rings += $endHour;
        }
        
        
        if($startHour > $endHour) {
            $rings += 12;
            
        }
        elseif($startHour - $endHour > 1) {
            $rings += $startHour - $endHour;
        }
            
            return $rings;
    }
    
    /**
     * @param int $militaryHoursTime
     * @return int
     */
    private function militaryToStandard($militaryHoursTime) {
         $standardHoursTime = 0;
        
        if($militaryHoursTime > 12) {
            $standardHoursTime = $militaryHoursTime - 12;
        }
        elseif($militaryHoursTime == 0) {
            $standardHoursTime = 12;
        }
        else {
            return $militaryHoursTime;
        }
        
        return $standardHoursTime;
    }
    
}
