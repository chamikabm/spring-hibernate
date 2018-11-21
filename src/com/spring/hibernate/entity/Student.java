package com.spring.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    /**
     *
     * Hibernate, and code in general that creates objects via reflection use Class<T>.newInstance()
     * to create a new instance of your classes. This method requires a public no-arg constructor
     * to be able to instantiate the object. For most use cases, providing a no-arg constructor
     * is not a problem.
     *
     * There are hacks based on serialization that can work around not having a no-arg constructor,
     * since serialization uses jvm magic to create objects without invoking the constructor.
     * But this is not available across all VMs. For example, XStream can create instances of
     * objects that don't have a public no-arg constructor, but only by running in a so-called "enhanced"
     * mode which is available only on certain VMs. (See the link for details.) Hibernate's designers
     * surely chose to maintain compatibility with all VMs and so avoids such tricks, and uses
     * the officially supported reflection method Class<T>.newInstance() requiring a no-arg constructor.
     *
     */
    public Student() {
        // Do nothing as this required to defined for the hibernate.
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
