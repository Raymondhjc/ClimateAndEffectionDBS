package climate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    private Users users;
    @Autowired
    private UserRepository userRepository;

    public UserService() {

    }


    public void addUser(Users users) {
        userRepository.save(users);
    }

    public Users signIn(String name, String password) {
        if (!checkUserExist(name)) {
            if (checkPasswordByName(name, password)) {
                Users users = userRepository.findByName(name);
                return users;
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
        return userRepository.findByName(name).equals(password);
    }

    private boolean checkUserExist(String name) {
        // cannot do this, load all users. Modify later!
//        List<Users> users = new ArrayList<>();
//        try {
//            return userRepository.findAll().forEach(users::);
//        } catch (NoSuchElementException ex) {
//            return ;
//        }
        return false;
    }
    // quick sign up. name and password, assign id
    public boolean signUp(String name, String password) {
        if (!checkUserExist(name)) {
            userRepository.save(new Users(new Integer(1), name, password));
        }
        return false;
    }

    public boolean changePassword(Users users, String oldPassword) {
        int f = checkPassword(users.getId(), oldPassword);
        if (f == 1) {
            userRepository.save(users);
            return true;
        } else {
            return false;
        }
    }

    public Iterable<Users> getAllUsers(){
        return userRepository.findAll();
    }

}
