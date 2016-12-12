package Scheduling;

public class DogMedicineSchedule extends Schedule {
    ScheduleSettingFactory settingFactory;
    
    public DogMedicineSchedule(ScheduleSettingFactory settingFactory) {
        this.settingFactory = settingFactory;
    }

    void makeAppointment() {
        System.out.println("Preparing " + name);
        event = settingFactory.createEvent();
        time = settingFactory.createTime();
        pet = settingFactory.createPet();
    }    
}
