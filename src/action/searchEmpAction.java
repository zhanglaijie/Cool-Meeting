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
 * @author 郑凯宏
 * @version1.0
 *
 */
@Controller
public class searchEmpAction extends ActionSupport {

	@Autowired
	private EmpService empService;
	@Autowired
	private DeptService deptService;
	
	private int eid;
	private String did;
	private static String names;
	private static String ename;
	private String epasswd;
	private String ispasswd;
	private String ephone;
	private String email;
	private static int s_privilege;
	private String dname;
	private String dept;
    private static String prove;
	private List<Emp> list;
	private int total;
	private static int page;
	private int current;
	private String next;
	private int pagetemp;
	private static int m = 0;
	private String first ="";
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public int getPagetemp() {
		return pagetemp;
	}

	public void setPagetemp(int pagetemp) {
		this.pagetemp = pagetemp;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}
	//private Dept dept = new Dept();
	
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

	public String getDid() {
		return did;
	}

	public String getProve() {
		return prove;
	}

	public void setProve(String prove) {
		this.prove = prove;
	}

	public void setDid(String did) {
		this.did = did;
	}
	
	public List<Emp> getList() {
		return list;
	}

	public void setList(List<Emp> list) {
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
	
	@Action(value = "searchEmpAction", results = { @Result(name = "showby", location = "/searchemployees.jsp") })
	public String search() {
		
		if(prove.equals("show")){
			int temp =  empService.getAll().size();
			total  = temp;
			page = temp/10 +1;
			current = m/10 +1;
			list = empService.getByLimit(m, 10);
		}else if(prove.equals("search")){
			if(first.equals("查询")){
				m = 0;
			}
			if(!names.isEmpty())
			{
				int temp =  empService.getByName(names).size();
				total  = temp;
				page = temp/10 +1;
				current = m/10 +1;
				list = empService.getByNameLimit(names, m);
			}else if(!ename.isEmpty()){
				int temp =  empService.getByEname(ename).size();
				total  = temp;
				page = temp/10 +1;
				current = m/10 +1;
				list = empService.getByENameLimit(ename, m);
			}else{
				int temp = empService.getBys(s_privilege).size();
				total  = temp;
				page = temp/10 +1;
				current = m/10 +1;
				list = empService.getBySLimit(s_privilege, m);
			}
		}
		return "showby";
	}
	
	
	@Action(value = "NextEmpAction", results = { @Result(name = "showNext", location = "/searchEmpAction", type = "redirect") })
	public String Next(){
		//System.out.println("  ���� ");
		if(next.equals("下页") && m != (page-1)*10)
		{
		    m = m + 10;
		}else if (next.equals("上页") && m != 0){
			System.out.println("okay");
			m = m - 10;
		}else if(next.equals("首页"))
		{
			m = 0;
		}else if(next.equals("跳转")){
			if(pagetemp > page || pagetemp <= 0)
			{
				m=0;
			}else{
				m = (pagetemp-1)*10;
			}
		}else if(next.equals("末页")){
			m = (page-1)*10;
		}
		return "showNext";
		
	}
	
	
	@Action(value = "CloseEmpAction", results = { @Result(name = "close", location = "/searchEmpAction", type = "redirect") })
	public String close(){
		Emp updateEmp = new Emp();
		updateEmp = empService.getById(eid);
		updateEmp.setS_privilege(-1);
		empService.updateEmp(updateEmp);
		return "close";
		
	}
	
	
}
