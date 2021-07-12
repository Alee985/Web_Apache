import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
//import java.util.*;


public class signin extends HttpServlet {

    //Process the HTTP Get request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();

        String fname = request.getParameter("fname");
        String pwd=request.getParameter("password");
        out.println("<html>");
        out.println("<head><title>Login</title></head>");
        out.println("<body>");


        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/data";

            Connection con=DriverManager.getConnection(url,"root","root");

            Statement st=con.createStatement();


            String query="Select * from info where firstName='"+fname+"' && password ='"+pwd+"' ";

            ResultSet rs = st.executeQuery( query );

            if(rs.next()){

                out.println("<h1>Record found</h1>");

            }

            else{
                out.println("<h1>No record found</h1>");
            }


            out.println("</body></html>");
            st.close();
            con.close();

        }catch(Exception e){

            out.println(e);
        }

    }

}
