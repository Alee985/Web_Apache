import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;


public class signup extends HttpServlet {

    //Process the HTTP Get request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // get PrintWriter object
        PrintWriter out = response.getWriter();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String conf = request.getParameter("conf");

        out.println("<html>");
        out.println("<head><title>conformation</title></head>");
        out.println("<body>");

        try{

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/data";

            Connection con=DriverManager.getConnection(url, "root", "root");

            Statement st=con.createStatement();


            String query = "INSERT INTO info(firstName,lastName,email,password)VALUES('"+fname+"','"+lname+"','"+email+"', '"+pass+"' ) ";

            // System.out.println(query);

            int rs = st.executeUpdate( query );

            if(rs==1){	out.println("<h1>Insertion successful</h1>"); 		}
            else{	out.println("<h1>Record could not be inserted.</h1>"); 		}

            out.println("</body></html>");

            st.close();
            con.close();

        }catch(Exception e){

            out.println(e);
        }

    }

}
