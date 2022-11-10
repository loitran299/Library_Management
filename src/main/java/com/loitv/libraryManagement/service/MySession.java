package com.loitv.libraryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class MySession {
    private static Long userID;

    public static Long getUserID() {
        return userID;
    }
    public static void setUserID(Long id) {
        userID = id;
    }
}
