package org.example;


import entity.User;
import jakarta.persistence.Query;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;


import java.util.List;

        public class Main {
            public static void main(String[] args) {
                Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

                //SELECT statement
        Query query = session.createQuery("FROM User");
        List<User> users = query.getResultList();

                //Как передать параметры
//        Query query = session.createQuery("FROM User u where u.id = :text and u.email like :text1");
//        query.setParameter("text", 4000L);
//        query.setParameter("text1", "makhanov");
//        List<User> users = query.getResultList();
//
       System.out.println(users.size());

                //Как написать LIMIT
//        Query query = session.createQuery("FROM User");
//        query.setFirstResult(1);
//        query.setMaxResults(10);
//        List<User> users = query.getResultList();
//        users.forEach(System.out::println);

                //Вытащить единичный запрос
//        Query<User> query = session.createQuery("FROM User where id=:id");
//        query.setParameter("id", 4000L);
//
//        User user = query.uniqueResult();
//        System.out.println(user.getUsername());

                //Вытащить число не используя доп память
//        Query<Long> query = session.createQuery("select " +
//                "count(u.id) from User u " +
//                "where email like :text");
//
//        query.setParameter("text", "%email%");
//        //List<User> users = query.getResultList();
//
//        Long count = query.uniqueResult();
//
//        System.out.println(count);

                //Вытащить единичный запрос 2
//        Query<String> query = session.createQuery("select u.email from User u where id = :id");
//        query.setParameter("id", 4000L);
//
//        String email = query.uniqueResult();
//        System.out.println(email); //But we also want to get username

                //Вытащить multiple запрос через конструктор
//        Query<User> query = session.createQuery("select new User(u.email, u.username) from User u where id = :id");
//        query.setParameter("id", 4000L);
//        User user = query.uniqueResult();
//        System.out.println(user.getUsername());
//        System.out.println(user.getEmail());

//        Вытащить единичный запрос 3 (по id)
//        User user = session.get(User.class, 4000L);
//        //find, load
//        System.out.println(user.);

                //Native SQL
//        String qry = "select * from todolist.user_data";
//        NativeQuery sqlQuery = session.createSQLQuery(qry);
//        sqlQuery.addEntity(User.class);
//
//        sqlQuery.setMaxResults(10);
//
//        List<User> list = sqlQuery.list();
//
//        for(int i=0; i<list.size(); i++){
//            System.out.println(list.get(i).getId());
//        }

                //Native query Object
//        NativeQuery<Object[]> query = session.createNativeQuery("select count(u.id), " +
//                "       substring(u.email, position('@' in u.email)+1, length(u.email)) as domainemail " +
//                "from todolist.user_data u where u.email like '%@%' " +
//                "group by substring(u.email, position('@' in u.email)+1, length(u.email))");
//
//
//        for (Object[] obj: query.getResultList()) {
////            Object[] objArray = (Object[]) obj;
//            System.out.println(obj[0]);
//            System.out.println(obj[1]);
//            System.out.println("--------");
//        }



                //One to Many
//        Query<Category> query = session.createQuery("from Category");
//        query.setMaxResults(10);
//
//        List<Category> categories = query.getResultList();
//        for (Category c : categories) {
//            System.out.println(c.getTitle());
//        }

//                //Many to Many
//                Query<UserDataEntity> query = session.createQuery("from UserDataEntity");
//                query.setMaxResults(2);
//
//                List<UserDataEntity> users = query.getResultList();
//                System.out.println(users.get(0).getRoles());


                session.close();
                HibernateUtil.close();
            }
        }



