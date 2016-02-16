package dao;

import java.util.List;

import po.Room;

public interface RoomDaoInter {
	public void add(Room room);
	public void update(Room room);
	public List<Room> getAll();
	public Room getById(String rid);
	public List<Room> getByRname(String rname);
}
