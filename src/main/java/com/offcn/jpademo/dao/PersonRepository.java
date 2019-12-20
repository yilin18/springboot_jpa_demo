package com.offcn.jpademo.dao;

import com.offcn.jpademo.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/19
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByNameIs(String name);

    Person findByIdIsAndNameIs(Integer id, String name);

    List<Person> findByNameLike(String name);

    @Query("select p from Person p where p.name=:name")
    Person getPersonIs(@Param("name") String name);

    @Query("select p from Person p where p.name=?2 and p.id=?1")
    Person findPersonIdAndNameIs(@Param("id") Integer id, @Param("name") String name);

    @Query("select p from Person p where p.name like %:name%")
    List<Person> findPersonNameContains(@Param("name") String name);

    @Query(value = "select * from Person p where p.age> 18", nativeQuery = true)
    List<Person> findPersonAgeGreatThan18();
    @Query(value = "select * from Person p where p.age> ?", nativeQuery = true)
    List<Person> findPersonAgeGreatThan(@Param("age") Integer age);


}
