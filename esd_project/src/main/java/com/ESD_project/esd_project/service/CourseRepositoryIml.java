//package com.ESD_project.esd_project.service;
//
//import com.ESD_project.esd_project.service.CourseRepositoryCustom;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//@Repository
//public class CourseRepositoryIml implements CourseRepositoryCustom {
//    @Autowired
//    private EntityManager entityManager;
//
//    @Override
//    public List<Object[]> getCourseDetailsForEmployeeId(Integer employeeId) {
//        String jpql = "SELECT c.name, c.courseId, cs.time, cs.day, s.name " +
//                "FROM  CourseSchedule cs " +
//                "JOIN  cs.course c " +
//                "JOIN  c.employee e " +
//                "JOIN  c.specializationCourse sc " +
//                "JOIN  sc.specialization s " +
//                "WHERE e.employeeId = :employeeId";
//
//        Query query = entityManager.createQuery(jpql);
//        query.setParameter("employeeId", employeeId);
//
//        return query.getResultList();
//    }
//}
