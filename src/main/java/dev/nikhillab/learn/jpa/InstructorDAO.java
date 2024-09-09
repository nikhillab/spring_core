package dev.nikhillab.learn.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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


}

@Repository
class InstructorDAOImpl implements InstructorDAO {
    private EntityManager entityManager;

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
        entityManager.remove(entityManager.find(Instructor.class, id));
    }

    @Override
    public InstructorDetails findInstructorDetailsById(Long id) {
        return entityManager.find(InstructorDetails.class, id);
    }
}
