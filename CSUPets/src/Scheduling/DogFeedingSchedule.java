package Scheduling;

public class DogFeedingSchedule extends Schedule {
    ScheduleSettingFactory settingFactory;
    
    public DogFeedingSchedule(ScheduleSettingFactory settingFactory) {
        this.settingFactory = settingFactory;
    }

    void makeAppointment() {
        System.out.println("Preparing " + name);
        event = settingFactory.createEvent();
        time = settingFactory.createTime();
        pet = settingFactory.createPet();
    }    
}
