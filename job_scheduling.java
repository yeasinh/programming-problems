import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobScheduling {

    public static class Job {
        char id;
        int deadline;
        int profit;

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static List<Job> scheduleJobs(List<Job> jobs) {
        List<Job> scheduledJobs = new ArrayList<>();

        // Sort jobs based on profit in descending order
        Collections.sort(jobs, Comparator.comparingInt(job -> job.profit));
        
        // Find the maximum deadline to create the time slot later
        int maxDeadline = Integer.MIN_VALUE;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        boolean[] slotOccupied = new boolean[maxDeadline];

        for (Job job : jobs) {
            // Give the latest possible slot that suits the job's deadline
            for (int i = Math.min(maxDeadline - 1, job.deadline - 1); i >= 0; i--) {
                if (!slotOccupied[i]) {
                    scheduledJobs.add(job);
                    slotOccupied[i] = true;
                    break;
                }
            }
        }

        return scheduledJobs;
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job('A', 2, 100));
        jobs.add(new Job('B', 1, 19));
        jobs.add(new Job('C', 2, 27));
        jobs.add(new Job('D', 1, 25));
        jobs.add(new Job('E', 3, 15));

        List<Job> scheduledJobs = scheduleJobs(jobs);

        System.out.println("Scheduled Jobs:");
        for (Job job : scheduledJobs) {
            System.out.println("Job " + job.id + " (Profit: " + job.profit + ", Deadline: " + job.deadline + ")");
        }
    }
}
