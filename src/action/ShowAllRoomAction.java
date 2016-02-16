package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import po.Room;
import service.RoomServiceInter;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author zhanglaijei
 *
 */

@Controller
public class ShowAllRoomAction extends ActionSupport{
	@Autowired
	private RoomServiceInter roomService;
	
	private List<Room> list;
	
	
	public List<Room> getList() {
		return list;
	}

	public void setList(List<Room> list) {
		this.list = list;
	}

	@Action(value="/showAllRoom",results={@Result(name="show",location="/meetingrooms.jsp")})
	public String add(){
		
		list = roomService.getAllRoom();
		for(Room room:list){
			System.out.println(room.toString());
		}
		return "show";
	}
	
}
