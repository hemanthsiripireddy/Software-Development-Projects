package org.example.models;

public class Seat {

    private int id;
    private User user;
    private ClassType classType;
    private SeatPosition seatPosition;
    private Train train;

    public SeatPosition getSeatPosition() {
        return seatPosition;
    }

    public ClassType getClassType() {
        return classType;
    }

    public Train getTrain() {
        return train;
    }

    public int getId() {
        return id;
    }

    public Seat(int id, ClassType classType, SeatPosition seatPosition, Train train) {
        this.id = id;
        this.classType = classType;
        this.seatPosition = seatPosition;
        this.train = train;
    }

    public Seat(ClassType classType, SeatPosition seatPosition) {
        this.classType = classType;
        this.seatPosition = seatPosition;
    }
}
