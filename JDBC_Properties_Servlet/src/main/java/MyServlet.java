
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypack.SingletonCon;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyServlet extends HttpServlet {

	private Connection con;

	public void init(ServletConfig config) throws ServletException {
		try {
			con = SingletonCon.getCon();
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("Using properties <hr>");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from dept");
			
			while (rs.next()) {
				pw.println(rs.getInt(1)+"<br>");
				pw.println("<h1>"+rs.getString(2)+"</h1><br>");
				pw.println(rs.getString(3)+"<br><hr>");

			}
		} catch (Exception ee) {
			System.out.println(ee);
		}

	}

}
