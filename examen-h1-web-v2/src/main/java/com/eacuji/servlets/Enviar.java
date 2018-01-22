package com.eacuji.servlets;

import com.eacuji.config.ArtemisMqConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import java.io.IOException;

import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/enviar")
public class Enviar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private JmsTemplate jmsTemplate;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt=request.getParameter("cadena");
        String op=request.getParameter("op");
        String msj=txt+","+op;
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ArtemisMqConfig.class);
        jmsTemplate = ctx.getBeansOfType(JmsTemplate.class).get("jmsTemplate");
        send(msj);
        request.getRequestDispatcher("enviado.jsp").forward(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest rquest, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public String send(String cadena) {
        jmsTemplate.send(
                (session) -> {
                    TextMessage jmsMessage = session.createTextMessage(cadena);
                    System.out.println(">>> Enviando: " + cadena);
                    return jmsMessage;
                }
        );
        return "index";
    }
}