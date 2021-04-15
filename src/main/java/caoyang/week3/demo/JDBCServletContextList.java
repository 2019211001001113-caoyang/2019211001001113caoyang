package caoyang.week6.demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JDBCServletContextListener implements  ServletContextListener  {
@Override
public void contextInitialized(ServletContextEvent sce) {

    System.out.println("i am in contextInitialized()");


}
