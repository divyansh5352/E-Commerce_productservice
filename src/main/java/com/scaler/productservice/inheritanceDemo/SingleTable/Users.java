//package com.scaler.productservice.inheritanceDemo.SingleTable;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//// Here we want only one table, so we will use @Inheritance strategy = SINGLE_TABLE
//// now since we have data of child class and parent class in one table
//// we will have to specify a column which will display the type of object
//// eg: parent , child-1 or child-2
//// to do this we will use an annotation @DiscriminatorColumn and provide column name and datatype
//// we can also specify the value for each object type in the discriminator column
//// to do this we will have to use another annotation @DiscriminatorValue and provide value for it
//// similarly provide value for child class also using the above annotation
//@Getter
//@Setter
//@Entity(name = "ST_Users")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "UserType" , discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorValue("0")
//public class Users {
//    @Id
//    private Long Id;
//    private String name;
//    private String email;
//}
