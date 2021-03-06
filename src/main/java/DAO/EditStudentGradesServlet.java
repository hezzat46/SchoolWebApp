package DAO;


import Service.AdminService;
import Service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/editStudentGrades.do")
public class EditStudentGradesServlet extends HttpServlet {
    String Username;
    AdminService y= new AdminService();
    CourseService x = new CourseService();
    String[] Grades = new String[] { "A", "B", "C","D","F" };
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Username=request.getParameter("Username");
        request.setAttribute("CourseList",x.ShowCourses(request.getParameter("Username")));
        request.setAttribute("GradeList",Grades);

        request.getRequestDispatcher("/WEB-INF/views/editStudentGrades.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String action = request.getParameter("action");
        if(action == null) {

            try {
                y.AddGrade(request.getParameter("CourseList"), request.getParameter("category"), Username);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("CourseList", x.ShowCourses(Username));
            request.setAttribute("GradeList", Grades);
            request.getRequestDispatcher("/WEB-INF/views/editStudentGrades.jsp").forward(request, response);
        }
        else{
        response.setContentType("text/plain");
        String  Selected= request.getParameter("Selected");

        PrintWriter out = response.getWriter();
        out.print("Current Grade is : "+x.GetGrade(Selected,Username));
    }
    }
    }
