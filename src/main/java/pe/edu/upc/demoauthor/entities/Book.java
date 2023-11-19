package pe.edu.upc.demoauthor.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @Column(name = "nameBook",length = 40,nullable = false)
    private String nameBook;
    @Column(name = "publicationDateBook", nullable = false)
    private LocalDate publicationDateBook;
    @Column(name ="numberPages", nullable = false )
    private int numberPages;
    @ManyToOne
    @JoinColumn(name = "idAuthor")
    private Author author;

    public Book() {
    }

    public Book(int id, String nameBook, LocalDate publicationDateBook, int numberPages, Author author) {
        this.id = id;
        this.nameBook = nameBook;
        this.publicationDateBook = publicationDateBook;
        this.numberPages = numberPages;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int idBook) {
        this.id = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public LocalDate getPublicationDateBook() {
        return publicationDateBook;
    }

    public void setPublicationDateBook(LocalDate publicationDateBook) {
        this.publicationDateBook = publicationDateBook;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
