package com.southwind.repository;

import com.southwind.entity.Reader;

public interface ReaderRepository {
    /**
     * 功能：接收登录界面传来的读者信息，若读者数据库中有该信息，则返回该读者对象
     * @param username          // 用户名
     * @param passowrd          // 用户密码
     * @return
     */
    public Reader login(String username, String passowrd);
}
