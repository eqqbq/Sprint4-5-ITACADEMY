package cat.itacademy.barcelonactiva.Urpina.David.s04.t01.n01.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static final String UNKNOWN_NAME = "UKNOWN";

    @GetMapping("/hello-world")
    public String greetings(@RequestParam(defaultValue =  UNKNOWN_NAME) String name){
        return "Hello, " + name + ". You're executing a Maven project.";
    }

    @GetMapping({"/hello-world2", "/hello-world2/{name}"})
    public String greetings2(@PathVariable (required = false) String name ){
        if (name == null){
            name = UNKNOWN_NAME;
        }
        return "Hello, " + name + ". You're executing a Maven project.";
    }
}
