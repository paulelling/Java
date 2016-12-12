package Scheduling;

public class CatMedicineSchedule extends Schedule {
    ScheduleSettingFactory settingFactory;
    
    public CatMedicineSchedule(ScheduleSettingFactory settingFactory) {
        this.settingFactory = settingFactory;
    }

    void makeAppointment() {
        System.out.println("Preparing " + name);
        event = settingFactory.createEvent();
        time = settingFactory.createTime();
        pet = settingFactory.createPet();
    }      
}
