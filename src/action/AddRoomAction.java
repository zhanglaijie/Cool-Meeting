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
 * @author shaohuan
 *
 */
@Controller
public class AddRoomAction extends ActionSupport{
	@Autowired
	private RoomServiceInter roomService;
	
	private String rid;
	private String rname;
	private String maxnum;
	private String rstate;
	private String rremark;
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
	
	@Action(value="/AddRoom",results={@Result(name="show",location="/showAllRoom",type="redirect"),@Result(name="have",location="/addmeetingroom.jsp")})
	public String add() {
		if (roomService.getByIdRoom(rid)!= null) {
			result = "该房间已经存在";
			System.out.println(result);
			return "have";
		} 
		else {
			Room room = new Room(rid, rname, Integer.parseInt(maxnum),
					Integer.parseInt(rstate), rremark, null);
			System.out.println(room.toString());
			roomService.addRoom(room);
			return "show";
			}
	}
}
