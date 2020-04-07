package client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class ClientGUIRunner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-client.xml");
                context.getBean("clientGUI", ClientGUI.class);
            }
        });
    }
}
