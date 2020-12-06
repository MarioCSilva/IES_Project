package ies.proj.geanihouse.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false,length=50)
    private String name;

    @OneToMany(mappedBy="type")
    private Set<Sensor> sensors;

    public Type(){

    }
    public Type(long id,String name){
        this.id = id;
        this.name = name;
    }

    public long getId(){
        return this.id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Set<Sensor> getSensors(){
        return this.sensors;
    }

    public String toString(){
        return "Type: "+this.name;
    }


}
