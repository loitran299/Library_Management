package com.loitv.libraryManagement.service.impl;

import com.loitv.libraryManagement.service.CookieService;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Service
public class CookieServiceImpl implements CookieService {

    @Override
    public Object getByKey(String key, HttpServletRequest request) {
        return Arrays.stream(request.getCookies())
                .filter(cookie -> key.equals(cookie.getName()))
                .map(Cookie::getValue)
                .findAny();
    }

    @Override
    public void setCookie(String key, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(key, value);
        response.addCookie(cookie);
    }
}
