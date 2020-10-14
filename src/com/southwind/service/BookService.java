package com.southwind.service;

import com.southwind.entity.Book;
import com.southwind.entity.Borrow;

import java.util.List;

public interface BookService {
    /**
     * 功能：返回第page也的图书信息
     * @param page          // 页面编号
     * @return
     */
    public List<Book> findAll(int page);

    /**
     * 功能：根据总图书数量和每页展示图书数量，计算图书信息的总页数
     * @return
     */
    public Integer getPages();

    /**
     * 功能：获取id对应的读者所有借阅的图书
     * @param id            // 读者编号
     * @return
     */
    public Integer getBorrowPages(Integer id);

    /**
     * 功能：添加读者借阅的书籍到数据库
     * @param bookid        // 书籍编号
     * @param readerid      // 读者编号
     */
    public void addBorrow(Integer bookid, Integer readerid);

    /**
     * 功能：返回id对应的读者的第page页的借阅信息
     * @param id            // 读者编号
     * @param page          // 第page页
     * @return
     */
    public List<Borrow> findAllBorrowByReaderId(Integer id,Integer page);

    /**
     * 功能：根据借阅状态，返回对应状态的第page页的借阅信息
     * @param state         // 借阅状态
     * @param page          // 第page页
     * @return
     */
    public List<Borrow> findAllBorrowByState(Integer state,Integer page);

    /**
     * 功能：计算借阅状态为state的借阅信息数量
     * @param state         // 借阅状态
     * @return
     */
    public Integer getBorrowPagesByState(Integer state);

    /**
     * 功能：管理员执行审核操作：同意、拒绝
     * @param borrowId      // 借阅的书籍编号
     * @param state         // 执行操作：同意、拒绝
     * @param adminId       // 管理员编号
     */
    public void handleBorrow(Integer borrowId, Integer state, Integer adminId);
}
