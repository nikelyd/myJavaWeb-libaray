package com.southwind.repository.impl;

import com.southwind.entity.Book;
import com.southwind.entity.Borrow;
import com.southwind.entity.Reader;
import com.southwind.repository.BorrowRepository;
import com.southwind.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepositoryImpl implements BorrowRepository {
    @Override
    public void insert(Integer bookid, Integer readerid, String borrowtime, String returntime, Integer adminid, Integer state) {
        Connection connection = JDBCTools.getConnection();
        String sql = "insert into borrow(bookid,readerid,borrowtime,returntime,state) values (?,?,?,?,0)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,bookid);
            preparedStatement.setInt(2,readerid);
            preparedStatement.setString(3,borrowtime);
            preparedStatement.setString(4,returntime);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Borrow> findAllByReaderId(Integer id, Integer index, Integer limit) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select br.id, r.name, r.cardid, r.tel, b.name,b.author,b.publish,br.borrowtime,br.returntime , br.state from borrow br,book b,reader r where r.id=? and br.bookid=b.id and br.readerid=r.id limit ?,?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Borrow> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,index);
            preparedStatement.setInt(3,limit);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add(new Borrow(resultSet.getInt(1),new Book(resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)),new Reader(resultSet.getString(2),resultSet.getInt(4),resultSet.getInt(3)),resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10)));
                int i=0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<Borrow> findAllByState(Integer state, Integer index, Integer limit) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select br.id, r.name, r.cardid, r.tel, b.name,b.author,b.publish,br.borrowtime,br.returntime , br.state from borrow br,book b,reader r where br.state=? and br.bookid=b.id and br.readerid=r.id limit ?,?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Borrow> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,state);
            preparedStatement.setInt(2,index);
            preparedStatement.setInt(3,limit);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add(new Borrow(resultSet.getInt(1),new Book(resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)),new Reader(resultSet.getString(2),resultSet.getInt(4),resultSet.getInt(3)),resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10)));
                int i=0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public int count(Integer id) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from borrow br,book b,reader r where r.id=? and br.bookid=b.id and br.readerid=r.id";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int countByState(Integer state) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from borrow br,book b,reader r where br.state=? and br.bookid=b.id and br.readerid=r.id";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,state);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
