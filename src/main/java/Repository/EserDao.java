package Repository;

import Entity.Eser;
import Entity.Sergi;
import Util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class EserDao implements ICrud<Eser>{
    @Override
    public void save(Eser eser) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(eser);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
    }

    @Override
    public List<Eser>  getAll() {
        List<Eser> list = null;
        try{
        Session session= HibernateUtil.getSessionFactory().openSession();
        list=session.createQuery("SELECT eser from Eser eser").list();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Eser eser) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(eser);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Eser eser = session.load(Eser.class, id);
            session.delete(eser);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
