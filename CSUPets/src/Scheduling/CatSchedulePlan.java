package Scheduling;

public class CatSchedulePlan extends SchedulePlan {

    protected Schedule createSchedule(String item) {
        Schedule schedule =  null;
        ScheduleSettingFactory settingFactory = new CatScheduleSettingFactory();
        
        if (item.equals("feed")) {
            schedule = new CatFeedingSchedule(settingFactory);
            schedule.setName("Cat Feeding Schedule");
        }
        else if (item.equals("visit vet")) {
            schedule = new CatVetSchedule(settingFactory);
            schedule.setName("Cat Vet Schedule");
        }
        else if (item.equals("medicate")) {
            schedule = new CatMedicineSchedule(settingFactory);
            schedule.setName("Cat Medicine Schedule");
        }
        else if (item.equals("clean")) {
            schedule = new CatCleaningSchedule(settingFactory);
            schedule.setName("Cat Cleaning Schedule");
        }
        else if (item.equals("groom")) {
            schedule = new CatGroomingSchedule(settingFactory);
            schedule.setName("Cat Grooming Schedule");
        }
        
        return schedule;
    }
    
}
