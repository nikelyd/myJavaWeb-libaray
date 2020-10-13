package com.southwind.repository;

import com.southwind.entity.Book;

import java.util.List;

public interface BookRepository {
    /**
     * 查找所有图书
     * @return
     */
    public List<Book> findAll(int index, int limit);
    public int count();
}
