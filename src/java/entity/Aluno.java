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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Casa
 */
@Entity
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
    , @NamedQuery(name = "Aluno.findById", query = "SELECT a FROM Aluno a WHERE a.id = :id")
    , @NamedQuery(name = "Aluno.findByNaturalidade", query = "SELECT a FROM Aluno a WHERE a.naturalidade = :naturalidade")
    , @NamedQuery(name = "Aluno.findByNomeMae", query = "SELECT a FROM Aluno a WHERE a.nomeMae = :nomeMae")
    , @NamedQuery(name = "Aluno.findByNomePai", query = "SELECT a FROM Aluno a WHERE a.nomePai = :nomePai")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "naturalidade")
    private String naturalidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome_mae")
    private String nomeMae;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome_pai")
    private String nomePai;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoa;
    @JoinColumn(name = "id_responsavel", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Responsavel idResponsavel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoId")
    private Collection<ListaEspera> listaEsperaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAluno")
    private Collection<Solicitacao> solicitacaoCollection;

    public Aluno() {
    }

    public Aluno(Integer id) {
        this.id = id;
    }

    public Aluno(Integer id, String naturalidade, String nomeMae, String nomePai) {
        this.id = id;
        this.naturalidade = naturalidade;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Responsavel getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Responsavel idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    @XmlTransient
    public Collection<ListaEspera> getListaEsperaCollection() {
        return listaEsperaCollection;
    }

    public void setListaEsperaCollection(Collection<ListaEspera> listaEsperaCollection) {
        this.listaEsperaCollection = listaEsperaCollection;
    }

    @XmlTransient
    public Collection<Solicitacao> getSolicitacaoCollection() {
        return solicitacaoCollection;
    }

    public void setSolicitacaoCollection(Collection<Solicitacao> solicitacaoCollection) {
        this.solicitacaoCollection = solicitacaoCollection;
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
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Aluno[ id=" + id + " ]";
    }
    
}
