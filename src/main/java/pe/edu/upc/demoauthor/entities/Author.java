package pe.edu.upc.demoauthor.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nameAuthor",length = 45,nullable = false)
    private String nameAuthor;
    @Column(name = "emailAuthor",length = 45,nullable = false)
    private  String emailAuthor;
     @Column(name = "birthDateAuthor")
    private LocalDate birthDateAuthor;

    public Author() {
    }

    public Author(int id, String nameAuthor, String emailAuthor, LocalDate birthDateAuthor) {
        this.id = id;
        this.nameAuthor = nameAuthor;
        this.emailAuthor = emailAuthor;
        this.birthDateAuthor = birthDateAuthor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getEmailAuthor() {
        return emailAuthor;
    }

    public void setEmailAuthor(String emailAuthor) {
        this.emailAuthor = emailAuthor;
    }

    public LocalDate getBirthDateAuthor() {
        return birthDateAuthor;
    }

    public void setBirthDateAuthor(LocalDate birthDateAuthor) {
        this.birthDateAuthor = birthDateAuthor;
    }
}
