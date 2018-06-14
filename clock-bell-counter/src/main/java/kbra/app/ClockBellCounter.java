package kbra.app;

public class ClockBellCounter {

    public Integer countBells (String startTime, String endTime) {
        Integer rings = 0;
        
        if(startTime.equals(endTime)) {
            return 158;
        }
        
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        
        Integer startHour = convertMilitaryHoursToStandartHours(Integer.parseInt(start[0]));
        Integer startMinutes = Integer.parseInt(start[1]);
        Integer endHour = convertMilitaryHoursToStandartHours(Integer.parseInt(end[0]));
        Integer endMinutes = Integer.parseInt(end[1]);
        
        
        if(startMinutes == 0) {
            rings += startHour;
        }
        
        if(startHour == endHour) {
            if(startMinutes > endMinutes) {
                for(int i = 1; i <= 12; i++) {
                    rings += i;
                }
                rings *= 2;
            }
        }
        else {
            rings += endHour;
        }
       
        
        if(startHour > endHour) {
            rings += 12;
       
        }
        else  if(startHour - endHour > 1) {
            rings += startHour - endHour;
        }
        
        return rings;
    }

    private Integer convertMilitaryHoursToStandartHours(int militaryHoursTime) {
        Integer standardHoursTime = 0;
        
        if(militaryHoursTime > 12) {
            standardHoursTime = militaryHoursTime - 12;
        }
        else if(militaryHoursTime == 0) {
            standardHoursTime = 12;
        }
        else {
            return militaryHoursTime;
        }
        
        return standardHoursTime;
    }
}
