package ro.unibc.lab08.main.dao;

import ro.unibc.lab08.main.model.Student;

public interface StudentDao {

    Student save(Student student);

    Student findById(long id);

    Student findByIdAndGroupId(long studentId, long groupId);

    void delete(Student student);
}
