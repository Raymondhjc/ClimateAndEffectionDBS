package climate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signIn")
    public User signIn(@RequestParam String name, @RequestParam String password){
        return userService.signIn(name, password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    public int signUp(@RequestBody User user){
        return userService.signUp(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/changePassword")
    public boolean changePassword(@RequestBody User user, @RequestBody String oldPassword){
        return userService.changePassword(user, oldPassword);
    }

}
