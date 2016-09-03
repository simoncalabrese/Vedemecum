package model.dao;

import model.entity.Role;

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
        List<Role> roles = getAll(new Role());
        return roles;
    }


}
