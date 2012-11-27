package course.xml.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import course.xml.xslt.XmlTransformer;

/**
 * Servlet implementation class CDListeServlet
 */
public class XMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String view = request.getParameter("view");

		if (StringUtils.isBlank(view)) {
			view = "cdliste";
		}
		new XmlTransformer().asHtml(out, view+".xml", view+".xslt");
		out.flush();
	}

}
