package com.spring.hibernate.mappings_demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "youtube_channel")
    private String youTubeChannel;

    @Column(name = "hobby")
    private String hobby;

    /*
     This instructor method is added here because we need to have the bi directional
     mapping. That is when we are loading the InstructorDetail from the database, we
     need to fetch the associated instructor. In order to achieve this we need to define instructor
     attribute here with @OneToOne annotation with mappedBy property, thus this mappedBy property helps
     hibernate to go to Instructor model and find more details from the how to map the instructor to
     InstructorDetail by looking at annotations like @JoinColumn.
     */
    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private Instructor instructor;

    public InstructorDetail(){
        // This default arg constructor is required by hibernate.
    }

    public InstructorDetail(String youTubeChannel, String hobby) {
        this.youTubeChannel = youTubeChannel;
        this.hobby = hobby;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYouTubeChannel() {
        return youTubeChannel;
    }

    public void setYouTubeChannel(String youTubeChannel) {
        this.youTubeChannel = youTubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /*

    Add getters and setters for the newly introduced variable instructor which will be used to
    create the Bi-Directional relationship.

     */

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youTubeChannel='" + youTubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
