import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        String purchaseQuery = "From PurchaseList";
        List<PurchaseList> purchaseList = session.createQuery(purchaseQuery).getResultList();

        String courseQuery = "From Course";
        List<Course> courseList = session.createQuery(courseQuery).getResultList();

        String studentQuery = "From Student";
        List<Student> studentList = session.createQuery(studentQuery).getResultList();


        for (PurchaseList purchase : purchaseList) {
            for (Course course : courseList) {
                for (Student student : studentList) {

                    if (purchase.getCourseName().equals(course.getName()) &&
                            purchase.getStudentName().equals(student.getName())) {

                        LinkedPurchaseListKey linkedPurchaseListKey = new LinkedPurchaseListKey();
                        linkedPurchaseListKey.setCourseId(course.getId());
                        linkedPurchaseListKey.setStudentId(student.getId());

                        LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                        linkedPurchaseList.setId(linkedPurchaseListKey);

                        session.save(linkedPurchaseList);

                    }
                }
            }
        }

                transaction.commit();
                sessionFactory.close();
    }
}
