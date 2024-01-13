import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

    public static class Activity {
        int start, finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    public static List<Activity> selectActivities(List<Activity> activities) {
        List<Activity> selectedActivities = new ArrayList<>();

        // Sort activities based on finish times in ascending order
        Collections.sort(activities, Comparator.comparingInt(activity -> activity.finish));

        selectedActivities.add(activities.get(0));
        for (int i = 1; i < activities.size(); i++) {
            // If the current activity's start time is after or equal to
            // the previously selected activity's finish time, add it to the selected list
            if (activities.get(i).start >= selectedActivities.get(selectedActivities.size() - 1).finish) {
                selectedActivities.add(activities.get(i));
            }
        }

        return selectedActivities;
    }

    public static void main(String[] args) {
        List<Activity> activities = new ArrayList<>();

        activities.add(new Activity(1, 4));
        activities.add(new Activity(3, 5));
        activities.add(new Activity(0, 6));
        activities.add(new Activity(5, 7));
        activities.add(new Activity(3, 8));
        activities.add(new Activity(5, 9));
        activities.add(new Activity(6, 10));
        activities.add(new Activity(8, 11));
        
        List<Activity> selectedActivities = selectActivities(activities);

        System.out.println("Selected Activities: ");
        for (Activity activity : selectedActivities) {
            System.out.println("[" + activity.start + ", " + activity.finish + "]");
        }
    }
}
