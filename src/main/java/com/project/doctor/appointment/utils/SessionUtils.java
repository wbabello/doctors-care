package com.project.doctor.appointment.utils;

import javax.servlet.http.HttpServletRequest;

import static com.project.doctor.appointment.utils.AppConstant.USER_ID;
import static com.project.doctor.appointment.utils.AppConstant.USER_TYPE;

public class SessionUtils {

    public static void clearSession(HttpServletRequest request) {
        request.getSession().invalidate();
    }

    public static void setSession(HttpServletRequest request, Integer userId, String type) {
        request.getSession().setAttribute(USER_ID, userId);
        request.getSession().setAttribute(USER_TYPE, type);
    }

    public static Integer getCurrentUserId(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(USER_ID);
    }

    public static String getCurrentUserType(HttpServletRequest request) {
        return (String) request.getSession().getAttribute(USER_TYPE);
    }
}
