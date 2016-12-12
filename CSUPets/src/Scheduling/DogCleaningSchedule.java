package Scheduling;

public class DogCleaningSchedule extends Schedule {
    ScheduleSettingFactory settingFactory;
    
    public DogCleaningSchedule(ScheduleSettingFactory settingFactory) {
        this.settingFactory = settingFactory;
    }

    void makeAppointment() {
        System.out.println("Preparing " + name);
        event = settingFactory.createEvent();
        time = settingFactory.createTime();
        pet = settingFactory.createPet();
    }     
}
