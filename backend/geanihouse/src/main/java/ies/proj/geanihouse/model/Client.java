package ies.proj.geanihouse.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;

@Entity
@Table(name = "Client")
public class Client {


    //Change this to use the user
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false,length=50)
    private String firstName;

    @Column(name = "last_name", nullable = false,length=50)
    private String lastName;

    @Column(name = "email", nullable = false,length=320)
    private String email;

    @Column(name = "sex" ,length=10)
    private String sex;

    @Column(name = "birth")
    private java.sql.Date birth;

    @Lob
    @Column(name="profilepic")
    private byte[] profilepic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Client(long id,String firstName, String lastName, String email, java.sql.Date birth, String sex) {
        this.id = id;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birth=birth;
        this.sex=sex;
    }

    public java.sql.Date getStartDate() {
        return birth;
    }

    public void setStartDate(java.sql.Date birth) {
        this.birth = birth;
    }

    private void setSex( String sex){
        this.sex=sex;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPic(){
        return this.profilepic;
    }
    public void setPic(byte[] pic){
        this.profilepic = pic;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + email
                + "]";
    }


}