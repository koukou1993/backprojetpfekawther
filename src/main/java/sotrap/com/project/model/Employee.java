package sotrap.com.project.model;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Size( max = 50)
    private String name;

    @NotBlank
    @Size( max = 50)
    private String username;


    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size( max = 50)
    private String phone;

    @NotBlank
    @Size( max = 250)
    private String password;


    @NotBlank
    @Size( max = 50)
    private String role;

    @ManyToOne(optional = false)
    @JoinColumn(name = "typeservice_id")
    private Typeservice typeservice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Typeservice getTypeservice() {
        return typeservice;
    }

    public void setTypeservice(Typeservice typeservice) {
        this.typeservice = typeservice;
    }
}


