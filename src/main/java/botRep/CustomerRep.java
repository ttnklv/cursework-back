package botRep;

import botBase.CustomersEntity;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CustomerRep {

    public CustomersEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(CustomersEntity.class, id);
    }

    public CustomersEntity findByLogin(String login) {

        String hql = "from CustomersEntity where login = :param";
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(hql);
        query.setParameter("param", login);
        List<CustomersEntity> customers = query.list();

        if (customers.size() == 0) return null;
        return customers.get(0);
    }


}
