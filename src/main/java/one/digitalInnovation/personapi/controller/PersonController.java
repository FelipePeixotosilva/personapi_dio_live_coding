package one.digitalInnovation.personapi.controller;

import one.digitalInnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalInnovation.personapi.entity.Person;
import one.digitalInnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*Controlador que vai ser acessado atraves deuma api rest*/
@RestController
//caminho de acesso prinicipal da api Nivel 1
@RequestMapping("/api/v1/people")
public class PersonController {

    //Operacao de http do tipo Get
    //@GetMapping
    /*
    * Teste Unitario
    * */
    @Autowired
    private PersonRepository personRepository;{
        this.personRepository = personRepository;
    }

    @PostMapping
    //Resquesty ele ta vindo requisição do tipo pessoa
    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
    }
}
