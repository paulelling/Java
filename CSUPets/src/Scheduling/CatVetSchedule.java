package Scheduling;

public class CatVetSchedule extends Schedule {
    ScheduleSettingFactory settingFactory;
    
    public CatVetSchedule(ScheduleSettingFactory settingFactory) {
        this.settingFactory = settingFactory;
    }

    void makeAppointment() {
        System.out.println("Preparing " + name);
        event = settingFactory.createEvent();
        time = settingFactory.createTime();
        pet = settingFactory.createPet();
    }      
}
