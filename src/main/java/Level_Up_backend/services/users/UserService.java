package Level_Up_backend.services.users;

import Level_Up_backend.Models.users.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    User registerUser(User user);

    void deleteUser(Long user);
}
