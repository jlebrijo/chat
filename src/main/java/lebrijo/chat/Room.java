package lebrijo.chat;

import java.util.ArrayList;
import java.util.List;

public class Room implements Comparable<Room> {
	private String name;
	private List<String> board;
	private List<Speaker> speakers;

	public Room(String name) {
		this.setName(name);
	}

	public Room() {

	}

	public List<String> getLastComments() {
		if (board == null)
			board = new ArrayList<String>(20);
		int boardSize = board.size();
		if (boardSize < 10)
			return board;
		return board.subList(boardSize - 10, boardSize);
	}

	public int compareTo(Room anotherRoom) {
		if (this.name == null)
			return -1;
		return anotherRoom.getName().compareTo(this.name);
	}

	public void add(Speaker speaker) {
		if (speakers == null)
			speakers = new ArrayList<Speaker>();
		if (speakers.contains(speaker))
			throw new RuntimeException("Duplicated speaker: "
					+ speaker.getNick());
		speakers.add(speaker);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getBoard() {
		if (board == null)
			board = new ArrayList<String>(20);
		return board;
	}

	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setBoard(List<String> board) {
		this.board = board;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}

}
