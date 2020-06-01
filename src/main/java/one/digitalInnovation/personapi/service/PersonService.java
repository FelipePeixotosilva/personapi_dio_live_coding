package one.digitalInnovation.personapi.service;
import one.digitalInnovation.personapi.mapper.PersonMapper;
import one.digitalInnovation.personapi.dto.request.PersonDTO;
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
import lombok.AllArgsConstructor;
import one.digitalInnovation.personapi.dto.request.PersonDTO;
import one.digitalInnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalInnovation.personapi.entity.Person;
import one.digitalInnovation.personapi.mapper.PersonMapper;
import one.digitalInnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*Controlador que vai ser acessado atraves deuma api rest*/

@Service
public class PersonService {
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){

        this.personRepository=personRepository;

    }

    @PostMapping
    //Resquesty ele ta vindo requisição do tipo pessoa
    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .Message("Created person with ID" + savedPerson.getId())
                .build();

    }
    public List<PersonDTO> listAll(){
        List<Person> allPeople = personRepository.findAll();
        return  allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
