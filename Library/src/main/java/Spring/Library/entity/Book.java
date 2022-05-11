package Spring.Library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.Year;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="book", indexes = {@Index(name="idx_isbn", columnList = "isbn")})
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String isbn;

    @Column(nullable=false)
    private String titulo;

    @Column(columnDefinition = "YEAR",nullable=false)
    private Year year;

    @Column(nullable=false)
    private Integer ejemplares;

    @Column(nullable=false)
    private Integer ejemplaresPrestados;

    @Column(nullable=false)
    private Integer ejemplaresRestantes;

    @Column(nullable=false)
    private boolean high;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private Author author;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "editorial_id", referencedColumnName = "id", nullable = false)
    private Editorial editorial;
}
