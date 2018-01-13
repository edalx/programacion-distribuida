package com.eacuji.web;

import com.eacuji.dto.Singer;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.jms.ObjectMessage;
import java.io.Serializable;

@ManagedBean(name = "singerAction")
@SessionScoped
public class SingerAction implements Serializable {
    private Singer singer;
    private JmsTemplate jmsTemplate;

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @PostConstruct
    public void init() {
        ApplicationContext context =
                FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        jmsTemplate = context.getBean(JmsTemplate.class);
        singer = new Singer();
    }


    public String send() {
        jmsTemplate.send(
                (session) -> {
                    ObjectMessage jmsMessage = session.createObjectMessage(singer);
                    System.out.println(">>> Enviando: " + singer);
                    return jmsMessage;
                }
        );
        return "index";
    }

    public void limpiar(){
        this.singer.setFirstName("");
        this.singer.setLastName("");
        this.singer.setBirthDate(null);
    }

}
