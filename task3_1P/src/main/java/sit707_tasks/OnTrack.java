package sit707_tasks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnTrack {

    private static Map<String, String> tasks = new HashMap<>();
    private static Map<String, List<String>> messages = new HashMap<>();

    public static void main(String[] args) {
        // Sample data
        tasks.put("1", "123");
        tasks.put("2", "123");
        tasks.put("3", "456");

        List<String> task1Messages = new ArrayList<>();
        task1Messages.add("Message1");
        task1Messages.add("Message2");
        messages.put("1", task1Messages);

        List<String> task2Messages = new ArrayList<>();
        task2Messages.add("Message3");
        messages.put("2", task2Messages);

        // Example usage
        System.out.println(taskInbox("123"));
        System.out.println(viewInboxTask("1"));
    }

    public static List<String> taskInbox(String studentId) {
        List<String> studentTasks = new ArrayList<>();
        for (Map.Entry<String, String> entry : tasks.entrySet()) {
            if (entry.getValue().equals(studentId)) {
                studentTasks.add(entry.getKey());
            }
        }
        return studentTasks;
    }

    public static Map<String, Object> viewInboxTask(String taskId) {
        Map<String, Object> taskDetails = new HashMap<>();
        if (tasks.containsKey(taskId)) {
            taskDetails.put("feedbackStatus", "Pending");
            taskDetails.put("messages", messages.getOrDefault(taskId, new ArrayList<>()));
        } else {
            taskDetails.put("feedbackStatus", "Not found");
            taskDetails.put("messages", new ArrayList<>());
        }
        return taskDetails;
    }
}
