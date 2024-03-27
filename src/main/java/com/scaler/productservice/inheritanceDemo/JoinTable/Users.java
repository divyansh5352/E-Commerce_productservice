//package com.scaler.productservice.inheritanceDemo.JoinTable;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Inheritance;
//import jakarta.persistence.InheritanceType;
//import lombok.Getter;
//import lombok.Setter;
//
//// Here we want make joined table, so we will use @Inheritance strategy = JOINED
//// Attributes of parent class will be present in parent table only
//// and child table will contain only child class attributes,
//// but we will have to join these parent class with child to make a joined table
//// to join these two table we will have to use a foreign key
//
////Primary key of parent table will be foreign key in child table
//// to do this we use an annotation in child class called @PrimaryKeyJoinColumn(name = "user_Id")
//// here we just specify the custom name of foreign key column
//@Getter
//@Setter
//@Entity(name = "JT_Users")
//@Inheritance(strategy = InheritanceType.JOINED)
//public class Users {
//    @Id
//    private Long Id;
//    private String name;
//    private String email;
//}
