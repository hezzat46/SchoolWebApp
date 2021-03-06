package DAO;

import Service.AdminTeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/viewTeacher.do")
public class TeacherDetailServlet extends HttpServlet {
    AdminTeacherService x = new AdminTeacherService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("CourseAssigned",x.ShowCoursesAssigned(request.getParameter("teachername")));
        request.setAttribute("TeacherList",x.ShowTeachers());
        request.getRequestDispatcher("/WEB-INF/views/viewTeacher.jsp").forward(request,response);
    }
}