package botRep;

import botBase.PostEntity;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class PostRep {

    /**
     * достаем количество новых постов этого чувака на сегодня
     *
     * @param id - customer id hum follow
     * @return - list of posts
     */
    public List<PostEntity> findNewPostByFollower(int id) {
        String hql = "from PostEntity where userUsOwnerId = :param";
        //createDate =  current_date and
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(hql);
        query.setParameter("param", id);
        List<PostEntity> l = (List<PostEntity>) query.list();
        return l;
    }

}
