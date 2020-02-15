package it.unisalento.myairbnb.dto;

import java.util.Date;

public class BookingDTO {

	int id;
	double price;
	Date bookingDate;
	Date checkin;
	int daynumber;
	UserDTO user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public int getDaynumber() {
		return daynumber;
	}
	public void setDaynumber(int daynumber) {
		this.daynumber = daynumber;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	
}
