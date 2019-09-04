package com.hackathon.Util;

import com.hackathon.PO.Event;
import com.hackathon.PO.Preference;
import com.hackathon.PO.User;
import com.hackathon.VO.EventVO;
import com.hackathon.VO.UserVO;

import java.text.SimpleDateFormat;

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
}
