package com.questions;

import java.io.IOException;

import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sqlTestServlet")
public class SQLTestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SQLQuestion> sqlQuestions = SQLQuestionDAO.getAllSQLQuestions();
        request.setAttribute("sqlQuestions", sqlQuestions);
        request.getRequestDispatcher("sqlTest.jsp").forward(request, response);
    }
}

