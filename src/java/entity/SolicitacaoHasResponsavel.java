/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Casa
 */
@Entity
@Table(name = "solicitacao_has_responsavel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitacaoHasResponsavel.findAll", query = "SELECT s FROM SolicitacaoHasResponsavel s")
    , @NamedQuery(name = "SolicitacaoHasResponsavel.findByIdSolicitacao", query = "SELECT s FROM SolicitacaoHasResponsavel s WHERE s.solicitacaoHasResponsavelPK.idSolicitacao = :idSolicitacao")
    , @NamedQuery(name = "SolicitacaoHasResponsavel.findByIdResponsavel", query = "SELECT s FROM SolicitacaoHasResponsavel s WHERE s.solicitacaoHasResponsavelPK.idResponsavel = :idResponsavel")
    , @NamedQuery(name = "SolicitacaoHasResponsavel.findByData", query = "SELECT s FROM SolicitacaoHasResponsavel s WHERE s.data = :data")})
public class SolicitacaoHasResponsavel implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolicitacaoHasResponsavelPK solicitacaoHasResponsavelPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "id_responsavel", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Responsavel responsavel;
    @JoinColumn(name = "id_solicitacao", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Solicitacao solicitacao;

    public SolicitacaoHasResponsavel() {
    }

    public SolicitacaoHasResponsavel(SolicitacaoHasResponsavelPK solicitacaoHasResponsavelPK) {
        this.solicitacaoHasResponsavelPK = solicitacaoHasResponsavelPK;
    }

    public SolicitacaoHasResponsavel(SolicitacaoHasResponsavelPK solicitacaoHasResponsavelPK, Date data) {
        this.solicitacaoHasResponsavelPK = solicitacaoHasResponsavelPK;
        this.data = data;
    }

    public SolicitacaoHasResponsavel(int idSolicitacao, int idResponsavel) {
        this.solicitacaoHasResponsavelPK = new SolicitacaoHasResponsavelPK(idSolicitacao, idResponsavel);
    }

    public SolicitacaoHasResponsavelPK getSolicitacaoHasResponsavelPK() {
        return solicitacaoHasResponsavelPK;
    }

    public void setSolicitacaoHasResponsavelPK(SolicitacaoHasResponsavelPK solicitacaoHasResponsavelPK) {
        this.solicitacaoHasResponsavelPK = solicitacaoHasResponsavelPK;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitacaoHasResponsavelPK != null ? solicitacaoHasResponsavelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitacaoHasResponsavel)) {
            return false;
        }
        SolicitacaoHasResponsavel other = (SolicitacaoHasResponsavel) object;
        if ((this.solicitacaoHasResponsavelPK == null && other.solicitacaoHasResponsavelPK != null) || (this.solicitacaoHasResponsavelPK != null && !this.solicitacaoHasResponsavelPK.equals(other.solicitacaoHasResponsavelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SolicitacaoHasResponsavel[ solicitacaoHasResponsavelPK=" + solicitacaoHasResponsavelPK + " ]";
    }
    
}
