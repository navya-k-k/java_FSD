package com.questions;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/deletesqlquestion")
public class DeleteSQLQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the question ID from the request parameter
        Long questionId = Long.parseLong(request.getParameter("id"));

        // Delete the SQL question from the database
        SQLQuestionDAO.deleteSQLQuestion(questionId);

        // Redirect back to the view page
        response.sendRedirect(request.getContextPath() + "/viewsqllist");
    }
}

