package eacuji.config;

import org.apache.cxf.transport.servlet.CXFServlet;

import javax.servlet.annotation.WebServlet;

/**
 * Created by eacuji on 01/02/18.
 */
@WebServlet("/rest/*")
public class CXFServletConfig extends CXFServlet {
}
