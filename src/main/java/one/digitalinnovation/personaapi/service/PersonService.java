package one.digitalinnovation.personaapi.service;

import one.digitalinnovation.personaapi.dto.MessageResponseDTO;
import one.digitalinnovation.personaapi.dto.resquest.PersonDTO;
import one.digitalinnovation.personaapi.entity.Person;
import one.digitalinnovation.personaapi.mapper.PersonMapper;
import one.digitalinnovation.personaapi.repository.PersonReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private final PersonReporsitory personReporsitory;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonReporsitory personReporsitory){
        this.personReporsitory = personReporsitory;
    }


    public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savePerson = personReporsitory.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created personDTO with ID " + savePerson.getId())
                .build();
    }
}
