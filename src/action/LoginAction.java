package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import po.Emp;
import service.EmpService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author laijie
 *
 */
@Controller
public class LoginAction extends ActionSupport{
	@Autowired
	private EmpService empService;
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}


	private String ename;
	private String epasswd;
	public String getEpasswd() {
		return epasswd;
	}
	public void setEpasswd(String epasswd) {
		this.epasswd = epasswd;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}

	
	@Action(value="/Login",results={@Result(name="login",location="/notifyAction", type = "redirect"),@Result(name="nofind",location="/login.jsp")})
	public String add(){
		//System.out.println(ename);
		System.out.println(epasswd);
		List<Emp> emplist =empService.getByEname(ename);
		
		if(emplist.size()==0)
		{
			result="用户名不存在";
			return "nofind";
		}
		else if(!emplist.get(0).getEpasswd().equals(epasswd)){
			result="密码错误";
			return "nofind";
		}
		for(Emp emp2:emplist)
		{
			System.out.println(emp2.getEname());
			if(emp2.getEpasswd().equals(epasswd)){
				
				ActionContext.getContext().getSession().put("ename",ename);
				return "login";
			}
		}
		return "nofind";
	}
	@Action(value="/Logout",results={@Result(name="logout",location="/login.jsp")})
	public String logout(){
		ActionContext.getContext().getSession().put("ename", "");
		return "logout";
	}
	
}
