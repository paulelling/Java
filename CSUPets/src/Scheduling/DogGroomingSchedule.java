package Scheduling;

public class DogGroomingSchedule extends Schedule {
    ScheduleSettingFactory settingFactory;
    
    public DogGroomingSchedule(ScheduleSettingFactory settingFactory) {
        this.settingFactory = settingFactory;
    }

    void makeAppointment() {
        System.out.println("Preparing " + name);
        event = settingFactory.createEvent();
        time = settingFactory.createTime();
        pet = settingFactory.createPet();
    }     
}
