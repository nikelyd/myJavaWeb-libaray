package com.southwind.service.impl;

import com.southwind.entity.Book;
import com.southwind.entity.Borrow;
import com.southwind.repository.BookRepository;
import com.southwind.repository.BorrowRepository;
import com.southwind.repository.impl.BookRepositoryImpl;
import com.southwind.repository.impl.BorrowRepositoryImpl;
import com.southwind.service.BookService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 每页展示6条数据
 * @author lyd
 */
public class BookServiceImpl implements BookService {
    private BookRepository  bookRepository = new BookRepositoryImpl();
    private BorrowRepository borrowRepository = new BorrowRepositoryImpl();
    private final int LIMIT = 6;
    @Override
    public List<Book> findAll(int page) {
        int index = (page-1)*LIMIT;
        return bookRepository.findAll(index, LIMIT);
    }

    @Override
    public Integer getPages() {
        int count = bookRepository.count();
        int page = 0;
        if(count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT + 1;
        }
        return page;
    }

    @Override
    public Integer getBorrowPages(Integer id) {
        int count = borrowRepository.count(id);
        int page = 0;
        if(count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT + 1;
        }
        return page;
    }

    @Override
    public void addBorrow(Integer bookid, Integer readerid) {
        // 借书时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String borrowTime = simpleDateFormat.format(date);
        // 还书时间（借书时间+14天）
        Calendar calendar = Calendar.getInstance();
        int dates = calendar.get((Calendar.DAY_OF_YEAR)) + 14;
        calendar.set(Calendar.DAY_OF_YEAR,dates);
        Date date2 = calendar.getTime();
        String returnTime = simpleDateFormat.format(date2);
        borrowRepository.insert(bookid,readerid,borrowTime,returnTime,null,0);
    }

    @Override
    public List<Borrow> findAllBorrowByReaderId(Integer id,Integer page) {
        // 业务：将page换算成index，limit
        int index = (page-1)*LIMIT;
        return borrowRepository.findAllByReaderId(id,index,LIMIT);
    }

    @Override
    public List<Borrow> findAllBorrowByState(Integer state, Integer page) {
        // 业务：将page换算成index，limit
        int index = (page-1)*LIMIT;
        return borrowRepository.findAllByState(state,index,LIMIT);
    }

    @Override
    public Integer getBorrowPagesByState(Integer state) {
        int count = borrowRepository.countByState(state);
        int page = 0;
        if(count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT + 1;
        }
        return page;
    }
}
