package dao;

import java.sql.Timestamp;
import java.util.List;

import po.Dept;
import po.Emp;
import po.Meet;
import po.Room;

public interface MeetDaoInter {
	public void add(Meet meet);
	public void update(Meet meet);
	public void delete(Meet meet);
	public Meet getByName(String mname);
	public List<Meet> getAll();
	public List<Room> getAllRoom();
	public List<Emp> getAllEmp();
	public List<Dept> getAllDept();
	public List<Emp> getEmpbyDept(Dept dept);
	public List<Meet> getMeetLimit(int n, int m);
	public List<Meet> getByEmp(Emp emp);
	public List<Meet> getbyRoom(Room room);
	//zkh
	public List<Meet> getByTime();
	public List<Meet> getByState();
	public List<Meet> getByEid(int eid);
	public List<Meet> getRealTimeLimit(Timestamp mstarttimes,
			Timestamp mendtimes);
	public List<Meet> getAppointTimeLimit(Timestamp appointstarts,
			Timestamp appointends);
}
