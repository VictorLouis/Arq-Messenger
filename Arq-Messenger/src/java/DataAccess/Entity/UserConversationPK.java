/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author carlos
 */
@Embeddable
public class UserConversationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IdUser")
    private int idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdConversation")
    private int idConversation;

    public UserConversationPK() {
    }

    public UserConversationPK(int idUser, int idConversation) {
        this.idUser = idUser;
        this.idConversation = idConversation;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdConversation() {
        return idConversation;
    }

    public void setIdConversation(int idConversation) {
        this.idConversation = idConversation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idConversation;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserConversationPK)) {
            return false;
        }
        UserConversationPK other = (UserConversationPK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idConversation != other.idConversation) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.UserConversationPK[ idUser=" + idUser + ", idConversation=" + idConversation + " ]";
    }
    
}
