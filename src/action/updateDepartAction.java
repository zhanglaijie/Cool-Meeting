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

import com.opensymphony.xwork2.ActionSupport;


/**
 * 
 * @author shaohuan
 *
 */
@Controller
public class updateDepartAction extends ActionSupport{
	
	@Autowired
	private DeptService deptService;
	@Autowired
	private EmpService empService;
	
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
	
	@Action(value="deleteDepartAction",results={@Result(name="ok",location="/departAction" , type = "redirect")})
	public String delete(){
		List<Emp> list = empService.getByDid(did);
		for(Emp Er : list){
			System.out.println("kk" + Er.getEname());
			empService.deleteEmp(Er);
		}
		Dept tempdept = new Dept();
		tempdept = deptService.getById(did);
		deptService.deleteDept(tempdept);
		return "ok";
	}
	
	@Action(value="updateDepartAction",results={@Result(name="ok",location="/departAction" , type = "redirect")})
	public String update(){
		System.out.println("kkk");
		Dept tempdept = new Dept();
		tempdept.setDid(did);
		tempdept.setDname(dname);
		deptService.updateDept(tempdept);
		return "ok";
	}
}
