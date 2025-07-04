package model;

public class Flight {
    public int id;
    public String flight_no;
    public String date;
    public int seats;

    public Flight(int id, String flight_no, String date, int seats) {
        this.id = id;
        this.flight_no = flight_no;
        this.date = date;
        this.seats = seats;
    }
}
