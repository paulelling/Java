package Scheduling;

public class DogVetSchedule extends Schedule {
    ScheduleSettingFactory settingFactory;
    
    public DogVetSchedule(ScheduleSettingFactory settingFactory) {
        this.settingFactory = settingFactory;
    }

    void makeAppointment() {
        System.out.println("Preparing " + name);
        event = settingFactory.createEvent();
        time = settingFactory.createTime();
        pet = settingFactory.createPet();
    }    
}
