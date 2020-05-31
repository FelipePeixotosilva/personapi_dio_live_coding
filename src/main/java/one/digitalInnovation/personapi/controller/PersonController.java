package one.digitalInnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*Controlador que vai ser acessado atraves deuma api rest*/
@RestController
//caminho de acesso prinicipal da api Nivel 1
@RequestMapping("/api/v1/people")
public class PersonController {
    //Operacao de http do tipo Get
    @GetMapping
    public String getBook(){
        return "API Test";
    }
}
