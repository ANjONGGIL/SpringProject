package kr.co.fastcampus.cli;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ClassNotFoundException {

        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        System.out.println(context);
        Dao dao = context.getBean(Dao.class);
        dao.run();
    }
}
