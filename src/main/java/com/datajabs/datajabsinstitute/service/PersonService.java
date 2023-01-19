package com.datajabs.datajabsinstitute.service;

import com.datajabs.datajabsinstitute.constants.EazySchoolConstants;
import com.datajabs.datajabsinstitute.model.Person;
import com.datajabs.datajabsinstitute.model.Roles;
import com.datajabs.datajabsinstitute.repository.PersonRepository;
import com.datajabs.datajabsinstitute.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }

}
