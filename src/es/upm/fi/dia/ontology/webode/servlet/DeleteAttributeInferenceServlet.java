package es.upm.fi.dia.ontology.webode.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import es.upm.fi.dia.ontology.webode.service.*;

/**
 * Servlet responsible for removing an inference relation between attributes.
 *
 * @author  Julio C�sar Arp�rez Vega
 * @version 0.3
 */
public class DeleteAttributeInferenceServlet extends BaseServlet
{
    public void doPost (HttpServletRequest req,
			HttpServletResponse res,
			HttpSession session)
	throws ServletException, IOException
    {
	// Get parameters
	String attributeName = req.getParameter (ATTRIBUTE_NAME);
	String termName      = req.getParameter (TERM_NAME);
	String iterm         = req.getParameter (INFERRED_TERM_NAME);
	String iattr         = req.getParameter (INFERRED_ATTRIBUTE_NAME);
	String foo           = req.getParameter (INSTANCE);
	boolean bIns         = foo != null && foo.equals("true");

	String oname        = (String) session.getAttribute (CURRENT_ONTOLOGY);
        Properties prop = (Properties)session.getAttribute("prop");

	if (oname == null || oname.trim().equals("")) {
	   error (res, prop.getProperty("Theontologynameisamandatoryparameter."));
	    return;
	}
	if (termName == null || termName.trim().equals("") ||
	    attributeName == null || attributeName.trim().equals("") ||
	    iterm == null || iterm.trim().equals("") ||
	    iattr == null || iattr.trim().equals("")) {
	     error (res, prop.getProperty("Thetermandattributenamesaremandatoryparameters."));
	    return;
	}

	try {
	    // all right.  Let's insert this data into the database
	    ((ODEService) session.getAttribute (ODE_SERVICE)).
		removeAttributeInferenceRelation (oname, termName, attributeName, iterm, iattr);

	    PrintWriter pw = res.getWriter ();
	    /*
	     // NUEVO PARA MULTILINGUALIDAD DANI
        pw.println("<html>");
        pw.println("  <head>");
        pw.println("     <META HTTP-EQUIV=\"refresh\" content=\"5;URL=../jsp/webode/about.jsp\"> ");
        pw.println("  </head>");
        // FIN NUEVO */
	    header(pw);
	    setRedirectParam (termName);
	    setRedirectParam (1, attributeName);
	    setRedirectParam (2, bIns ? "true" : "false");
	    body (pw, prop.getProperty("Attributeinferencerelationdeletedsuccessfully."));
	    trailer (pw);
	} catch (Exception e) {
	    error (res, e.getMessage(), e);
	}
    }
}
