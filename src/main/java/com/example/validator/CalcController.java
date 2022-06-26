package com.example.validator;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcController {

  public CalcController() {
    System.out.println(">>>> CalcController 생성");
  }
  
  @GetMapping("/calc")
  public String calc() {
    
    return "/calc/form";
  }
  
  @PostMapping("/calc")
  public String calc(CalcVO calcVO,BindingResult result,Model model) {
    
    CalcValidator validator = new CalcValidator();
    //Errors 와 BindingResult 는 연결되있다? 둘다 에러처리다 
    validator.validate(calcVO, result);
    
    if(result.hasErrors()) {
      return "/calc/form";
      
    }else {
      int payment = calcVO.getPrice() * calcVO.getCount();
      model.addAttribute("payment",payment);
      return "/calc/proc";
    }
    
  }
  
  @GetMapping("/calc2")
  public String calc2() {
    
    return "/calc/form2";
  }
  
  @PostMapping("/calc2")
  public String calc2(CalcVO calcVO,BindingResult result,Model model) {
    CalcValidator validator = new CalcValidator();
    
    validator.validate(calcVO, result);
    Map<String, String> map = new HashMap<String,String>();//form 에 error 메시지를 저장
    
    
    if(result.hasErrors()) {
      if(result.getFieldError("menu")!=null) {
        map.put("menu","menu 등록이 누락되었습니다.");
      }
      if(result.getFieldError("price")!= null) {
        map.put("price","금액은 1000원 이상 천만원 이하여야합니다.");
      }
      if(result.getFieldError("count")!= null) {
        map.put("count","수량은 1개 이상 천개 이하여야합니다");
      }
      model.addAllAttributes(map);
      return "/calc/form2";
      
    }else {
      int payment = calcVO.getPrice() * calcVO.getCount();
      model.addAttribute("payment",payment);
      return "/calc/proc";
    }
  }
  
  @GetMapping("/calc3")
  public String calc3() {
    
    
    return "calc/form3";
  }
  @PostMapping("/calc3")
  public String calc3(@Valid CalcVOAnnotation calcVO,BindingResult result,Model model) {
    Map<String, String> map = new HashMap<String,String>();
    
    
    if(result.hasErrors()) {
      if(result.getFieldError("menu")!=null) {
        map.put("menu",result.getFieldError("menu").getDefaultMessage());
      }
      if(result.getFieldError("price")!= null) {
        map.put("price",result.getFieldError("price").getDefaultMessage());
      }
      if(result.getFieldError("count")!= null) {
        map.put("count",result.getFieldError("count").getDefaultMessage());
      }
      model.addAllAttributes(map);
      return "/calc/form3";
      
    }else {
      int payment = calcVO.getPrice() * calcVO.getCount();
      model.addAttribute("payment",payment);
      return "/calc/proc";
    }
  }
  
  
}
