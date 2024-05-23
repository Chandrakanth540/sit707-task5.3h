package sit707_tasks;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


public class OnTrackTest {

	@Test
	public void testTaskInbox() {
	    List<String> tasks = OnTrack.taskInbox("123");
	    Assert.assertEquals(0, tasks.size());
	    Assert.assertNotNull(tasks.contains("1"));
	    Assert.assertNotNull(tasks.contains("2"));
	}

	@Test
	public void testViewInboxTask() {
	    Map<String, Object> taskDetails = OnTrack.viewInboxTask("1");
	    Assert.assertEquals("Not found", taskDetails.get("feedbackStatus"));
	    List<String> messages = (List<String>) taskDetails.get("messages");
	    Assert.assertEquals(0, messages.size());
	    Assert.assertNotNull(messages.contains("Message1"));
	    Assert.assertNotNull(messages.contains("Message2"));
	}

	@Test
	public void testViewInboxTaskNotFound() {
	    Map<String, Object> taskDetails = OnTrack.viewInboxTask("4");
	    Assert.assertEquals("Not found", taskDetails.get("feedbackStatus"));
	    List<String> messages = (List<String>) taskDetails.get("messages");
	    Assert.assertEquals(0, messages.size());
	}

}
