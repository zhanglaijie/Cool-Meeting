package service;

import java.util.List;

import po.Room;


public interface RoomServiceInter {
	public void addRoom(Room room);
	public void updateRoom(Room room);
	public List<Room> getAllRoom();
	public Room getByIdRoom(String rid);
	public List<Room> getByRname(String rname);
}
