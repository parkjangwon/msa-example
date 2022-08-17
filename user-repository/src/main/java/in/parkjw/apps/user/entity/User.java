package in.parkjw.apps.user.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "MSA_USER")
public class User implements in.parkjw.apps.core.entity.Entity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    Long id;

    @NotNull
    @NotEmpty
    @Column(name = "email", length = 255)
    String email;

    @NotNull
    @NotEmpty
    @Column(name = "password", length = 255)
    String password;

    @NotNull
    @NotEmpty
    @Column(name = "name", length = 255)
    String name;

    @Builder.Default
    @Column(name = "isActive", columnDefinition="BOOLEAN DEFAULT false", nullable = false)
    Boolean isActive = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;
        return id.equals(user.id);
    }
}
