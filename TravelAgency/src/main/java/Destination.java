
// Destination.java
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a destination with activities available.
 */
public class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * Adds an activity to the destination.
     * 
     * @param activity The activity to add.
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * Removes an activity from the destination.
     * 
     * @param activity The activity to remove.
     */
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }
}
