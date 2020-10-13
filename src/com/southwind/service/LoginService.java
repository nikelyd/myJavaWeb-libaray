package com.southwind.service;

import com.southwind.entity.Reader;

public interface LoginService {
    public Object login(String username, String password, String type);
}
