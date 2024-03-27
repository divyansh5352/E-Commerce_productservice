package com.scaler.productservice.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//This class will be serving rest (HTTP) APIs

// this class will be having multiple methods
// that will be serving HTTP requests at /hello
@RestController
@RequestMapping("/hello")
public class HelloController {

    //when u put something in curly braces it becomes a variables
    @GetMapping("/say/{name}/{times}")
    public String sayHello(@PathVariable("name") String name,@PathVariable("times") int times  ){
        String ans = "";
        for (int i = 1 ; i <= times ; i++ ){
            ans += " HELLO "+name;
            ans += "</br>";
        }
        return ans;
    }
}
