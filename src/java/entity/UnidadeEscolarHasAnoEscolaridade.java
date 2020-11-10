/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Casa
 */
@Entity
@Table(name = "unidade_escolar_has_ano_escolaridade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadeEscolarHasAnoEscolaridade.findAll", query = "SELECT u FROM UnidadeEscolarHasAnoEscolaridade u")
    , @NamedQuery(name = "UnidadeEscolarHasAnoEscolaridade.findByUnidadeEscolarId", query = "SELECT u FROM UnidadeEscolarHasAnoEscolaridade u WHERE u.unidadeEscolarHasAnoEscolaridadePK.unidadeEscolarId = :unidadeEscolarId")
    , @NamedQuery(name = "UnidadeEscolarHasAnoEscolaridade.findByAnoEscolaridadeId", query = "SELECT u FROM UnidadeEscolarHasAnoEscolaridade u WHERE u.unidadeEscolarHasAnoEscolaridadePK.anoEscolaridadeId = :anoEscolaridadeId")
    , @NamedQuery(name = "UnidadeEscolarHasAnoEscolaridade.findByNumVagas", query = "SELECT u FROM UnidadeEscolarHasAnoEscolaridade u WHERE u.numVagas = :numVagas")
    , @NamedQuery(name = "UnidadeEscolarHasAnoEscolaridade.findByData", query = "SELECT u FROM UnidadeEscolarHasAnoEscolaridade u WHERE u.data = :data")})
public class UnidadeEscolarHasAnoEscolaridade implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UnidadeEscolarHasAnoEscolaridadePK unidadeEscolarHasAnoEscolaridadePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_vagas")
    private int numVagas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeEscolarHasAnoEscolaridade")
    private Collection<Solicitacao> solicitacaoCollection;
    @JoinColumn(name = "ano_escolaridade_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AnoEscolaridade anoEscolaridade;
    @JoinColumn(name = "unidade_escolar_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UnidadeEscolar unidadeEscolar;

    public UnidadeEscolarHasAnoEscolaridade() {
    }

    public UnidadeEscolarHasAnoEscolaridade(UnidadeEscolarHasAnoEscolaridadePK unidadeEscolarHasAnoEscolaridadePK) {
        this.unidadeEscolarHasAnoEscolaridadePK = unidadeEscolarHasAnoEscolaridadePK;
    }

    public UnidadeEscolarHasAnoEscolaridade(UnidadeEscolarHasAnoEscolaridadePK unidadeEscolarHasAnoEscolaridadePK, int numVagas, Date data) {
        this.unidadeEscolarHasAnoEscolaridadePK = unidadeEscolarHasAnoEscolaridadePK;
        this.numVagas = numVagas;
        this.data = data;
    }

    public UnidadeEscolarHasAnoEscolaridade(int unidadeEscolarId, int anoEscolaridadeId) {
        this.unidadeEscolarHasAnoEscolaridadePK = new UnidadeEscolarHasAnoEscolaridadePK(unidadeEscolarId, anoEscolaridadeId);
    }

    public UnidadeEscolarHasAnoEscolaridadePK getUnidadeEscolarHasAnoEscolaridadePK() {
        return unidadeEscolarHasAnoEscolaridadePK;
    }

    public void setUnidadeEscolarHasAnoEscolaridadePK(UnidadeEscolarHasAnoEscolaridadePK unidadeEscolarHasAnoEscolaridadePK) {
        this.unidadeEscolarHasAnoEscolaridadePK = unidadeEscolarHasAnoEscolaridadePK;
    }

    public int getNumVagas() {
        return numVagas;
    }

    public void setNumVagas(int numVagas) {
        this.numVagas = numVagas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @XmlTransient
    public Collection<Solicitacao> getSolicitacaoCollection() {
        return solicitacaoCollection;
    }

    public void setSolicitacaoCollection(Collection<Solicitacao> solicitacaoCollection) {
        this.solicitacaoCollection = solicitacaoCollection;
    }

    public AnoEscolaridade getAnoEscolaridade() {
        return anoEscolaridade;
    }

    public void setAnoEscolaridade(AnoEscolaridade anoEscolaridade) {
        this.anoEscolaridade = anoEscolaridade;
    }

    public UnidadeEscolar getUnidadeEscolar() {
        return unidadeEscolar;
    }

    public void setUnidadeEscolar(UnidadeEscolar unidadeEscolar) {
        this.unidadeEscolar = unidadeEscolar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidadeEscolarHasAnoEscolaridadePK != null ? unidadeEscolarHasAnoEscolaridadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadeEscolarHasAnoEscolaridade)) {
            return false;
        }
        UnidadeEscolarHasAnoEscolaridade other = (UnidadeEscolarHasAnoEscolaridade) object;
        if ((this.unidadeEscolarHasAnoEscolaridadePK == null && other.unidadeEscolarHasAnoEscolaridadePK != null) || (this.unidadeEscolarHasAnoEscolaridadePK != null && !this.unidadeEscolarHasAnoEscolaridadePK.equals(other.unidadeEscolarHasAnoEscolaridadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UnidadeEscolarHasAnoEscolaridade[ unidadeEscolarHasAnoEscolaridadePK=" + unidadeEscolarHasAnoEscolaridadePK + " ]";
    }
    
}
