package com.southwind.repository;

import com.southwind.entity.Borrow;

import java.util.List;

public interface BorrowRepository {
    /**
     * 功能：添加读者借阅信息
     * @param bookid        // 书籍编号
     * @param readerid      // 读者编号
     * @param borrowtime    // 借阅时间
     * @param returntime    // 还书时间
     * @param adminid       // 审核员（管理员）编号
     * @param state         // 审核状态
     */
    public void insert(Integer bookid,Integer readerid,String borrowtime,String returntime,Integer adminid,Integer state);

    /**
     * 功能：返回id对应的读者，所有借阅的书籍
     * @param id            // 读者编号
     * @param index         // 展示信息的页数-1
     * @param limit         // 每页展示的信息行数
     * @return
     */
    public List<Borrow> findAllByReaderId(Integer id, Integer index, Integer limit);

    /**
     * 功能：根据state（0:待审核，1：同意）查找所有借阅信息
     * @param state         // 审核状态
     * @param index         // 展示信息的页数-1
     * @param limit         // 每页展示的信息行数
     * @return
     */
    public List<Borrow> findAllByState(Integer state,Integer index, Integer limit);

    /**
     * 功能：返回id对应读者的借阅书籍数量
     * @param id            // 读者id
     * @return
     */
    public int count(Integer id);

    /**
     * 功能：计算state（0:待审核，1：同意）对应的借阅信息数量
     * @param state         // 图书审核状态：0:待审核，1：同意
     * @return
     */
    public int countByState(Integer state);

    /**
     * 功能：管理员（Admin）执行借阅审核操作：同意、拒绝
     * @param borrowId      // 借阅编号
     * @param state         // 同意1或拒绝2
     * @param adminId       // 管理员编号
     */
    public void handle(Integer borrowId, Integer state, Integer adminId);
}
