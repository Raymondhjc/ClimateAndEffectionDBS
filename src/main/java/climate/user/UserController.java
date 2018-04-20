package climate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signIn")
    public User signIn(@RequestParam("name") String name, @RequestParam("password") String password){
        return userService.signIn(name, password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    @ResponseBody
    public User signUp(@RequestBody Map<String, String> request){
        return userService.signUp(request.get("name"), request.get("password"));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/changePassword")
    public boolean changePassword(@RequestBody Map<String, String> request){
        return userService.changePassword(request.get("name"), request.get("newPassword"), request.get("oldPassword"));
    }

}
