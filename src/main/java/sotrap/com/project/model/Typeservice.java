package sotrap.com.project.model;

import lombok.AccessLevel;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Typeservice {
    @Id
    @GeneratedValue(generator = "type-uuid")
    @GenericGenerator(name = "type-uuid", strategy = "uuid2")
    private String id;

    private String Typeservice;



    @Setter(value = AccessLevel.NONE)
    @Basic(optional = false)
    @CreationTimestamp
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeservice() {
        return Typeservice;
    }

    public void setTypeservice(String typeservice) {
        Typeservice = typeservice;
    }
}
