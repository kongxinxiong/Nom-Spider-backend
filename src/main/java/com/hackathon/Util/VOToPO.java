package com.hackathon.Util;

import com.hackathon.PO.Preference;
import com.hackathon.PO.User;
import com.hackathon.Service.EventService;
import com.hackathon.Service.PreferenceService;
import com.hackathon.Service.UserService;
import com.hackathon.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;

public class VOToPO {

    private static String strDateFormat = "yyyy-MM-dd";
    private static SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
    public static User UserVOToPO(UserVO userVO, User user, PreferenceService preferenceService) {
        try {
            user.setUsername(userVO.getUsername());
            user.setName(userVO.getName());
            user.setPhotoURL(userVO.getPhotoURL());
            user.setLocation(userVO.getLocation());
            user.setEmail(userVO.getEmail());
            user.setBirthday(sdf.parse(userVO.getBirthday()));
            user.setId(userVO.getId());
            user.setPassword(userVO.getPassword());
            for (String id:userVO.getPreferences()) {
                user.getPreferences().add(preferenceService.findById(Integer.valueOf(id)).get());
            }
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
