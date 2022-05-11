package Spring.Library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="editorial", indexes = {@Index(name="idx_name", columnList = "name")})
@Getter
@Setter
@NoArgsConstructor
public class Editorial {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private boolean high;

}
