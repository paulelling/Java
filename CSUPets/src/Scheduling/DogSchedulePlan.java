package Scheduling;

public class DogSchedulePlan extends SchedulePlan {    

    protected Schedule createSchedule(String item) {
        Schedule schedule =  null;
        ScheduleSettingFactory settingFactory = new DogScheduleSettingFactory();
        
        if (item.equals("feed")) {
            schedule = new DogFeedingSchedule(settingFactory);
            schedule.setName("Dog Feeding Schedule");
        }
        else if (item.equals("visit vet")) {
            schedule = new DogVetSchedule(settingFactory);
            schedule.setName("Dog Vet Schedule");
        }
        else if (item.equals("medicate")) {
            schedule = new DogMedicineSchedule(settingFactory);
            schedule.setName("Dog Medicine Schedule");
        }
        else if (item.equals("clean")) {
            schedule = new DogCleaningSchedule(settingFactory);
            schedule.setName("Dog Cleaning Schedule");
        }
        else if (item.equals("groom")) {
            schedule = new DogGroomingSchedule(settingFactory);
            schedule.setName("Dog Grooming Schedule");
        }
        
        return schedule;
    }
    
}
