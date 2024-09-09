package dev.nikhillab.learn.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.nikhillab.learn.jpa.mappings.Course;
import dev.nikhillab.learn.jpa.mappings.Instructor;
import dev.nikhillab.learn.jpa.mappings.InstructorDetails;
import jakarta.persistence.EntityManager;

public interface InstructorDAO {
    @Transactional
    void save(Instructor instructor);

    List<Instructor> findAll();

    Instructor findById(Long id);

    @Transactional
    void deleteById(Long id);

    InstructorDetails findInstructorDetailsById(Long id);

    List<Course> findAllCourse();
    List<Course> findCoursesByInstructor(Long id);
    Instructor findInstructorByIdJoinFetchCourses(Long id);

    EntityManager getEntityManager();

    @Transactional
    <T> void update(T entity);



}

@Repository
class InstructorDAOImpl implements InstructorDAO {
    public EntityManager entityManager;

    public InstructorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("FROM Instructor", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(Long id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public void deleteById(Long id) {
        var ins=entityManager.find(Instructor.class, id);
        var cor=ins.getCourses();

        for (Course course : cor) {
            course.setInstructor(null);
        }

        entityManager.remove(ins);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(Long id) {
        return entityManager.find(InstructorDetails.class, id);
    }

    @Override
    public List<Course> findCoursesByInstructor(Long id) {

        var query=entityManager.createQuery("FROM Course where instructor.id =:data",Course.class);
        query.setParameter("data", id);

        return query.getResultList();
    }

    @Override
    public List<Course> findAllCourse() {
        return entityManager.createQuery("FROM Course", Course.class).getResultList();

    }

    @Override
    public Instructor findInstructorByIdJoinFetchCourses(Long id) {
        var query=entityManager.createQuery("SELECT  i FROM Instructor i JOIN FETCH i.courses JOIN FETCH i.details where i.id =:data",Instructor.class);
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public <T> void update(T entity) {
        entityManager.merge(entity);
    }
    
}
