package Scheduling;

public class FishFeedingSchedule extends Schedule {
    ScheduleSettingFactory settingFactory;
    
    public FishFeedingSchedule(ScheduleSettingFactory settingFactory) {
        this.settingFactory = settingFactory;
    }

    void makeAppointment() {
        System.out.println("Preparing " + name);
        event = settingFactory.createEvent();
        time = settingFactory.createTime();
        pet = settingFactory.createPet();
    }  
}
