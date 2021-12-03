package ro.unibc.lab08.main.dao;

import ro.unibc.lab08.main.model.Group;

import java.util.List;

public interface GroupDao {

    Group insert(String name);

    List<Group> findAll();

    Group findById(long id);

    Group update(Group group);
}
