package poly.java5divineshop.Divineshop.Service;

import java.sql.SQLException;
import java.util.List;

import poly.java5divineshop.Divineshop.Data.Dto.UserDto;
import poly.java5divineshop.Divineshop.Data.Model.UserM;

public interface UserService {
    List<UserM> getAllUser() throws SQLException;

    UserM getUserByTenDangNhap(String tenDangNhap) throws SQLException;

    UserM getUserByUsernameAndRole(String username, String role) throws SQLException;

    int updateUserByTenDangNhap(UserDto userDto) throws SQLException;

    AccountE save(AccountDTO accountDTO);

    void sendMailForUser(String email, String otp);

}
