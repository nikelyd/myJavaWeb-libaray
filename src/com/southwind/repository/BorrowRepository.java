package com.southwind.repository;

import com.southwind.entity.Borrow;

import java.util.List;

public interface BorrowRepository {
    public void insert(Integer booid,Integer readerid,String borrowtime,String returntime,Integer adminid,Integer state);
    public List<Borrow> findAllByReaderId(Integer id, Integer index, Integer limit);
    public List<Borrow> findAllByState(Integer state,Integer index, Integer limit);
    public int count(Integer id);
    public int countByState(Integer state);
}
