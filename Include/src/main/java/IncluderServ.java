

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IncluderServ
 */
public class IncluderServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw=response.getWriter();
		pw.println("<b>this is a main servlet</b><br>");
		RequestDispatcher rd=request.getRequestDispatcher("IncludedServ");
		rd.include(request,response);
		pw.println("<b>coming back to main servlet</b>");}

}
