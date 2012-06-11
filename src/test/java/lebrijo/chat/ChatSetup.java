package lebrijo.chat;

import org.junit.Before;

public class ChatSetup {

	protected Chat chat = new Chat();
	protected Room room1;
	protected Speaker speaker1;

	public ChatSetup() {
		super();
	}

	@Before
	public void setUp() {
		room1 = new Room("room1");
		chat.add(room1);
		speaker1 = new Speaker("speaker1");
		speaker1.setRoom(room1);
		room1.add(speaker1);
	}

}