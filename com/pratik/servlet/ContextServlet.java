package com.pratik.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextServlet
 */
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		//get the response writer
		PrintWriter out = response.getWriter();
		//initialise the servlet context
		ServletContext context = request.getServletContext();
		//get the context name
		String lname = context.getServletContextName();
		//initialise the parameters
		String a = context.getInitParameter("a");
		String b = context.getInitParameter("b");
		String c = context.getInitParameter("c");
		String d = context.getInitParameter("d");
		
		Enumeration<String> e1 = context.getInitParameterNames();
		String param_Names = "";
		//appending attr names to a string variable 
		while(e1.hasMoreElements()) {
		param_Names = param_Names + e1.nextElement()+"<br>";
		}
				//set the attribute
		context.setAttribute("x", "XXX");
		context.setAttribute("y", "YYY");
		context.setAttribute("z", "ZZZ");

		String x = (String)context.getAttribute("x");
		String y = (String)context.getAttribute("y");
		String z = (String)context.getAttribute("z");
			//get the attribute names
				Enumeration<String> e2 = context.getAttributeNames();
					String attr_Names = "";
						//appending attr names to a string variable 
					while(e2.hasMoreElements()) {
						attr_Names = attr_Names + e2.nextElement()+"<br>";
					}//while close
//html code to display
		out.println("<html>");
			out.println("<body>");
				out.println("<h3>Servlet Context Details<h3>");
					out.println("<table border='1'>");
						out.println("<tr><td colspan='2'>Parameters Details</td></tr>");
							out.println("<tr><td>a</td><td>"+a+"</td></tr>");
							out.println("<tr><td>b</td><td>"+b+"</td></tr>");
							out.println("<tr><td>c</td><td>"+c+"</td></tr>");
							out.println("<tr><td>d</td><td>"+d+"</td></tr>");
								out.println("<tr><td>Parameter Names</td><td>"+param_Names+"</td></tr>");
									out.println("<tr><td colspan='2'>Attributes Details</td></tr>");
										out.println("<tr><td>x</td><td>"+x+"</td></tr>");
										out.println("<tr><td>y</td><td>"+y+"</td></tr>");
										out.println("<tr><td>z</td><td>"+z+"</td></tr>");
											out.println("<tr><td>Attributes Names</td><td>"+attr_Names+"</td></tr>");
												out.println("<tr><td>Logical Name</td><td>"+lname+"</td></tr>");
												out.println("<tr><td>Foreign Context</td><td>"+context.getContext("/app8")+"</td></tr>");
												out.println("</table></body></html>");

		}//doGet(-,-) close
	}//class close

