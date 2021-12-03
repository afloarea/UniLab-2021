package ro.unibc.lab08.main.dao;

import org.springframework.stereotype.Repository;
import ro.unibc.lab08.main.model.Student;

import javax.persistence.EntityManager;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final EntityManager em;

    public StudentDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Student save(Student student) {
        em.persist(student);
        return student;
    }

    @Override
    public Student findById(long id) {
        return em.find(Student.class, id);
    }

    @Override
    public Student findByIdAndGroupId(long studentId, long groupId) {
        return em.createQuery("SELECT s FROM Student s WHERE s.id=:studentId AND s.group.id=:groupId", Student.class)
                .setParameter("studentId", studentId)
                .setParameter("groupId", groupId)
                .getSingleResult();
    }

    @Override
    public void delete(Student student) {
        em.remove(student);
    }
}
