package lebrijo.chat;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;

@ManagedBean
@ViewScoped
public class Speaker implements Comparable<Speaker>, Serializable {
	private static final long serialVersionUID = 1L;
	private String nick;
	private Room room;
	private String comment;
	private String newRoomName;

	@ManagedProperty(value = "#{chat}")
	private Chat chat;

	public void leaveRoom(CloseEvent event) {
		room.getSpeakers().remove(this);
	}

	public void enterRoom() {
		try {
			if (!"".equals(newRoomName))
				room = new Room(newRoomName);
			if (room == null)
				throw new RuntimeException("Select a room is required");
			if ("".equals(nick))
				throw new RuntimeException("Choose a nick is required");
			if (!"".equals(newRoomName) && chat.getRooms().contains(room))
				throw new RuntimeException("Duplicated room name: "+newRoomName);
			chat.add(room);
			room.add(this);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					"enterRoom",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e
							.getMessage(), ""));
		}
	}

	public void addComment() {
		room.getBoard().add(this.nick + "> " + comment);
		comment = "";
	}

	public int compareTo(Speaker o) {
		return this.nick.compareTo(o.getNick());
	}

	public Speaker(String nick) {
		this.setNick(nick);
	}

	public Speaker() {

	}

	@Override
	public String toString() {
		return nick;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Room getRoom() {
		if (room == null)
			this.room = new Room();
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getNewRoomName() {
		return newRoomName;
	}

	public void setNewRoomName(String newRoomName) {
		this.newRoomName = newRoomName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
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
		Speaker other = (Speaker) obj;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		return true;
	}

}
