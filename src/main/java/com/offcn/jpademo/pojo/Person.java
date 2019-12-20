package com.offcn.jpademo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/19
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name", nullable = true, length = 20)
    private String name;
    @Column(name = "age", nullable = true, length = 4)
    private Integer age;
}
