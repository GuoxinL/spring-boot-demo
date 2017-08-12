package pub.guoxin.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pub.guoxin.mongo.model.User;
import pub.guoxin.mongo.repository.UserRepository;

import java.util.List;

/**
 * Created by guoxin on 17-3-29.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(@RequestBody User user){
        User save = userRepository.save(user);
        return save.toString();
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String delete(@PathVariable String id){
        if (id == null){
            return "fail";
        }
        userRepository.delete(id);
        return "删除成功";
    }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> select(){
        List<User> all = userRepository.findAll();
        return all;
    }
}
