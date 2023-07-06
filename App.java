package manish.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.ArrayList;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Configuration cfg = new Configuration();
       cfg.configure();
       
       SessionFactory fac = cfg.buildSessionFactory();
       
       
       Qustion q = new Qustion ();
       q.setQustionId(12);;
       q.setQustion("what is java");
       
       
       Answer a = new Answer();
       a.setAnswerId(122);
       a.setAnswer("it is an language");
       a.setQus(q);
       
       Answer a1 = new Answer();
       a1.setAnswerId(132);
       a1.setAnswer("it is an language2");
       a1.setQus(q);
       
       Answer a2 = new Answer();
       a2.setAnswerId(152);
       a2.setAnswer("it is an language4");
       a2.setQus(q);
       List <Answer>list = new ArrayList<Answer>();
       list.add(a);
       list.add(a1);
       list.add(a2);
       
       q.setAns(list);
       
       Session s = fac.openSession();
       Transaction tx = s.beginTransaction();
       
       s.save(q);
       s.save(a);
       s.save(a1);
       s.save(a2);
       Qustion q2 =( Qustion)s.get( Qustion.class,12);
       System.out.println(q2.getQustion());
       
       for(Answer x :q2.getAns()) {
    	   System.out.println(x.getAnswer());
       }
       
     
       
       tx.commit();
       s.close();
       fac.close();
       
    }
}
