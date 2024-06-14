package poly.java5divineshop.Divineshop.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.java5divineshop.Divineshop.Data.Dto.RoleDto;
import poly.java5divineshop.Divineshop.Data.Entity.RoleE;
import poly.java5divineshop.Divineshop.Data.Model.RoleM;
import poly.java5divineshop.Divineshop.Repo.RoleRepo;
import poly.java5divineshop.Divineshop.Service.RoleService;

import java.sql.SQLException;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepo roleRepo;

    @Override
    public int saveRole(RoleDto roleDto) throws SQLException {
        return roleRepo.saveRole(roleDto.getUsername(), roleDto.getUsername(), roleDto.getRole());
    }

    @Override
    public int deleteRoleByUsername(RoleDto roleDto) throws SQLException {
        return roleRepo.deleteRoleByUsername(roleDto.getUsername());
    }

    @Override
    public RoleM getRoleByUsernameAndRole(String username, String role) throws SQLException {
        RoleE roleE = roleRepo.getRoleByUsernameAndRole(username, role);
        return roleE == null ? null : RoleM.convertRoleEToRoleM(roleE);
    }
}
