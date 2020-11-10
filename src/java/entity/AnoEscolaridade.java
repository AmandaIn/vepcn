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
@Table(name = "ano_escolaridade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnoEscolaridade.findAll", query = "SELECT a FROM AnoEscolaridade a")
    , @NamedQuery(name = "AnoEscolaridade.findById", query = "SELECT a FROM AnoEscolaridade a WHERE a.id = :id")
    , @NamedQuery(name = "AnoEscolaridade.findByNome", query = "SELECT a FROM AnoEscolaridade a WHERE a.nome = :nome")
    , @NamedQuery(name = "AnoEscolaridade.findByDescricao", query = "SELECT a FROM AnoEscolaridade a WHERE a.descricao = :descricao")})
public class AnoEscolaridade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnoEscolaridade")
    private Collection<UnidadeEscolar> unidadeEscolarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anoEscolaridade")
    private Collection<UnidadeEscolarHasAnoEscolaridade> unidadeEscolarHasAnoEscolaridadeCollection;

    public AnoEscolaridade() {
    }

    public AnoEscolaridade(Integer id) {
        this.id = id;
    }

    public AnoEscolaridade(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<UnidadeEscolar> getUnidadeEscolarCollection() {
        return unidadeEscolarCollection;
    }

    public void setUnidadeEscolarCollection(Collection<UnidadeEscolar> unidadeEscolarCollection) {
        this.unidadeEscolarCollection = unidadeEscolarCollection;
    }

    @XmlTransient
    public Collection<UnidadeEscolarHasAnoEscolaridade> getUnidadeEscolarHasAnoEscolaridadeCollection() {
        return unidadeEscolarHasAnoEscolaridadeCollection;
    }

    public void setUnidadeEscolarHasAnoEscolaridadeCollection(Collection<UnidadeEscolarHasAnoEscolaridade> unidadeEscolarHasAnoEscolaridadeCollection) {
        this.unidadeEscolarHasAnoEscolaridadeCollection = unidadeEscolarHasAnoEscolaridadeCollection;
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
        if (!(object instanceof AnoEscolaridade)) {
            return false;
        }
        AnoEscolaridade other = (AnoEscolaridade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AnoEscolaridade[ id=" + id + " ]";
    }
    
}
