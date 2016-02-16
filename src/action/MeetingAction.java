package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import po.Dept;
import po.Meet;
import po.Room;
import po.Emp;
import service.EmpService;
import service.MeetServiceInter;
import service.RoomServiceInter;

import com.opensymphony.xwork2.ActionSupport;


/**
 * @author laijie
 */
@Controller
public class MeetingAction extends ActionSupport{
	@Autowired
	private MeetServiceInter meetService;
	
	@Autowired
	private EmpService empService;
	
	private Meet list;
	private String mname;
	private List<Emp> emplist;
	
	public List<Emp> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<Emp> emplist) {
		this.emplist = emplist;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	

	public Meet getList() {
		return list;
	}

	public void setList(Meet list) {
		this.list = list;
	}

	@Action(value="/meetingdetails",results={@Result(name="update",location="/meetingdetails.jsp")})
	public String add() throws Exception{
		System.out.println(mname);
		String mmname= new String();  
		list = meetService.getByNameMeet(mname);
		String emps =list.getMemps();
		System.out.println(emps);
		String []emp = emps.split("#");
		emplist=new ArrayList<>();
		for(int i =0;i<emp.length;i++){
			System.out.println(emp[i]);
			Emp e=empService.getById(Integer.parseInt(emp[i]));
			e.getEid();
			emplist.add(e);
		}		
		
		for(Emp emp2:emplist){
			System.out.println(emp2.getNames());;
		}
		
		return "update";
	}
	
}
