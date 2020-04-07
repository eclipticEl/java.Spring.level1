package server.gui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

public class ServerGUIRunner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
  //              ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-server.xml");
                ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
                context.getBean("serverGUI", ServerGUI.class);            }
        });
    }
}
