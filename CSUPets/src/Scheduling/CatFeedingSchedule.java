package Scheduling;

public class CatFeedingSchedule extends Schedule {
    ScheduleSettingFactory settingFactory;
    
    public CatFeedingSchedule(ScheduleSettingFactory settingFactory) {
        this.settingFactory = settingFactory;
    }

    void makeAppointment() {
        System.out.println("Preparing " + name);
        event = settingFactory.createEvent();
        time = settingFactory.createTime();
        pet = settingFactory.createPet();
    }      
}
