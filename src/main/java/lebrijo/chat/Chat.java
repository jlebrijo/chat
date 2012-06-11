package lebrijo.chat;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class Chat implements Serializable {
	private static final long serialVersionUID = 1L;
	private Set<Room> rooms;

	public void add(Room room) {
		if (rooms == null)
			rooms = new TreeSet<Room>();
			rooms.add(room);
	}

	public Chat() {
		super();
		add(new Room("Cars"));
		add(new Room("Houses"));
		add(new Room("Sports"));
	}

	public Set<Room> getRooms() {
		return rooms;
	}
}
