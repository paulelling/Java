package Scheduling;

public class DogScheduleSettingFactory implements ScheduleSettingFactory {

    public Event createEvent() {
        return new DogCareEvent();
    }

    public Time createTime() {
        return new EveningTime();
    }

    public Pet createPet() {
        return new DogPet();
    }
    
}
