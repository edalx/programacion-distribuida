package com.eacuji.servlets;

import com.eacuji.config.ArtemisMqConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eacuji on 18/01/2018.
 */
@WebServlet("/recibir")
public class Recibir extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String queueName="/queue/productor";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ArtemisMqConfig.class);
        JmsTemplate jmsTemplate=ctx.getBeansOfType(JmsTemplate.class).get("jmsTemplateRecive");
        Message msj=jmsTemplate.receive(queueName);
        TextMessage textMessage=(TextMessage)msj;
        try {
            String txt=textMessage.getText();
            System.out.println(">>>>>>>>>>> Imprimiendo cadena=" +txt);
            request.setAttribute("textValue",txt);
            request.getRequestDispatcher("recibir.jsp").forward(request,response);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
