package climate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signIn")
    public User signIn(@RequestParam("name") String name, @RequestParam("password") String password){
        return userService.signIn(name, password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    public boolean signUp(@RequestBody String name, String password){
        return userService.signUp(name, password);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/changePassword")
    public boolean changePassword(@RequestBody User user, String oldPassword){
        return userService.changePassword(user, oldPassword);
    }

}
