package lebrijo.chat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class LoginTest extends ChatSetup {
	@Test
	public void user_adds_unique_rooms() {
		assertTrue(chat.getRooms().contains(room1));
	}

	@Test
	public void user_adds_a_nick() throws Exception {
		assertTrue(room1.getSpeakers().contains(speaker1));
	}

	@Test
	public void user_adds_a_repeated_nick_in_the_room() throws Exception {
		try {
			room1.add(new Speaker(speaker1.getNick()));
			fail("No Exception");
		} catch (Exception e) {
			assertEquals("Duplicated speaker: " + speaker1.getNick(),
					e.getMessage());
		}
	}
}
