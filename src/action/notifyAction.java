package action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import po.Dept;
import po.Emp;
import po.Meet;
import po.Room;
import service.EmpService;
import service.MeetServiceInter;
import service.RoomServiceInter;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 
 * @author daybreak
 *
 */
@Controller
public class notifyAction extends ActionSupport {
	@Autowired
	private MeetServiceInter meetService;
	@Autowired
	private RoomServiceInter roomService;
	@Autowired
	private EmpService empService;
	private String mname;
	private int mnumber;
	private Timestamp mstarttime;
	private Timestamp mendtime;
	private Timestamp appointtime;
	private String rid;
	private String mremark;
	private String memps;
	private int mstate;
	private String cancelreason;
	private int appointmentid;
	private List<Meet> listnews;
	private List<Meet> listcanle;
	private Meet list;
	private List<Emp> emplist = new ArrayList<Emp>();

	public List<Emp> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<Emp> emplist) {
		this.emplist = emplist;
	}

	public Meet getList() {
		return list;
	}

	public void setList(Meet list) {
		this.list = list;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getMnumber() {
		return mnumber;
	}

	public void setMnumber(int mnumber) {
		this.mnumber = mnumber;
	}

	public Timestamp getMstarttime() {
		return mstarttime;
	}

	public void setMstarttime(Timestamp mstarttime) {
		this.mstarttime = mstarttime;
	}

	public Timestamp getMendtime() {
		return mendtime;
	}

	public void setMendtime(Timestamp mendtime) {
		this.mendtime = mendtime;
	}

	public Timestamp getAppointtime() {
		return appointtime;
	}

	public void setAppointtime(Timestamp appointtime) {
		this.appointtime = appointtime;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
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

	public int getMstate() {
		return mstate;
	}

	public void setMstate(int mstate) {
		this.mstate = mstate;
	}

	public String getCancelreason() {
		return cancelreason;
	}

	public void setCancelreason(String cancelreason) {
		this.cancelreason = cancelreason;
	}

	public int getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}

	public List<Meet> getListnews() {
		return listnews;
	}

	public void setListnews(List<Meet> listnews) {
		this.listnews = listnews;
	}

	public List<Meet> getListcanle() {
		return listcanle;
	}

	public void setListcanle(List<Meet> listcanle) {
		this.listcanle = listcanle;
	}

	@Action(value = "notifyAction", results = { @Result(name = "ok", location = "/notifications.jsp") })
	public String shownews() {
		listnews = meetService.getByTime();
		listcanle = meetService.getByState();
		return "ok";
	}

	@Actions({
	@Action(value = "DAction", results = { @Result(name = "ok", location = "/meetingdetails.jsp") }),
	@Action(value = "MyDAction", results = { @Result(name = "ok", location = "/mymeetingdetails.jsp") })
	}
	)
	public String Button() {
		list = meetService.getByNameMeet(mname);
		String sourceStr = list.getMemps();
		String[] sourceStrArray = sourceStr.split("#");
		for (int i = 0; i < sourceStrArray.length; i++) {
			Emp emp = new Emp(empService.getById(
					Integer.parseInt(sourceStrArray[i])).getNames(), empService
					.getById(Integer.parseInt(sourceStrArray[i])).getEname(),
					empService.getById(Integer.parseInt(sourceStrArray[i]))
							.getEpasswd(), empService.getById(
							Integer.parseInt(sourceStrArray[i])).getEphone(),
					empService.getById(Integer.parseInt(sourceStrArray[i]))
							.getEmail());
			emplist.add(emp);
		}
		return "ok";
	}

}
