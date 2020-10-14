package com.southwind.service;

import com.southwind.entity.Reader;

public interface LoginService {
    /**
     * 功能：登录操作，type为reader则返回reader对象，type为admin则返回admin对象。（处理返回值时，向下转型即可）
     * @param username
     * @param password
     * @param type
     * @return
     */
    public Object login(String username, String password, String type);
}
