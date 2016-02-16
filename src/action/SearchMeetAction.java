package action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
public class SearchMeetAction extends ActionSupport {
	@Autowired
	private MeetServiceInter meetService;

	@Autowired
	private RoomServiceInter roomService;

	@Autowired
	private EmpService empService;

	private int total;
	private static int page;
	private int current;
	private String next;
	private int pagetemp;
	private static int m = 0;
	private String first;
	private List<Meet> meetlist;
	private static String prove;
	private String mname;
	private String rname;
	private String names;
	private String appointstart;
	private String appointend;
	private String start;
	private String end;

	// appointstart appointend start end

	public String getAppointstart() {
		return appointstart;
	}

	public void setAppointstart(String appointstart) {
		this.appointstart = appointstart;
	}

	public String getAppointend() {
		return appointend;
	}

	public void setAppointend(String appointend) {
		this.appointend = appointend;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public static int getM() {
		return m;
	}

	public static void setM(int m) {
		SearchMeetAction.m = m;
	}

	public String getProve() {
		return prove;
	}

	public void setProve(String prove) {
		this.prove = prove;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public int getPagetemp() {
		return pagetemp;
	}

	public void setPagetemp(int pagetemp) {
		this.pagetemp = pagetemp;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public List<Meet> getMeetlist() {
		return meetlist;
	}

	public void setMeetlist(List<Meet> meetlist) {
		this.meetlist = meetlist;
	}

	public MeetServiceInter getMeetService() {
		return meetService;
	}

	public void setMeetService(MeetServiceInter meetService) {
		this.meetService = meetService;
	}

	public RoomServiceInter getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomServiceInter roomService) {
		this.roomService = roomService;
	}

	public EmpService getEmpService() {
		return empService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	@Action(value = "/SearchMeet", results = { @Result(name = "show", location = "/searchmeetings.jsp") })
	public String add() {
		System.out.println(prove);
		if (prove.equals("show")) {
			int temp = meetService.getAllMeet().size();
			total = temp;
			page = temp / 10 + 1;
			current = m / 10 + 1;
			meetlist = meetService.getMeetLimit(m, 10);
		} else if (prove.equals("search")) {
			if (first.equals("查询")) {
				m = 0;
			}
			System.out.println(rname);
			meetlist = new ArrayList<>();
			if (!names.isEmpty()) {
				List<Emp> emps = empService.getByName(names);
				Emp emp = emps.get(0);
				meetlist = meetService.getByEmp(emp);
				int temp = meetlist.size();
				total = temp;
				page = temp / 10 + 1;
				current = m / 10 + 1;
			} else if (!mname.isEmpty()) {
				int temp = 1;
				total = temp;
				page = temp / 10 + 1;
				current = m / 10 + 1;
				Meet meet = meetService.getByNameMeet(mname);
				meetlist.add(meet);
			} else if (!rname.isEmpty()) {
				List<Room> rooms = roomService.getByRname(rname);
				for (Room ro : rooms) {
					ro.getRname();
				}
				Room room = rooms.get(0);
				System.out.println(room.getRname() + "out");
				meetlist = meetService.getByRoom(room);
				int temp = meetlist.size();
				total = temp;
				page = temp / 10 + 1;
				current = m / 10 + 1;
			}
			else if((!start.isEmpty())&&(!end.isEmpty())){
				System.out.println("dddd");
				System.out.println(start);
				System.out.println(end);
				Timestamp appointtime = new Timestamp(System.currentTimeMillis());
				System.out.println(appointtime);
				String starttime = start+" "+"00:00:00";
				String endtime = end+" "+"23:59:59";
				Timestamp mstarttimes = Timestamp.valueOf(starttime);
				Timestamp mendtimes = Timestamp.valueOf(endtime);
				System.out.println(mstarttimes.toString());
				System.out.println(mendtimes.toString());
				meetlist = meetService.getRealTimeLimit(mstarttimes,mendtimes);
			}
			else if((!appointstart.isEmpty())&&(!appointend.isEmpty())){
				System.out.println("dddd");
				System.out.println(appointstart);
				System.out.println(appointend);
				String appstart = appointstart+" "+"00:00:00";
				String append = appointend+" "+"23:59:59";
				Timestamp appointstarts = Timestamp.valueOf(appstart);
				Timestamp appointends = Timestamp.valueOf(append);
				System.out.println(appointstarts.toString());
				System.out.println(appointends.toString());
				meetlist = meetService.getAppointTimeLimit(appointstarts,appointends);
			}
		}
		return "show";
	}

	@Action(value = "NextMeetAction", results = { @Result(name = "showNext", location = "/SearchMeet", type = "redirect") })
	public String Next() {

		if (next.equals("下页") && m != (page - 1) * 10) {
			m = m + 10;
		} else if (next.equals("上页") && m != 0) {
			System.out.println("okay");
			m = m - 10;
		} else if (next.equals("首页")) {
			m = 0;
		} else if (next.equals("跳转")) {
			m = (pagetemp - 1) * 10;
		} else if (next.equals("末页")) {
			m = (page - 1) * 10;
		}
		return "showNext";
	}

}
