package com.banco.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "bancodelapeseta")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Basic
    @Column(name = "role_name")
    private String roleName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (!Objects.equals(id, userRole.id)) return false;
        if (!Objects.equals(roleName, userRole.roleName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
