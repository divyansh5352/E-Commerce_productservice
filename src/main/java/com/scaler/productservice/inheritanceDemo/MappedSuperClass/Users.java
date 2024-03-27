//package com.scaler.productservice.inheritanceDemo.MappedSuperClass;
//
//import jakarta.persistence.Id;
//import jakarta.persistence.MappedSuperclass;
//import lombok.Getter;
//import lombok.Setter;
//
//
//// in mapped super class base class attributes are added to child class table
//// and table for base class is not created
//// We have to annotate base class with @MappedSuperClass and getter setter
//// We don't have to annotate it with @Entity because we don't want table for this class
//// Its child class will be annotated with @Getter @Setter and @Entity(name="desired name of table"(optional))
//
//@Getter
//@Setter
//@MappedSuperclass
//public class Users {
//    @Id
//    private Long Id;
//    private String name;
//    private String email;
//}
