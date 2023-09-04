/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unipiloto.edu.co.entidad;

import jakarta.xml.bind.annotation.XmlElement;

/**
 *
 * @author juane
 */
//@jakarta.xml.bind.annotation.XmlRootElement (name = "Persona")
//@jakarta.xml.bind.annotation.XmlType(propOrder = {"id","fullName","age"})
public class Persona{
    
    public Persona(){
    
    }
    
    private int id;
    private String fullName;
    private int age;
    private int salary;
    
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @XmlElement
    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
}
