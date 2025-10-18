package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkOut;
	private Date checkIn;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkOut, Date checkIn) {
		
		this.roomNumber = roomNumber;
		this.checkOut = checkOut;
		this.checkIn = checkIn;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte milesegundo em dias
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room= " 
				+ roomNumber 
				+ ", checkIn: " 
				+ sdf.format(checkIn) 
				+ ", checkOut: " 
				+ sdf.format(checkOut) 
				+ ","
				+ duration()
				+ " nigths";
	}
	
	
	
}
