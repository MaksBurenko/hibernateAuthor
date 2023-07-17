import entity.Author;

import javax.management.Query;
import java.util.List;

public class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCreateBuilder;
        CriteriaQuary cq = cb.createQuary(Author.class);
        Root<Author> root = cq.from(Author.class);
        Selection[] selections = {root.get("id")};
        cq.select(cb.construct(Author.class, selections));
        Query query = session.createQuery(cq);
        List<Author> authorList = query.getResultList();
        session.close();
        return authorList;

    }

    public Author getAuthorById(long ig) {
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id);
        session.close();
        return author;
    }

    public Author addAuthor(Author author){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
        return author;
    }
}
