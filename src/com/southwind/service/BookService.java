package com.southwind.service;

import com.southwind.entity.Book;
import com.southwind.entity.Borrow;

import java.util.List;

public interface BookService {
    /**
     * @param page
     * @return
     */
    public List<Book> findAll(int page);
    public Integer getPages();
    public Integer getBorrowPages(Integer id);
    public void addBorrow(Integer bookid, Integer readerid);
    public List<Borrow> findAllBorrowByReaderId(Integer id,Integer page);
    public List<Borrow> findAllBorrowByState(Integer state,Integer page);
    public Integer getBorrowPagesByState(Integer state);
    public void handleBorrow(Integer borrowId, Integer state, Integer adminId);
}
