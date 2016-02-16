package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import po.Dept;
import service.DeptService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author zhangze
 *
 */
@Controller
public class departAction extends ActionSupport{
	
	@Autowired
	private DeptService deptService;
	private int did;
	private String dname;
	private List<Dept> list;
	private Dept dept ;
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
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
	public List<Dept> getList() {
		return list;
	}
	public void setList(List<Dept> list) {
		this.list = list;
	}
	
	@Action(value="departAction",results={@Result(name="ok",location="/departments.jsp")})
	public String getAll(){
		list =deptService.getAll(); 
		return "ok";
	}
}
