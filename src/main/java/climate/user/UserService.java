package climate.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private User user;

    public UserService(){

    }

    public boolean signIn(String name, String password) {
        if(checkUserExist(name)){
            if(checkPassword(name, password)){
                this.user.setId(name);
                this.user.setPassword(password);
                return true;
            }
        }
        return false;
    }

    private boolean checkPassword(String name, String password){
        // modify here
        if(password == "pass"){
            return true;
        }
        return false;
    }

    private boolean checkUserExist(String name){
        if(name == "pass")
            return true;
        return false;
    }

    public int signUp(User user){
        int code = 0;
        String name = user.getName();
        String password = user.getPassword();
        if(checkUserExist(name)){
            code = 0;
        }else{
            if(name == "n" && password == "pass"){
                code = 1;
            }
        }

        return code;
    }

    public boolean changePassword(User user){
        if(checkPassword("name", user.getPassword())){
            return false;
        }else{
            return true;
        }
    }

}
