package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Dept;
import po.Emp;
import service.DeptService;
import service.EmpService;

public class TestEmp {
	public static void main(String[] args) {
		ApplicationContext ac = (ApplicationContext) new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		EmpService empservice = (EmpService) ac.getBean("empService");
		DeptService deptservice = (DeptService) ac.getBean("deptService");
		/**Emp emp = new Emp("1", "12", "123", "1234",
				"12345");
		Dept dept = new Dept(1);
		emp.setDept(dept);
		empservice.addEmp(emp);
		System.out.println("��ӳɹ�");
		List<Emp> list = empservice.getAll();
		for(Emp t : list){
			System.out.println(t.getEname());
		}
		System.out.println("��ѯBYid" + empservice.getById(8).getEname());
		System.out.println(empservice.getByName(emp.getEname()).getEid()+"hedhwr");
		emp.setEid(empservice.getByName(emp.getEname()).getEid());
		empservice.deleteEmp(emp);
		System.out.println("test success");**/
		System.out.println(empservice.getByLimit(0, 10).get(0).getEmail());
	}

}
