package com.southwind.repository;

import com.southwind.entity.Book;

import java.util.List;

public interface BookRepository {
    /**
     * 功能：返回第page页的图书对象
     * @param index         // page - 1
     * @param limit         // 每页显示图书数量
     * @return
     */
    public List<Book> findAll(int index, int limit);

    /**
     *功能：返回总的图书数量
     * @return
     */
    public int count();
}
