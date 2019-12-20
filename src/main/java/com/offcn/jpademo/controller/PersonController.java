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
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("person")
    public void save(@RequestBody Person person) {
        System.out.println("本地分支");
        System.out.println("远程分支");
        System.out.println("远程改变");
        personRepository.save(person);
    }

    @DeleteMapping("person/{id}")
    public void delete(@PathVariable Integer id) {
        personRepository.deleteById(id);
    }

    @PutMapping("person")
    public void update(@RequestBody Person person) {
        personRepository.saveAndFlush(person);
    }

    @GetMapping("person/{id}")
    public Person findById(@PathVariable Integer id) {
        return personRepository.findById(id).get();
    }

    @GetMapping("person")
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @GetMapping("nameLike")
    public List<Person> nameLike(String name) {
        return personRepository.findByNameLike("%" + name + "%");
    }

    @GetMapping("nameIs")
    public Person nameIs(String name) {
        return personRepository.findByNameIs(name);
    }

    @GetMapping("IdIsAndNameIs")
    public Person IdIsAndNameIs(Integer id,String name) {
        return personRepository.findByIdIsAndNameIs(id,name);
    }
}
