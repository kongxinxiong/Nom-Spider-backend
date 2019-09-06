package com.hackathon.Util;

import com.hackathon.PO.Event;
import com.hackathon.PO.Preference;
import com.hackathon.PO.User;
import com.hackathon.VO.EventVO;
import com.hackathon.VO.EventWithStatusVO;
import com.hackathon.VO.UserVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class POToVO {
    private static String strDateFormat = "yyyy-MM-dd";
    private static SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
    public static UserVO userPOToVO(User userPO){
        UserVO userVO = new UserVO();
        userVO.setId(userPO.getId());
        userVO.setName(userPO.getName());


        userVO.setBirthday(sdf.format(userPO.getBirthday()));
        userVO.setEmail(userPO.getEmail());
        userVO.setLocation(userPO.getLocation());
        userVO.setPassword(userPO.getPassword());
        userVO.setPhotoURL(userPO.getPhotoURL());
        userVO.setUsername(userPO.getUsername());
        for (Preference preference:userPO.getPreferences()) {
            userVO.getPreferences().add(preference.getId().toString());
        }
        return userVO;
    }
    public static EventVO eventPOToVO(Event eventPO) {
        EventVO eventVO = new EventVO();
        eventVO.setId(eventPO.getId());
        eventVO.setTitle(eventPO.getTitle());
        eventVO.setDescription(eventPO.getDescription());
        eventVO.setLocation(eventPO.getLocation());
        eventVO.setPhotoURL(eventPO.getPhotoURL());
        eventVO.setMaxNumber(eventPO.getMaxNumber());
        eventVO.setStartDate(sdf.format(eventPO.getStartDate()));
        for (Preference preference:eventPO.getPreferences()) {
            eventVO.getPreferences().add(preference.getId().toString());
        }
        return eventVO;
    }
    public static ArrayList<EventWithStatusVO> eventWithStatusVOSet (ArrayList<Event> eventSet, Set<Event> interestEvents, Set<Event> jointEvents, Set<Event> createdEvents) {
        ArrayList<EventWithStatusVO> eventWithStatusVOS = new ArrayList<>();
        for (Event event : eventSet) {
            EventWithStatusVO eventWithStatusVO = new EventWithStatusVO();
//            eventWithStatusVO = eventPOToVO(event);
            eventWithStatusVO.setId(event.getId());
            eventWithStatusVO.setTitle(event.getTitle());
            eventWithStatusVO.setDescription(event.getDescription());
            eventWithStatusVO.setLocation(event.getLocation());
            eventWithStatusVO.setPhotoURL(event.getPhotoURL());
            eventWithStatusVO.setMaxNumber(event.getMaxNumber());
            eventWithStatusVO.setStartDate(sdf.format(event.getStartDate()));
            for (Preference preference:event.getPreferences()) {
                eventWithStatusVO.getPreferences().add(preference.getId().toString());
            }
            if (interestEvents.contains(event)) {
                eventWithStatusVO.setIsFavorate(true);
            }
            if (jointEvents.contains(event)) {
                eventWithStatusVO.setIsJoint(true);
            }
            if (createdEvents.contains(event)) {
                eventWithStatusVO.setIsCreated(true);
            }
            eventWithStatusVOS.add(((EventWithStatusVO)eventWithStatusVO));
        }
        return eventWithStatusVOS;
    }
}
