package com.example.spring_mvc.controller;

import com.example.spring_mvc.pojo.ValidatorPojo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/my")
@Controller
public class MyController {
    @GetMapping("/no/annotation")
    @ResponseBody
    public Map<String, Object> noAnnotation(Integer intVal, Long longVal, String str) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("longVal", longVal);
        paramsMap.put("str", str);
        return paramsMap;
    }

    @GetMapping("/annotation")
    @ResponseBody
    public Map<String, Object> requestParam(
            @RequestParam("int_val") Integer intVal,
            @RequestParam("long_val") Long longVal,
            @RequestParam("str_val") String strVal) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("intVal", intVal);
        paramsMap.put("longVal", longVal);
        paramsMap.put("strVal", strVal);
        return paramsMap;
    }

    @GetMapping("/requestArray")
    @ResponseBody
    public Map<String, Object> requestArray(int[] intArr, Long[] longArr, String[] strArr){
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("intArr", intArr);
        paramsMap.put("longArr", longArr);
        paramsMap.put("strArr", strArr);
        return paramsMap;
    }

    @RequestMapping(value = "/valid/validate")
    @ResponseBody
    public Map<String, Object> validate(@Valid @RequestBody ValidatorPojo vp, Errors errors) {
        Map<String, Object> errMap = new HashMap<>();
        List<ObjectError> oes = errors.getAllErrors();
        for (ObjectError oe: oes) {
            String key = null;
            String msg = null;
            if(oe instanceof FieldError) {
                FieldError fe = (FieldError) oe;
                key = fe.getField();
            } else {
                key = oe.getObjectName();
            }
            msg = oe.getDefaultMessage();
            errMap.put(key, msg);
        }
        return errMap;
    }

    @GetMapping("/valid/page")
    public ModelAndView validPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("validator/pojo");
        return mv;
    }
}
