package com.hackathon.VO;

public class UserEventVO {
    private String userID;
    private String eventID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    @Override
    public String toString() {
        return "UserEventVO{" +
                "userID='" + userID + '\'' +
                ", eventID='" + eventID + '\'' +
                '}';
    }
}
