package com.southwind.repository;

import com.southwind.entity.Admin;

public interface AdminRepository {
    /**
     * 功能：接收登录界面传来的读者信息，若读者数据库中有该信息，则返回该读者对象
     * @param username          // 管理员名
     * @param password          // 管理员密码
     * @return
     */
    public Admin login(String username, String password);
}
