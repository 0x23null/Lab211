package main.j1.s.p107_rv2;

import java.time.LocalDateTime;

public class FlightInformation {
    private String flightNumber;
    private String seatNumber;
    private LocalDateTime timePickUp;

    public FlightInformation() {
        this.flightNumber = "";
        this.seatNumber = "";
        this.timePickUp = LocalDateTime.now();
    }

    public FlightInformation(String flightNumber, String seatNumber, LocalDateTime timePickUp) {
        this.flightNumber = flightNumber == null ? "" : flightNumber.trim();
        this.seatNumber = seatNumber == null ? "" : seatNumber.trim();
        this.timePickUp = timePickUp == null ? LocalDateTime.now() : timePickUp;
    }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber == null ? "" : flightNumber.trim(); }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber == null ? "" : seatNumber.trim(); }

    public LocalDateTime getTimePickUp() { return timePickUp; }
    public void setTimePickUp(LocalDateTime timePickUp) { this.timePickUp = timePickUp; }
}
