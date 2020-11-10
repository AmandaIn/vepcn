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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Casa
 */
@Entity
@Table(name = "responsavel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsavel.findAll", query = "SELECT r FROM Responsavel r")
    , @NamedQuery(name = "Responsavel.findById", query = "SELECT r FROM Responsavel r WHERE r.id = :id")})
public class Responsavel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResponsavel")
    private Collection<Aluno> alunoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResponsavel")
    private Collection<Solicitacao> solicitacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsavel")
    private Collection<SolicitacaoHasResponsavel> solicitacaoHasResponsavelCollection;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoa;

    public Responsavel() {
    }

    public Responsavel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Aluno> getAlunoCollection() {
        return alunoCollection;
    }

    public void setAlunoCollection(Collection<Aluno> alunoCollection) {
        this.alunoCollection = alunoCollection;
    }

    @XmlTransient
    public Collection<Solicitacao> getSolicitacaoCollection() {
        return solicitacaoCollection;
    }

    public void setSolicitacaoCollection(Collection<Solicitacao> solicitacaoCollection) {
        this.solicitacaoCollection = solicitacaoCollection;
    }

    @XmlTransient
    public Collection<SolicitacaoHasResponsavel> getSolicitacaoHasResponsavelCollection() {
        return solicitacaoHasResponsavelCollection;
    }

    public void setSolicitacaoHasResponsavelCollection(Collection<SolicitacaoHasResponsavel> solicitacaoHasResponsavelCollection) {
        this.solicitacaoHasResponsavelCollection = solicitacaoHasResponsavelCollection;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
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
        if (!(object instanceof Responsavel)) {
            return false;
        }
        Responsavel other = (Responsavel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Responsavel[ id=" + id + " ]";
    }
    
}
