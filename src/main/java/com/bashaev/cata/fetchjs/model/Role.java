package com.bashaev.cata.fetchjs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Рустам
 */

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Setter
@Getter
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
