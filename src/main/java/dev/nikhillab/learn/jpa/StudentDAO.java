package dev.nikhillab.learn.jpa;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

public interface StudentDAO {

    void save(Student student);

    Student findById(Long id);

    List<Student> findAll();

    Student update(Student student);

    // void deleteByLastName(String lastName);

    void delete(Long id);

    int deleteAll();

}

@Repository
class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);

    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student);
    }

    // @Override
    // @Transactional
    // public void deleteByLastName(String lastName) {
    //     var query=entityManager.createQuery("DELETE FROM Student s WHERE s.lastName := lname");
    //     query.setParameter("lname", lastName);
    //     query.executeUpdate();

    // }

    @Override
    @Transactional
    public void delete(Long id) {
        var stu = entityManager.find(Student.class, id);
        entityManager.remove(stu);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }

}
