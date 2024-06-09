package poly.java5divineshop.Divineshop.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import poly.java5divineshop.Divineshop.Data.Entity.RoleE;

@Repository
public interface RoleRepo extends JpaRepository<RoleE, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update Roles set role = :role where id_role = :id_role ", nativeQuery = true)
    int updateRoleByIdRole(@Param("role") String role, @Param("id_role") Integer id_role);

    @Query(value = "select * from Roles r where r.username = :username and r.role = :role", nativeQuery = true)
    RoleE getRoleByUsernameAndRole(@Param("username") String username, @Param("role") String role);
}
