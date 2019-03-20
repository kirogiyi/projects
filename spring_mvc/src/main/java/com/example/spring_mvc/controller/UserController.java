package com.example.spring_mvc.controller;

import com.example.spring_mvc.pojo.User;
import com.example.spring_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService = null;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public User insertUser(String userName, String note) {
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);
        userService.insertUser(user);
        return user;
    }

    @RequestMapping("/findUsers")
    @ResponseBody
    public List<User> findUsers(String userName, String note) {
        return userService.findUsers(userName, note);
    }

    @RequestMapping("/updateUserName")
    @ResponseBody
    public Map<String, Object> updateUserName(Long id, String userName) {
        User user = userService.updateUserName(id, userName);
        boolean flag = user != null;
        String message = flag? "更新成功":"更新失败";
        return resultMap(flag, message);
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Map<String, Object> deleteUser(Long id) {
        int result = userService.deleteUser(id);
        boolean flag = result == 1;
        String message = flag? "删除成功":"删除失败";
        return resultMap(flag, message);
    }

    private Map<String, Object> resultMap(boolean success, String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        result.put("message", message);
        return result;
    }

    @RequestMapping ("/details")
    public ModelAndView details(Long id){
        User user=userService.getUser(id);
        ModelAndView mv= new ModelAndView();
        mv.setViewName("user/details");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/detailsForJson")
    public ModelAndView detailsForJson(Long id) {
        User user = userService.getUser(id);
        ModelAndView mv = new ModelAndView();
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        mv.setView(jsonView);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/table")
    public ModelAndView table() {
        List<User> userList = userService.findUsers(null, null);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/table");
        mv.addObject("userList", userList);
        return mv;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<User> list(
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "note", required = false) String note) {
        List<User> userList = userService.findUsers(userName, note);
        return userList;
    }
}