package action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import po.Emp;
import po.Meet;
import po.Room;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.EmpDAO;
import service.EmpService;
import service.MeetServiceInter;
import service.RoomServiceInter;

/**
 * 
 * @author chengguohui
 * @
 *
 */
@Controller
public class BookMeetAction extends ActionSupport{
	@Autowired
	private MeetServiceInter meetService;
	
	@Autowired
	private RoomServiceInter roomService;
	
	@Autowired
	private EmpService empService;
	
	private String mname;
	private String rid ;
	private Integer mnumber;
	private String mremark;
	private String memps;
	private String startdate;
	private String starttime;
	private String rname;
	private String ename;
	private List<Meet> meetlist;
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public List<Meet> getMeetlist() {
		return meetlist;
	}
	public void setMeetlist(List<Meet> meetlist) {
		this.meetlist = meetlist;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}




	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	private String enddate;
	private String endtime;

	public String getStartdate() {
		return startdate;
	}

	public String getStarttime() {
		return starttime;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}



	
	public MeetServiceInter getMeetService() {
		return meetService;
	}

	public void setMeetService(MeetServiceInter meetService) {
		this.meetService = meetService;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Integer getMnumber() {
		return mnumber;
	}


	public void setMnumber(Integer mnumber) {
		this.mnumber = mnumber;
	}


	public String getMremark() {
		return mremark;
	}

	public void setMremark(String mremark) {
		this.mremark = mremark;
	}

	public String getMemps() {
		return memps;
	}

	public void setMemps(String memps) {
		this.memps = memps;
	}
	@Action(value="/AddMeet",results={@Result(name="show",location="/index.jsp")})
	public String add(){
		//System.out.println("addmeet"+memps);
		
		//System.out.println(mname+"#"+rid+"#"+mnumber+"#"+startdate+starttime+"#"+enddate+"#"+mremark+"#"+memps);
		
		String mstarttime = startdate+" "+starttime+":00";
		String mendtime = enddate+" "+endtime+":00";
		Timestamp mstarttimes = Timestamp.valueOf(mstarttime);
		Timestamp mendtimes = Timestamp.valueOf(mendtime);
		Timestamp appointtime = new Timestamp(System.currentTimeMillis());
		String ename = (String) ActionContext.getContext().getSession().get("ename");
		System.out.println(ename+"li");
		List<Emp> emps =empService.getByEname(ename);
		Emp emp = emps.get(0);
		Room room = roomService.getByIdRoom(rid);
		Meet meet = new Meet(mname, emp, room, mnumber, mstarttimes, mendtimes, appointtime, mremark, memps, 1);
		//System.out.println(meet.toString());
		meetService.addMeet(meet);
	

		meetlist = meetService.getAllMeet();
	
		return "show";
	}
}
