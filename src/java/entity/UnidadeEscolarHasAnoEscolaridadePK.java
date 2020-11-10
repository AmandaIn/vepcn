/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Casa
 */
@Embeddable
public class UnidadeEscolarHasAnoEscolaridadePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "unidade_escolar_id")
    private int unidadeEscolarId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano_escolaridade_id")
    private int anoEscolaridadeId;

    public UnidadeEscolarHasAnoEscolaridadePK() {
    }

    public UnidadeEscolarHasAnoEscolaridadePK(int unidadeEscolarId, int anoEscolaridadeId) {
        this.unidadeEscolarId = unidadeEscolarId;
        this.anoEscolaridadeId = anoEscolaridadeId;
    }

    public int getUnidadeEscolarId() {
        return unidadeEscolarId;
    }

    public void setUnidadeEscolarId(int unidadeEscolarId) {
        this.unidadeEscolarId = unidadeEscolarId;
    }

    public int getAnoEscolaridadeId() {
        return anoEscolaridadeId;
    }

    public void setAnoEscolaridadeId(int anoEscolaridadeId) {
        this.anoEscolaridadeId = anoEscolaridadeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) unidadeEscolarId;
        hash += (int) anoEscolaridadeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadeEscolarHasAnoEscolaridadePK)) {
            return false;
        }
        UnidadeEscolarHasAnoEscolaridadePK other = (UnidadeEscolarHasAnoEscolaridadePK) object;
        if (this.unidadeEscolarId != other.unidadeEscolarId) {
            return false;
        }
        if (this.anoEscolaridadeId != other.anoEscolaridadeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UnidadeEscolarHasAnoEscolaridadePK[ unidadeEscolarId=" + unidadeEscolarId + ", anoEscolaridadeId=" + anoEscolaridadeId + " ]";
    }
    
}
