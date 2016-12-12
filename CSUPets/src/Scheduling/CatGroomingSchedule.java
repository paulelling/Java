package Scheduling;

public class CatGroomingSchedule extends Schedule {
    ScheduleSettingFactory settingFactory;
    
    public CatGroomingSchedule(ScheduleSettingFactory settingFactory) {
        this.settingFactory = settingFactory;
    }

    void makeAppointment() {
        System.out.println("Preparing " + name);
        event = settingFactory.createEvent();
        time = settingFactory.createTime();
        pet = settingFactory.createPet();
    }      
}
