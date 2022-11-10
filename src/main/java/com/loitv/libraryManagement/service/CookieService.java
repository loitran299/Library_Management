package com.loitv.libraryManagement.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CookieService {
    Object getByKey(String key, HttpServletRequest request);
    void setCookie(String key, String value, HttpServletResponse response);
}
