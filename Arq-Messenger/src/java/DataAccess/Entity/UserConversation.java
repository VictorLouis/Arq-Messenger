/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "UserConversation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserConversation.findAll", query = "SELECT u FROM UserConversation u")
    , @NamedQuery(name = "UserConversation.findByIdUser", query = "SELECT u FROM UserConversation u WHERE u.userConversationPK.idUser = :idUser")
    , @NamedQuery(name = "UserConversation.findByIdConversation", query = "SELECT u FROM UserConversation u WHERE u.userConversationPK.idConversation = :idConversation")
    , @NamedQuery(name = "UserConversation.findByNombreConversacion", query = "SELECT u FROM UserConversation u WHERE u.nombreConversacion = :nombreConversacion")})
public class UserConversation implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserConversationPK userConversationPK;
    @Size(max = 45)
    @Column(name = "NombreConversacion")
    private String nombreConversacion;
    @JoinColumn(name = "IdUser", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "IdConversation", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Conversation conversation;

    public UserConversation() {
    }

    public UserConversation(UserConversationPK userConversationPK) {
        this.userConversationPK = userConversationPK;
    }

    public UserConversation(int idUser, int idConversation) {
        this.userConversationPK = new UserConversationPK(idUser, idConversation);
    }

    public UserConversationPK getUserConversationPK() {
        return userConversationPK;
    }

    public void setUserConversationPK(UserConversationPK userConversationPK) {
        this.userConversationPK = userConversationPK;
    }

    public String getNombreConversacion() {
        return nombreConversacion;
    }

    public void setNombreConversacion(String nombreConversacion) {
        this.nombreConversacion = nombreConversacion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userConversationPK != null ? userConversationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserConversation)) {
            return false;
        }
        UserConversation other = (UserConversation) object;
        if ((this.userConversationPK == null && other.userConversationPK != null) || (this.userConversationPK != null && !this.userConversationPK.equals(other.userConversationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.UserConversation[ userConversationPK=" + userConversationPK + " ]";
    }

    
}
