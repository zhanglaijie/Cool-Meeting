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
 * @author zhangze
 *
 */
@Controller
public class updateEmpAction  extends ActionSupport{
	
	@Autowired
	private EmpService empService;
	@Autowired
	private DeptService deptService;
	private int eid;
	private String did;
	private String names;
	private String ename;
	private String epasswd;
	private String ispasswd;
	private String ephone;
	private String email;
	private int s_privilege;
	private String dname;
	private String dept;
	private String prove;
	private List<Emp> list;
	public String getProve() {
		return prove;
	}
	public void setProve(String prove) {
		this.prove = prove;
	}
	public EmpService getEmpService() {
		return empService;
	}
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	public DeptService getDeptService() {
		return deptService;
	}
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
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
	public String getEpasswd() {
		return epasswd;
	}
	public void setEpasswd(String epasswd) {
		this.epasswd = epasswd;
	}
	public String getIspasswd() {
		return ispasswd;
	}
	public void setIspasswd(String ispasswd) {
		this.ispasswd = ispasswd;
	}
	public String getEphone() {
		return ephone;
	}
	public void setEphone(String ephone) {
		this.ephone = ephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getS_privilege() {
		return s_privilege;
	}
	public void setS_privilege(int s_privilege) {
		this.s_privilege = s_privilege;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public List<Emp> getList() {
		return list;
	}
	public void setList(List<Emp> list) {
		this.list = list;
	}
	
	@Action(value="updateEmpAction",results={@Result(name="ok",location="/approveAction", type = "redirect")})
	public String update(){
		Emp emptemp = new Emp();
		emptemp = empService.getById(eid);
		if(prove.equals("通过"))
		{
			emptemp.setS_privilege(1);
			empService.updateEmp(emptemp);
		}else
		{
			empService.deleteEmp(emptemp);
		}
		
		return "ok";
	}

}
