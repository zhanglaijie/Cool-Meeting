package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author 张泽
 * @version1.0
 *
 */
@Controller
public class AddEmpAction extends ActionSupport {

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
	private List list;
	//private Dept dept = new Dept();
	
	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}
	
	public List getList() {
		list.add(deptService.getAll().get(0).getDname());
		//System.out.println("jd");
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
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

	public String getEpasswd() {
		return epasswd;
	}

	public void setEpasswd(String epasswd) {
		this.epasswd = epasswd;
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

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public String getIspasswd() {
		return ispasswd;
	}

	public void setIspasswd(String ispasswd) {
		this.ispasswd = ispasswd;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	/**
	 * ����Ĵ����ǣ�
	 * dname�õ�����id
	 * 
	 * @return
	 */
	
	@Action(value = "addEmpAction", results = { @Result(name = "ok", location = "/RegisterAction", type = "redirect") })
	public String add() {
		if (epasswd.equals(ispasswd)) {
		    // System.out.println(names + ename + epasswd + ephone + email + ispasswd +dname +dept+ did+"::::");
			Emp emp = new Emp(names, ename, epasswd, ephone, email);
			Dept dept = new Dept();
		    dept.setDid(Integer.parseInt(did));
			emp.setDept(dept);
			empService.addEmp(emp);
			return "ok";
		} else {
			return "end";
		}
	}
	
}
