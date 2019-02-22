package botRep;

import botBase.FollowerActorEntity;
import botBase.FollowerAnalystEntity;
import botBase.FollowerStudioEntity;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class Followers {

    /**
     * @param id - id customer
     * @return list of actors for whom follow customer
     */
    public List<FollowerActorEntity> findAllActorsForUser(int id){
        String hql = "from FollowerActorEntity where idCustomers  = :paramid";
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(hql);
        query.setParameter("paramid", id);
        List<FollowerActorEntity> actors = query.list();
        return actors;
    }

    /**
     * @param id - id customer
     * @return list of analysts for whom follow customer
     */
    public List<FollowerAnalystEntity> findAllAnalystForUser(int id){
        String hql = "from FollowerAnalystEntity where idCustomers  = :paramid";
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(hql);
        query.setParameter("paramid", id);
        List<FollowerAnalystEntity> analysts = query.list();
        return analysts;
    }

    /**
     * @param id - id customer
     * @return list of studios for whom follow customer
     */
    public List<FollowerStudioEntity> findAllStudiosForUser(int id){
        String hql = "from FollowerStudioEntity where idCustomers  = :paramid";
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(hql);
        query.setParameter("paramid", id);
        List<FollowerStudioEntity> studios = query.list();
        return studios;
    }
}
