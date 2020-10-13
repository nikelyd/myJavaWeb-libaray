package com.southwind.controller;

import com.southwind.entity.Borrow;
import com.southwind.service.BookService;
import com.southwind.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method == null){
            method = "findAllBorrow";
        }
        switch (method){
            case "findAllBorrow":
                String pageStr = req.getParameter("page");
                int page = Integer.parseInt(pageStr);
                List<Borrow> borrowList = bookService.findAllBorrowByState(0,page);
                req.setAttribute("list",borrowList);
                req.setAttribute("dataPrePage",6);
                req.setAttribute("currentPage",page);
                req.setAttribute("pages",bookService.getBorrowPagesByState(0));
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
                break;
            case "handle":

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + method);
        }
    }
}
