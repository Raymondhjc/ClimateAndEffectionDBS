package climate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    private int checkPassword(int id, String password) {
        boolean f;
        try {
            f = userRepository.findById(id).get().equals(password);
        } catch (NoSuchElementException ex) {
            return -1;
        }
        return f ? 1 : 0;
    }

    private boolean checkPasswordByName(String name, String password) {
        System.out.println(userRepository.findPasswordByName(name));
        return userRepository.findByName(name).size() == 1 && userRepository.findPasswordByName(name).equals(password);
    }

    private boolean checkUserExist(String name) {
        return userRepository.findByName(name).size() == 1;
    }
    // quick sign up. name and password, assign id
    public boolean signUp(String name, String password) {
        if (!checkUserExist(name)) {
            userRepository.save(new User(new Integer(1), name, password));
        }
        return false;
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
