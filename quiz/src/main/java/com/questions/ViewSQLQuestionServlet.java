package com.questions;

import java.io.IOException;

import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewsqllist")
public class ViewSQLQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the list of SQL questions from the database
        List<SQLQuestion> questionList = SQLQuestionDAO.getAllSQLQuestions();

        // Forward the list to the JSP page for rendering
        request.setAttribute("questionList", questionList);
        request.getRequestDispatcher("viewsqllist.jsp").forward(request, response);
    }
}

