package Scheduling;

public abstract class Schedule {
    String name;
    
    Event event;
    Time time;
    Pet pet;
    
    abstract void makeAppointment();
    
    void identifyEvent() {
        System.out.println("Identify event to schedule");
    }
    
    void determineTime() {
        System.out.println("Determine time to schedule event");
    }
    
    void selectPet() {
        System.out.println("Select pet to schedule event for");
    }
    
    void setName(String name) {
        this.name = name;
    }
    
    String getName() {
        return name;
    }
    
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("-- " + name + " --\n");
        if (event != null) {
            result.append(event);
            result.append("\n");
        }
        if (time != null) {
            result.append(time);
            result.append("\n");
        }
        if (pet != null) {
            result.append(pet);
            result.append("\n");
        }
        return result.toString();
    }
    
}
