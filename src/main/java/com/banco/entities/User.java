package com.banco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne
    private UserRole role;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column
    private String email;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column
    private String phoneNumber;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column
    private String username;
    @JsonIgnore
    @Column
    private String password;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column
    private Boolean locked;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column
    private Boolean emailConfirmed;
    @JsonIgnore
    @Column
    private String emailConfirmationCode;
    @JsonIgnore
    @Column
    private Timestamp emailConfirmationCodeExpiration;
    @JsonIgnore
    @Column
    private Byte reliability;
    @JsonIgnore
    @Column
    private String sign;
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    //@Column
    //private Long physicalPersonInfoId; //TODO
    @JsonIgnore
    @Column
    private String emailChangeCode;
    @JsonIgnore
    @Column
    private String passwordChangeCode;
    @JsonIgnore
    @Column
    private String transactionApproveCode;
    @JsonIgnore
    @Column
    private Short attempts;
    @JsonIgnore
    @Column
    private Date lastAttempt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column
    private Date creationDate;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> ga = new ArrayList<>();
        ga.add(new SimpleGrantedAuthority(this.role.getRoleName()));
        return ga;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(id, user.id)) return false;
        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(phoneNumber, user.phoneNumber)) return false;
        if (!Objects.equals(username, user.username)) return false;
        if (!Objects.equals(password, user.password)) return false;
        if (!Objects.equals(locked, user.locked)) return false;
        if (!Objects.equals(emailConfirmed, user.emailConfirmed))
            return false;
        if (!Objects.equals(emailConfirmationCode, user.emailConfirmationCode))
            return false;
        if (!Objects.equals(emailConfirmationCodeExpiration, user.emailConfirmationCodeExpiration))
            return false;
        if (!Objects.equals(reliability, user.reliability)) return false;
        if (!Objects.equals(sign, user.sign)) return false;
        //if (!Objects.equals(physicalPersonInfoId, user.physicalPersonInfoId))
          //  return false;
        if (!Objects.equals(emailChangeCode, user.emailChangeCode))
            return false;
        if (!Objects.equals(passwordChangeCode, user.passwordChangeCode))
            return false;
        return Objects.equals(transactionApproveCode, user.transactionApproveCode);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (locked != null ? locked.hashCode() : 0);
        result = 31 * result + (emailConfirmed != null ? emailConfirmed.hashCode() : 0);
        result = 31 * result + (emailConfirmationCode != null ? emailConfirmationCode.hashCode() : 0);
        result = 31 * result + (emailConfirmationCodeExpiration != null ? emailConfirmationCodeExpiration.hashCode() : 0);
        result = 31 * result + (reliability != null ? reliability.hashCode() : 0);
        result = 31 * result + (sign != null ? sign.hashCode() : 0);
       // result = 31 * result + (physicalPersonInfoId != null ? physicalPersonInfoId.hashCode() : 0);
        result = 31 * result + (emailChangeCode != null ? emailChangeCode.hashCode() : 0);
        result = 31 * result + (passwordChangeCode != null ? passwordChangeCode.hashCode() : 0);
        result = 31 * result + (transactionApproveCode != null ? transactionApproveCode.hashCode() : 0);
        return result;
    }
}
