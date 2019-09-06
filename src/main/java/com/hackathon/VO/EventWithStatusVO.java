package com.hackathon.VO;

public class EventWithStatusVO extends EventVO{
    private Boolean isJoint = false;
    private Boolean isFavorate = false;
    private Boolean isCreated = false;

    public Boolean getIsJoint() {
        return isJoint;
    }

    public void setIsJoint(Boolean isJoint) {
        this.isJoint = isJoint;
    }

    public Boolean getIsFavorate() {
        return isFavorate;
    }

    public void setIsFavorate(Boolean isFavorate) {
        this.isFavorate = isFavorate;
    }

    public Boolean getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(Boolean isCreated) {
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
