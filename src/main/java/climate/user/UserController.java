package climate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signIn")
    public Users signIn(@RequestParam("name") String name, @RequestParam("password") String password){
        return userService.signIn(name, password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    public boolean signUp(@RequestBody String name, String password){
        return userService.signUp(name, password);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/changePassword")
    public boolean changePassword(@RequestBody Users users, String oldPassword){
        return userService.changePassword(users, oldPassword);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Users> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.getAllUsers();
    }

}
