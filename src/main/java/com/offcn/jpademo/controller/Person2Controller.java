package com.offcn.jpademo.controller;

import com.offcn.jpademo.dao.PersonRepository;
import com.offcn.jpademo.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/19
 */
@RestController
@RequestMapping("person2")
public class Person2Controller {
    /*自定义JPQL语句*/
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("getPersonIs")
    public Person getPersonIs(String name) {
        return personRepository.getPersonIs(name);
    }

    @GetMapping("findPersonNameContains")
    public List<Person> findPersonNameContains(String name) {
        return personRepository.findPersonNameContains(name);
    }

    @GetMapping("findPersonIdAndNameIs")
    public Person findPersonIdAndNameIs(Integer id, String name) {
        return personRepository.findPersonIdAndNameIs(id, name);
    }

    @GetMapping("findPersonAgeGreatThan18")
    public List<Person> findPersonAgeGreatThan18() {
        return personRepository.findPersonAgeGreatThan18();
    }
    @GetMapping("findPersonAgeGreatThan")
    public List<Person> findPersonAgeGreatThan18(Integer age) {
        return personRepository.findPersonAgeGreatThan(age);
    }

}
