package model.dao;


import model.entity.Role;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
public class RoleDao extends BaseDaoImplementation{

    public Boolean insertROle(Role role) {
        return insert(role);

    }

    public Boolean editRole(Role role) {
        return update(role);

    }

    public Boolean deleteRole(Integer id) {
        return delete(findRole(id));

    }

    public Role findRole(Integer id) {
        return find(id, Role.class);
    }


    public List<Role> totRoles() {
        return getAll(new Role());
    }

    public Integer getIdRoleByDes (String des) {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaQuery<Integer> query = cb.createQuery(Integer.class);
        Root<Role> root = query.from(Role.class);
        query.select(cb.equals(root.get(Role_.desRole),des));
        return entityManager.createQuery(query).getSingleResult();
    }


}
