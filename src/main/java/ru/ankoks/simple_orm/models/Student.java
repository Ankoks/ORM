package ru.ankoks.simple_orm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id", foreignKey = @ForeignKey(name = "fk_student_avatar_id"))
    private Avatar avatar;

    @OneToMany
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "fk_email_student_id"))
    private List<EMail> emails;

    @ManyToMany
    @JoinTable(
            name = "student_cource",
            joinColumns = @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "fk_student_course_student_id")),
            inverseJoinColumns = @JoinColumn(name = "cource_id", foreignKey = @ForeignKey(name = "fk_student_course_course_id"))
    )
    private List<Course> courses;
}
