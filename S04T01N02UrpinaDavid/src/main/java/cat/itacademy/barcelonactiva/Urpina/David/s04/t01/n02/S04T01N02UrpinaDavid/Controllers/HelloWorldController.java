package cat.itacademy.barcelonactiva.Urpina.David.s04.t01.n02.S04T01N02UrpinaDavid.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    //http://localhost:9001/HelloWorld
    //http://localhost:9001/HelloWorld?name=El meu nom

    @GetMapping("/HelloWorld")
    public String greetings(@RequestParam(defaultValue = "UKNOWN") String name){
        return "Hi, " + name + ". You're executing a Gradle project.";
    }

    //http://localhost:9001/HelloWorld2
    //http://localhost:9001/HelloWorld2/el meu nom

    @GetMapping({"/HelloWorld2", "/HelloWorld2/{name}"})
    public String greetings2(@PathVariable (required = false) String name){
        if(name == null){
            name = "UKNOWN";
        }
        return "Hi, " + name + ". You're executing a Gradle project.";
    }
}
