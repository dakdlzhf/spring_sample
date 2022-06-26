package com.example.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sample.bean.Member;
//비동기통신을사용할떄 데이터를 받아와서 사용할때 즉 데이터를 리턴받고싶을때 ! == ResponseBody 와같아서 RestController 쓰면 생략가능
@Controller   
public class HelloController {
  
  @RequestMapping("/test1")
  public String test1(HttpServletRequest request,Model model) {
    String id = request.getParameter("id");
    String name =request.getParameter("name");
    
    model.addAttribute("id",id);
    model.addAttribute("name",name);
    
    return "test1";
  }
  
  @RequestMapping("/test2")
  public String test2(
      String id,
      String name,
      Model model) {
    //요청된 데이터 이름과 동일하면 받아지고 그파라미터를 다시 model 에 addAttribute 로 넣어준다  다만 파라미터가 많아지면 불편해 지는 단점이있다. 
    model.addAttribute("id",id);
    model.addAttribute("name", name);
    
    return "test2";
  }
  
  //javaBean setProperties 처럼 Momber 커맨드객체의 멤버필드에 param 이름과 동일하면 setter 가된다.
  @RequestMapping("/test3")
  public String test3(Member member, Model model) {
          // 파라미터와 일치하는 빈을 만들어서 사용할 수 있다.
          // View 페이지에서 model 을 사용하지 않고 member를 사용한다.
          
    
          //model.addAttribute("member",member) 로 내부적으로 저장된거고 생략 된거 뿐이다.
          return "test3";
  }
  
  //데이터를 한두개 작은양을 보낼때 사용하긴한다.
  @RequestMapping("/test4/{studentId}/{name}")
  public String getStrudent(@PathVariable String studentId,@PathVariable String name, Model model) {
    
    model.addAttribute("studentId",studentId);
    model.addAttribute("name",name);
    return "test4";
  }
  
  
  @GetMapping //get 방식으로 요청될때이고 경로를 설정하지않으면 root 경로가된다 == ("/")
  @ResponseBody //데이터를 리턴하겠다 는 뜻이다.
  public String hello() {
    
    return "hello world"; //<--문자열 데이터임
  }
  
  //ResponseBody 를 쓰지않으면 jsp 페이지를 리턴하겠다는 뜻이다.
  @GetMapping("/test")
  public String test() {
    
    return "test";
  }
  
}
