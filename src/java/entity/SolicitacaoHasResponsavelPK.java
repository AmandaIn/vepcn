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
public class SolicitacaoHasResponsavelPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_solicitacao")
    private int idSolicitacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_responsavel")
    private int idResponsavel;

    public SolicitacaoHasResponsavelPK() {
    }

    public SolicitacaoHasResponsavelPK(int idSolicitacao, int idResponsavel) {
        this.idSolicitacao = idSolicitacao;
        this.idResponsavel = idResponsavel;
    }

    public int getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(int idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSolicitacao;
        hash += (int) idResponsavel;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitacaoHasResponsavelPK)) {
            return false;
        }
        SolicitacaoHasResponsavelPK other = (SolicitacaoHasResponsavelPK) object;
        if (this.idSolicitacao != other.idSolicitacao) {
            return false;
        }
        if (this.idResponsavel != other.idResponsavel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SolicitacaoHasResponsavelPK[ idSolicitacao=" + idSolicitacao + ", idResponsavel=" + idResponsavel + " ]";
    }
    
}
