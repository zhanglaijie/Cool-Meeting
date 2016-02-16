package service;

import java.sql.Timestamp;
import java.util.List;

import po.Dept;
import po.Emp;
import po.Meet;
import po.Room;



public interface MeetServiceInter {
	public void addMeet(Meet meet);
	public void updateMeet(Meet meet);
	public void deleteMeet(Meet meet);
	public Meet getByNameMeet(String mname);
	public List<Meet> getByEmp(Emp emp);
	public List<Meet> getAllMeet();
	public List<Room> getAllRoom();
	public List<Emp> getAllEmp();
	public List<Dept> getAllDept();
	public List<Emp> getEmpbyDept(Dept dept);
	public List<Meet> getMeetLimit(int n,int m);
	public List<Meet> getByRoom(Room room);
	public List<Meet> getByTime();
	public List<Meet> getByState();
	public List<Meet> getByeid(int eid);
	public List<Meet> getRealTimeLimit(Timestamp mstarttimes,Timestamp mendtimes);
	public List<Meet> getAppointTimeLimit(Timestamp appointstart,
			Timestamp appointends);
}
