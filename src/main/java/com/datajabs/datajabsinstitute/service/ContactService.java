package com.datajabs.datajabsinstitute.service;

import com.datajabs.datajabsinstitute.constants.EazySchoolConstants;
import com.datajabs.datajabsinstitute.model.Contact;
import com.datajabs.datajabsinstitute.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact) {

        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if (null!= savedContact && savedContact.getContactId()>0) {
            isSaved=true;
        }
        return isSaved;

    }


    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(EazySchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(EazySchoolConstants.CLOSE);

        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
