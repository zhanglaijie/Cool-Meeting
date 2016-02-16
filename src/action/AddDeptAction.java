package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import po.Dept;
import service.DeptService;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 
 * @author 王艺龙
 * @version 1.0
 *
 */
@Controller
public class AddDeptAction extends ActionSupport{

	@Autowired
	private DeptService deptService;
	private int did;
	private String dname;
	
	public DeptService getDeptService() {
		return deptService;
	}
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	@Action(value="addDeptAction",results={@Result(name="showAll",location="/showDepAll",type="redirect")})
	public String add(){
		//System.out.println("hehe@+addwall");
		Dept dept = new Dept(dname);
		deptService.addDept(dept);
		return "showAll";
	}
}
