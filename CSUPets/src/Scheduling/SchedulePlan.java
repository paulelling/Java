package Scheduling;

public abstract class SchedulePlan {
    
    protected abstract Schedule createSchedule(String item);
    
    public Schedule setSchedule(String type) {
        Schedule schedule = createSchedule(type);
        System.out.println("-- Scheduling " + schedule.getName() + " --");
        schedule.identifyEvent();
        schedule.determineTime();
        schedule.selectPet();
        return schedule;
    }
    
}
