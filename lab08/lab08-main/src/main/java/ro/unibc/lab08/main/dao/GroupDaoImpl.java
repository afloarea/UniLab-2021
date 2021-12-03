package ro.unibc.lab08.main.dao;

import org.springframework.stereotype.Repository;
import ro.unibc.lab08.main.model.Group;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class GroupDaoImpl implements GroupDao {

    private final EntityManager em;

    public GroupDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Group insert(String name) {
        final var group = new Group();
        group.setName(name);
        em.persist(group);
        return group;
    }

    @Override
    public List<Group> findAll() {
        return em.createQuery("SELECT g FROM Group g", Group.class)
                .getResultList();
    }

    @Override
    public Group findById(long id) {
        return em.find(Group.class, id);
    }

    @Override
    public Group update(Group group) {
        em.merge(group);
        return group;
    }
}
