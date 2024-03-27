//package com.scaler.productservice.inheritanceDemo.TablePerClass;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Inheritance;
//import jakarta.persistence.InheritanceType;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.tool.schema.spi.SchemaTruncator;
//import org.springframework.boot.autoconfigure.web.WebProperties;
//
////In table per class we want table of each class including table for parent class
////in this each attribute of parent class will be present in the child table also
////So we annotate parent class also with @Entity
////Since we want table for each class we have to specify it using an annotation
//// @Inheritance and specify the strategy we want eg:  TABLE_PE_CLASS , SINGLE_TABLE , JOINED
//// Its child class will have 3 annotation @Getter , @Setter , @Entity
//@Getter
//@Setter
//@Entity(name = "TPC_Users")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//public class Users {
//    @jakarta.persistence.Id
//    private Long Id;
//    private String name;
//    private String email;
//}
