package com.hackathon.VO;

public class EventWithStatusVO extends EventVO{
    private String isJoint = "false";
    private String isFavorate = "false";
    private String isCreated = "false";

    public String getIsJoint() {
        return isJoint;
    }

    public void setIsJoint(String isJoint) {
        this.isJoint = isJoint;
    }

    public String getIsFavorate() {
        return isFavorate;
    }

    public void setIsFavorate(String isFavorate) {
        this.isFavorate = isFavorate;
    }

    public String getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(String isCreated) {
        this.isCreated = isCreated;
    }

    @Override
    public String toString() {
        return "EventWithStatusVO{" +
                "isJoint='" + isJoint + '\'' +
                ", isFavorate='" + isFavorate + '\'' +
                ", isCreated='" + isCreated + '\'' +
                '}';
    }
}
