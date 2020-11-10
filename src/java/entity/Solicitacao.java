/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Casa
 */
@Entity
@Table(name = "solicitacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitacao.findAll", query = "SELECT s FROM Solicitacao s")
    , @NamedQuery(name = "Solicitacao.findById", query = "SELECT s FROM Solicitacao s WHERE s.id = :id")
    , @NamedQuery(name = "Solicitacao.findByProtocolo", query = "SELECT s FROM Solicitacao s WHERE s.protocolo = :protocolo")})
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "protocolo")
    private String protocolo;
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Aluno idAluno;
    @JoinColumn(name = "id_responsavel", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Responsavel idResponsavel;
    @JoinColumns({
        @JoinColumn(name = "id_unidade_escolar", referencedColumnName = "unidade_escolar_id")
        , @JoinColumn(name = "id_ano_escolaridade", referencedColumnName = "ano_escolaridade_id")})
    @ManyToOne(optional = false)
    private UnidadeEscolarHasAnoEscolaridade unidadeEscolarHasAnoEscolaridade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitacao")
    private Collection<SolicitacaoHasResponsavel> solicitacaoHasResponsavelCollection;

    public Solicitacao() {
    }

    public Solicitacao(Integer id) {
        this.id = id;
    }

    public Solicitacao(Integer id, String protocolo) {
        this.id = id;
        this.protocolo = protocolo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    public Responsavel getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Responsavel idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public UnidadeEscolarHasAnoEscolaridade getUnidadeEscolarHasAnoEscolaridade() {
        return unidadeEscolarHasAnoEscolaridade;
    }

    public void setUnidadeEscolarHasAnoEscolaridade(UnidadeEscolarHasAnoEscolaridade unidadeEscolarHasAnoEscolaridade) {
        this.unidadeEscolarHasAnoEscolaridade = unidadeEscolarHasAnoEscolaridade;
    }

    @XmlTransient
    public Collection<SolicitacaoHasResponsavel> getSolicitacaoHasResponsavelCollection() {
        return solicitacaoHasResponsavelCollection;
    }

    public void setSolicitacaoHasResponsavelCollection(Collection<SolicitacaoHasResponsavel> solicitacaoHasResponsavelCollection) {
        this.solicitacaoHasResponsavelCollection = solicitacaoHasResponsavelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Solicitacao[ id=" + id + " ]";
    }
    
}
