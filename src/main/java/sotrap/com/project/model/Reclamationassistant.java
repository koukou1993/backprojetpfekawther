package sotrap.com.project.model;

import lombok.AccessLevel;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "ReclamationAssistant")
public class Reclamationassistant {

    @Id
    @GeneratedValue(generator = "type-uuid")
    @GenericGenerator(name = "type-uuid", strategy = "uuid2")
    private String id;



    private String numbonlivraison;

    private String description;
    private String piecejoint;
    private String etat;
    private String priorite;

    @Setter(value = AccessLevel.NONE)
    @Basic(optional = false)
    @CreationTimestamp
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @Setter(value = AccessLevel.NONE)
    @UpdateTimestamp
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt = new Date();

    @ManyToOne(optional = false)
    @JoinColumn(name = "objetreclamation_id")
    private ObjetReclamation objetreclamation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public ObjetReclamation getObjetreclamation() {
        return objetreclamation;
    }

    public void setObjetreclamation(ObjetReclamation objetreclamation) {
        this.objetreclamation = objetreclamation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getPiecejoint() {
        return piecejoint;
    }

    public void setPiecejoint(String piecejoint) {
        this.piecejoint = piecejoint;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getNumbonlivraison() {
        return numbonlivraison;
    }

    public void setNumbonlivraison(String numbonlivraison) {
        this.numbonlivraison = numbonlivraison;
    }
}
