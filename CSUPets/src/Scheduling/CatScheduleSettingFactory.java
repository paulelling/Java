package Scheduling;

public class CatScheduleSettingFactory implements ScheduleSettingFactory {
    
    public Event createEvent() {
        return new CatCareEvent();
    }

    public Time createTime() {
        return new AfternoonTime();
    }

    public Pet createPet() {
        return new CatPet();
    }    
    
}
