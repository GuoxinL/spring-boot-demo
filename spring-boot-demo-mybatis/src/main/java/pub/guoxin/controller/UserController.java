package pub.guoxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pub.guoxin.model.User;
import pub.guoxin.mapper.UserMapper;

import java.util.List;

/**
 * Created by guoxin on 17-3-29.
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/user/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(User user){
        int insert = userMapper.insert(user);
        return "success";
    }

    @DeleteMapping(value = "/user/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String delete(@PathVariable Integer id){
        if (id == null){
            return "fail";
        }
        int delete = userMapper.deleteByPrimaryKey(id);
        return String.valueOf(delete);
    }

    @PutMapping(value = "/user/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String update(User user){
        if (user== null){
            return "fail";
        }
        int update = userMapper.updateByPrimaryKey(user);
        return String.valueOf(update);
    }

    @GetMapping(value = "/user/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> select(){
        List<User> select = userMapper.findAll();
        return select;
    }
}
