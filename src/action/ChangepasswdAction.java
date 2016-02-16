package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import po.Dept;
import po.Emp;
import service.DeptService;
import service.EmpService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author chengguohui
 *
 */
@Controller
public class ChangepasswdAction  extends ActionSupport{
	
	@Autowired
	private EmpService empService;
	private int eid;
	
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public EmpService getEmpService() {
		return empService;
	}
	
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}

	public String getNewwd() {
		return newwd;
	}

	public void setNewwd(String newwd) {
		this.newwd = newwd;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	private String names;
	private String ename;
	private String old;
	private String newwd;
	private String confirm;

	@Action(value="/changepasswd",results={@Result(name="change",location="/login.jsp", type = "redirect"),@Result(name="wrong",location="/changepassword.jsp")})
	public String changepasswd(){
		String ename = (String) ActionContext.getContext().getSession().get("ename");
		List<Emp> emps = empService.getByEname(ename);
		Emp emp = emps.get(0);
		String passwd =emp.getEpasswd();
		if(!passwd.equals(old))
		{
			result="原密码错误";
			return "wrong";
		}
		emp.setEpasswd(newwd);
		empService.updateEmp(emp);
		
		return "change";

	}
	
}
