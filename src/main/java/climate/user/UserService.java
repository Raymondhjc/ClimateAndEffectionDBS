package climate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (checkUserExist(name)) {
            if (checkPasswordByName(name, password)) {
                List<User> users = userRepository.findByName(name);
                return users.get(0);
            }
        }
        return null;
    }

    private boolean checkPasswordByName(String name, String password) {
        return userRepository.findByName(name).size() == 1 && userRepository.findPasswordByName(name).equals(password);
    }

    private boolean checkUserExist(String name) {
        return userRepository.findByName(name).size() == 1;
    }
    // quick sign up. name and password, assign id
    public User signUp(String name, String password) {
        if (!checkUserExist(name)) {
            System.out.println(name+password);
            User u = new User(name, password);
            return userRepository.save(u);
        }
        return null;
    }

    public boolean changePassword(String name, String newPassword, String oldPassword) {
        if(checkPasswordByName(name, oldPassword)) {
            userRepository.save(new User(name, newPassword));
            return true;
        } else {
            return false;
        }
    }


}
