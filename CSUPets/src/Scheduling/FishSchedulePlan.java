package Scheduling;

public class FishSchedulePlan extends SchedulePlan {
    
    protected Schedule createSchedule(String item) {
        Schedule schedule =  null;
        ScheduleSettingFactory settingFactory = new FishScheduleSettingFactory();
        
        if (item.equals("feed")) {
            schedule = new FishFeedingSchedule(settingFactory);
            schedule.setName("Fish Feeding Schedule");
        }
        else if (item.equals("clean")) {
            schedule = new FishCleaningSchedule(settingFactory);
            schedule.setName("Fish Cleaning Schedule");
        }
        
        return schedule;
    }    
    
}
