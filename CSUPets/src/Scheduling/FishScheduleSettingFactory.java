package Scheduling;

public class FishScheduleSettingFactory implements ScheduleSettingFactory {
    
    public Event createEvent() {
        return new FishCareEvent();
    }

    public Time createTime() {
        return new MorningTime();
    }

    public Pet createPet() {
        return new FishPet();
    }    
    
}
