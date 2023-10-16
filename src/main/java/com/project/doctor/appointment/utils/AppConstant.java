package com.project.doctor.appointment.utils;

public class AppConstant {

    public static class JSPFile {
        public static final String HOME_PAGE = "index";
        public static final String DOCTOR_DASHBOARD = "doctor-dashboard";
        public static final String DOCTOR_ADD_AVAILABILITY = "doctor-add-availability";
        public static final String DOCTOR_EDIT_AVAILABILITY = "doctor-edit-availability";
        public static final String PATIENT_DASHBOARD = "patient-dashboard";
        public static final String PATIENT_BOOK_APPOINTMENT = "patient-book-appointment";
    }

    public static class LoginError {
        public static final String INVALID_LOGIN = "Invalid Login";

        public static final String USERNAME_ERROR = "Error: Username - letter only, 3 characters, not blank";

        public static final String INVALID_EMAIL = "Error: Invalid Email format";

        public  static final String EMAIL_EXIST = "Error: Email already exist";

        public static final String PASSWORD_ERROR = "Error: Password - at least 8 characters, not blank";

        public static final String PASSWORD_MISS_MATCH = "Error: Password mismatch";

        public static final String INVALID_TYPE = "Error: Type should be [Doctor, Patient]";
    }

    public static final String REGISTER_USER = "registerUser";

    public static final String LOGIN_USER = "loginUser";

    public static final String REGISTER_ERROR = "registerError";

    public static final String DOCTOR = "Doctor";

    public static final String DOCTOR_OBJ = "doctor";

    public static final String PATIENT_OBJ = "patient";

    public static final String APPOINTMENT = "appointment";

    public static final String ADD_AVAILABILITIES_LIST = "addAvailabilitiesList";

    public static final String DOCTOR_LIST = "doctorList";

    public static final String CURRENT_DATE = "currentDate";

    public static final String PATIENT = "Patient";

    public static final String USER_ID = "USER_ID";

    public static final String USER_TYPE = "type";

    public static final String REDIRECT_DOCTOR = "redirect:/doctor/availability";

    public static final String REDIRECT_PATIENT = "redirect:/patient/view";

    public static final String REDIRECT_HOME_PAGE = "redirect:/";

    public static final String USER_LOGIN_ERROR = "loginError";

    public static final String ADD_AVAILABILITY = "addAvailability";

    public static final String MORNING_AVAILABILITY = "morningAvailability";

    public static final String AFTERNOON_AVAILABILITY = "afternoonAvailability";

    public static final String EVENING_AVAILABILITY = "eveningAvailability";

    public static final String APPOINTMENT_LIST = "appointmentList";
}
