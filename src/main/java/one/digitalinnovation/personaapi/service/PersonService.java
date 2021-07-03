package one.digitalinnovation.personaapi.service;

import one.digitalinnovation.personaapi.dto.MessageResponseDTO;
import one.digitalinnovation.personaapi.entity.Person;
import one.digitalinnovation.personaapi.repository.PersonReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private final PersonReporsitory personReporsitory;

    @Autowired
    public PersonService(PersonReporsitory personReporsitory){
        this.personReporsitory = personReporsitory;
    }


    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person savePerson = personReporsitory.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savePerson.getId())
                .build();
    }
}
