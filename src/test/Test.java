package test;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.Dept;
import service.DeptService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = (ApplicationContext) new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		DeptService service = (DeptService) ac.getBean("deptService");
		Dept dept = new Dept(3, "销售");
		service.addDept(dept);
		System.out.println("添加成功");
		List<Dept> list = service.getAll();
		for(Dept ls:list)
		{
			System.out.println(ls.getDname());
		}
		System.out.println("id查询"+service.getById(1).getDname());
		System.out.println("name查询"+service.getByName("销售").getDname());
		System.out.println("查询成功");
		service.deleteDept(dept);
		System.out.println("删除成功");
	}

}
