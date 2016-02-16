package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import po.Room;
import service.RoomServiceInter;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author wangyilong
 *
 */
@Controller
public class GoUpdateRoomAction extends ActionSupport{
	@Autowired
	private RoomServiceInter roomService;
	
	private String rid;
	private String rname;
	private String maxnum;
	private String rstate;
	private String rremark;
	private Room room;
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getMaxnum() {
		return maxnum;
	}

	public void setMaxnum(String maxnum) {
		this.maxnum = maxnum;
	}

	public String getRstate() {
		return rstate;
	}

	public void setRstate(String rstate) {
		this.rstate = rstate;
	}

	public String getRremark() {
		return rremark;
	}

	public void setRremark(String rremark) {
		this.rremark = rremark;
	}
	
	@Action(value="/GoUpdateRoom",results={@Result(name="update",location="/roomdetails.jsp")})
	public String add(){
		System.out.println(rid);
		room = roomService.getByIdRoom(rid);
		return "update";
	}
	
}
