package climate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private User user;
    @Autowired
    private UserRepository userRepository;

    public UserService() {

    }


    public void addUser(User user) {
        userRepository.save(user);
    }

    public User signIn(String name, String password) {
        if (!checkUserExist(name)) {
            if (checkPasswordByName(name, password)) {
                User user = userRepository.findByName(name);
                return user;
            }
        }
        return null;
    }

    private int checkPassword(Long id, String password) {
        boolean f;
        try {
            f = userRepository.findById(id).get().equals(password);
        } catch (NoSuchElementException ex) {
            return -1;
        }
        return f ? 1 : 0;
    }

    private boolean checkPasswordByName(String name, String password) {
        return userRepository.findByName(name).equals(password);
    }

    private boolean checkUserExist(String name) {
        // cannot do this, load all users. Modify later!
//        List<User> users = new ArrayList<>();
//        try {
//            return userRepository.findAll().forEach(users::);
//        } catch (NoSuchElementException ex) {
//            return ;
//        }
        return false;
    }

    public int signUp(User user) {
        int code = 0;
        String name = user.getName();
        String password = user.getPassword();
        if (checkUserExist(name)) {
            code = 0;
        } else {
            if (name == "n" && password == "pass") {
                code = 1;
            }
        }

        return code;
    }

    public boolean changePassword(User user, String oldPassword) {
        int f = checkPassword(user.getId(), oldPassword);
        if (f == 1) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

}
