package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import po.Dept;
import po.Emp;
import po.Room;
import service.MeetServiceInter;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 
 * @author zhanglaijie
 *
 */
@Controller
public class GoBookMeetingAction extends ActionSupport{
	@Autowired
	private MeetServiceInter meetService;
	
	private List<Room> roomlist;
	
	private List<Emp>[] empls;
	
	public List<Emp>[] getEmpls() {
		return empls;
	}

	public void setEmpls(List<Emp>[] empls) {
		this.empls = empls;
	}

	public List<Room> getRoomlist() {
		return roomlist;
	}

	public void setRoomlist(List<Room> roomlist) {
		this.roomlist = roomlist;
	}

	public List<Emp> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<Emp> emplist) {
		this.emplist = emplist;
	}

	public List<Dept> getDeptlist() {
		return deptlist;
	}

	public void setDeptlist(List<Dept> deptlist) {
		this.deptlist = deptlist;
	}

	private List<Emp> emplist;
	
	private List<Dept> deptlist;

	@Action(value="/GoBookMeet",results={@Result(name="book",location="/bookmeeting.jsp")})
	public String add(){
		
		System.out.println("go here");
		roomlist = meetService.getAllRoom();
		emplist = meetService.getAllEmp();
		
		deptlist = meetService.getAllDept();
		empls = new List[deptlist.size()];
		
		System.out.println("deptlistSize"+deptlist.size()); //3
		int i =0;
			for(Dept dept:deptlist){
				empls[i] =meetService.getEmpbyDept(dept);	
				i++;
			}
		
			
		for(i=0;i<deptlist.size();i++)
		{
		for(Emp emp:empls[i])
			System.out.println(i+""+emp.getEid());
		}
		return "book";
	}
	
}
