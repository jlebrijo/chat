package lebrijo.chat;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean
@FacesConverter(value="roomsCombo")
public class RoomsCombo implements Converter {
	@ManagedProperty(value = "#{chat}")
	private Chat chat;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		for (Room r : chat.getRooms())
			if (r.getName().equals(value))
				return r;
		return new Room("no room");
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null)
			return "";
		return ((Room) value).getName();
	}

	public Set<Room> getList() {
		return chat.getRooms();
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

}
