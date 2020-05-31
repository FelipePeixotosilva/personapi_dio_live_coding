package one.digitalInnovation.personapi.service;


import one.digitalInnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalInnovation.personapi.entity.Person;
import one.digitalInnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

/*Controlador que vai ser acessado atraves deuma api rest*/
@RestController
//caminho de acesso prinicipal da api Nivel 1
@RequestMapping("/api/v1/people")
public class PersonService {
    private PersonService personService;
    //Operacao de http do tipo Get
    //@GetMapping
    /*
     * Teste Unitario
     * */
    @Autowired
    public PersonService(PersonRepository personRepository){

        this.personService=personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //Resquesty ele ta vindo requisição do tipo pessoa
    public MessageResponseDTO createPerson(@RequestBody Person person){
    return personService.createPerson(person);
    }
}
