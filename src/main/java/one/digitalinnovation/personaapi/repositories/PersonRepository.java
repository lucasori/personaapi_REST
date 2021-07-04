package one.digitalinnovation.personaapi.repositories;

import one.digitalinnovation.personaapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
