package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int availableFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;
    private int availableCoachSeats;

    public String getPlaneNumber() {
        return this.planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return this.totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return this.bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
        return this.totalFirstClassSeats - this.bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return this.totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return this.bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        return this.totalCoachSeats - this.bookedCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass) {
            if (this.getAvailableFirstClassSeats() >= totalNumberOfSeats) {
                this.bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            } else return false;
        } else {
            if (this.getAvailableCoachSeats() >= totalNumberOfSeats) {
                bookedCoachSeats += totalNumberOfSeats;
                return true;
            } else return false;
        }
    }


    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }
}
