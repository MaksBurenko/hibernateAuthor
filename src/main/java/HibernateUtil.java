import com.mysql.cj.xdevapi.SessionFactory;

import javax.security.auth.login.Configuration;

public class HibernateUtil {

    private static SessionFactory factory;

    static{
        try {
            factory = new Configuration()
                    .configure("config.xml")
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory (){
        return factory;
    }

}
