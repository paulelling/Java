package Scheduling;

public class CatCleaningSchedule extends Schedule {
    ScheduleSettingFactory settingFactory;
    
    public CatCleaningSchedule(ScheduleSettingFactory settingFactory) {
        this.settingFactory = settingFactory;
    }

    void makeAppointment() {
        System.out.println("Preparing " + name);
        event = settingFactory.createEvent();
        time = settingFactory.createTime();
        pet = settingFactory.createPet();
    }      
}
