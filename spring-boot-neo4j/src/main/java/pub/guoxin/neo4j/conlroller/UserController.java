package pub.guoxin.neo4j.conlroller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pub.guoxin.neo4j.model.User;
import pub.guoxin.neo4j.repository.UserRepository;

/**
 * Created by guoxin on 17-8-13.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value="测试接口", notes="测试接口详细描述")
    public String add(@RequestBody User user){
        User save = userRepository.save(user);
        System.out.printf(save.toString());
        return save.toString();
    }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value="测试接口", notes="测试接口详细描述")
    public String get(){
        Iterable<User> iterable = userRepository.findAll();
        return iterable.toString();
    }

}
