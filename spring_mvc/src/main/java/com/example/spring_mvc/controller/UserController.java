package com.example.spring_mvc.controller;

import com.example.spring_mvc.pojo.User;
import com.example.spring_mvc.service.UserService;
import com.example.spring_mvc.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService = null;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

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

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/add");
        return mv;
    }

    @PostMapping("/insert")
    @ResponseBody
    public User insert(@RequestBody User user) {
        userService.insertUser(user);
        return user;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User get(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/format/form")
    public ModelAndView showFormat() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/formatter");
        return mv;
    }

    @PostMapping("/format/commit")
    @ResponseBody
    public Map<String, Object> format(
            @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date date,
            @NumberFormat(pattern = "#,###.##") Double number) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("number", number);
        return dataMap;
    }

    @GetMapping("/converter")
    @ResponseBody
    public User getUserByConverter(User user) {
        return user;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<User> list(List<User> userList) {
        return userList;
    }

    @GetMapping("/validator")
    @ResponseBody
    public Map<String, Object> validator(@Valid User user, Errors errors, Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("date", date);
        if (errors.hasErrors()) {
            List<ObjectError> oes = errors.getAllErrors();
            for (ObjectError oe: oes) {
                if (oe instanceof FieldError) {
                    FieldError fe = (FieldError) oe;
                    map.put(fe.getObjectName(), fe.getDefaultMessage());
                }
            }
        }
        return map;
    }

    @GetMapping("/show")
    public String showUser(long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "data/user";
    }

    @GetMapping("/redirect1")
    public String redirect1(String userName, String note, RedirectAttributes ra){
//        User user = new User();
//        user.setNote(note);
//        user.setUserName(userName);
//        userService.insertUser(user);
//        return "redirect:/user/show?id=" + user.getId();
        User user = new User();
        user.setNote(note);
        user.setUserName(userName);
        userService.insertUser(user);
        ra.addFlashAttribute("user", user);
        return "redirect:/user/showUser";
    }

    @GetMapping("/redirect2")
    public ModelAndView redirect2(String userName, String note, RedirectAttributes ra) {
//        User user = new User();
//        user.setNote(note);
//        user.setUserName(userName);
//        userService.insertUser(user);
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("redirect:/user/show?id=" + user.getId());
//        return mv;
        User user = new User();
        user.setNote(note);
        user.setUserName(userName);
        userService.insertUser(user);
        ra.addFlashAttribute("user", user);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/user/showUser");
        return mv;
    }

    @RequestMapping("/showUser")
    public String showUser(User user, Model model) {
        System.out.println(user.getId());
        return "data/user";
    }
}