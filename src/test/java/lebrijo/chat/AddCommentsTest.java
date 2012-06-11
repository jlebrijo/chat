package lebrijo.chat;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AddCommentsTest extends ChatSetup {
	@Before
	public void setUpComments() {
		speaker1.setComment("hola");
		speaker1.addComment();
	}

	@Test
	public void user_add_comments() {
		assertEquals(speaker1.getNick() + "> hola", room1.getBoard().get(0));
	}

	@Test
	public void user_read_comments_of_others_in_the_same_room() {
		Speaker speaker2 = new Speaker("speaker2");
		room1.add(speaker2);
		speaker2.setRoom(room1);
		assertEquals(speaker1.getNick() + "> hola", speaker2.getRoom()
				.getBoard().get(0));
	}

}
