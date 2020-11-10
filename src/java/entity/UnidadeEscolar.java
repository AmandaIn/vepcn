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
@Table(name = "unidade_escolar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadeEscolar.findAll", query = "SELECT u FROM UnidadeEscolar u")
    , @NamedQuery(name = "UnidadeEscolar.findById", query = "SELECT u FROM UnidadeEscolar u WHERE u.id = :id")
    , @NamedQuery(name = "UnidadeEscolar.findByNome", query = "SELECT u FROM UnidadeEscolar u WHERE u.nome = :nome")})
public class UnidadeEscolar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "id_ano_escolaridade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AnoEscolaridade idAnoEscolaridade;
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Endereco idEndereco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeEscolar")
    private Collection<UnidadeEscolarHasAnoEscolaridade> unidadeEscolarHasAnoEscolaridadeCollection;

    public UnidadeEscolar() {
    }

    public UnidadeEscolar(Integer id) {
        this.id = id;
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

    public AnoEscolaridade getIdAnoEscolaridade() {
        return idAnoEscolaridade;
    }

    public void setIdAnoEscolaridade(AnoEscolaridade idAnoEscolaridade) {
        this.idAnoEscolaridade = idAnoEscolaridade;
    }

    public Endereco getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Endereco idEndereco) {
        this.idEndereco = idEndereco;
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
        if (!(object instanceof UnidadeEscolar)) {
            return false;
        }
        UnidadeEscolar other = (UnidadeEscolar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UnidadeEscolar[ id=" + id + " ]";
    }
    
}
