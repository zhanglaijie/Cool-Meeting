package test;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Dept;
import po.Emp;
import po.Meet;
import po.Room;
import service.MeetServiceInter;
import service.RoomServiceInter;



public class testMeet {
		

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*
		RoomServiceInter se =(RoomServiceInter)ac.getBean("roomService");
		
		Room room = new Room("15", "第五会议室", 70, -1, "leeee", null);
		
		se.addRoom(room);*/
		
		MeetServiceInter service  = (MeetServiceInter)ac.getBean("meetService");
		//Meet meet = new Meet("zongoe", new Date(2011, 06, 12), new Date(2012, 05, 26), new Date(2014, 05, 06));
		Meet meet = new Meet("毕业会议", null, null,50,null , null, null, "开会", "1,4", null);
		
	//	service.addMeet(meet);
		//service.addStudent(stu);
		//service.updateStudent(stu);
		//stu = service.getStudent(2);
		//System.out.println(stu.getStuname()+","+stu.getStuaddress());
		//List<Student> list = service.getAllStudent();
		//for(Student stu1:list){
		//	System.out.println(stu1.getStuid()+","+stu1.getStuname()+","+stu1.getStuaddress());
		//}
		//service.deleteStudent(stu);
		
		List<Room> roomlist = service.getAllRoom();
		
		for(Room room:roomlist){
			System.out.println(room.getRid());
		}
		
		List<Emp> emplist = service.getAllEmp();
		for(Emp emp:emplist){
			System.out.println(emp.getEid());
		}
		List<Dept> deptlist = service.getAllDept();
		
		
		for(Dept dept:deptlist){
			List<Emp> empls =service.getEmpbyDept(dept);
			for(Emp emp:empls){
				System.out.println(emp.getEid());
			}
		}
		
		
		
	}
}
