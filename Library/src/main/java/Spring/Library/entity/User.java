package Spring.Library.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "user_role", referencedColumnName = "id", nullable = false)
    private Role role;

    @Column(nullable = false)
    private boolean deleted;

}
