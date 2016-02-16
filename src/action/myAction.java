package action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import po.Emp;
import po.Meet;
import service.EmpService;
import service.MeetServiceInter;
import service.RoomServiceInter;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author daybreak
 * 
 */
public class myAction extends ActionSupport {

	@Autowired
	private MeetServiceInter meetService;
	@Autowired
	private RoomServiceInter roomService;
	@Autowired
	private EmpService empService;
	private String ename;
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
	private List<Meet> listmeet;
	private Meet list;
	private List<Emp> emplist = new ArrayList<Emp>();
	private List<Meet> meetlist = new ArrayList<Meet>();

	public RoomServiceInter getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomServiceInter roomService) {
		this.roomService = roomService;
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

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
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

	public List<Meet> getListmeet() {
		return listmeet;
	}

	public void setListmeet(List<Meet> listmeet) {
		this.listmeet = listmeet;
	}

	public Meet getList() {
		return list;
	}

	public void setList(Meet list) {
		this.list = list;
	}

	public List<Emp> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<Emp> emplist) {
		this.emplist = emplist;
	}

	public List<Meet> getMeetlist() {
		return meetlist;
	}

	public void setMeetlist(List<Meet> meetlist) {
		this.meetlist = meetlist;
	}

	@Action(value = "myAction", results = { @Result(name = "ok", location = "/mybookings.jsp") })
	public String mybook() {
		// System.out.println(ename +"hh");
		listmeet = meetService.getByeid(empService.getByEname(ename).get(0)
				.getEid());
		return "ok";
	}

	@Action(value = "closeAction", results = { @Result(name = "ok", location = "/mybookings.jsp") })
	public String close() {
		System.out.println("dd" + mname + cancelreason);
		Meet meet = meetService.getByNameMeet(mname);
		meet.setMstate(-1);
		meet.setCancelreason(cancelreason);
		meetService.updateMeet(meet);
		return "ok";
	}

	@Action(value = "mymeetingAction", results = { @Result(name = "ok", location = "/mymeetings.jsp") })
	public String mymeet() {
		Timestamp nt = new Timestamp(System.currentTimeMillis());
		List<Meet> melist = meetService.getAllMeet();
		for (Meet me : melist) {
			long num = nt.getTime()
					- ((Timestamp) me.getMstarttime()).getTime();
			String[] sourceStrArray = me.getMemps().split("#");
			System.out.println(sourceStrArray.length + ":55555"
					+ sourceStrArray[0]);
			for (int i = 0; i < sourceStrArray.length; i++) {
				if (ename.equals(empService.getById(
						Integer.parseInt(sourceStrArray[i])).getEname())
						&& num <= 0 && me.getMstate() == 1) {
					meetlist.add(me);
				}
			}
		}
		return "ok";
	}

}
