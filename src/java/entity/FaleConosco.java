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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Casa
 */
@Entity
@Table(name = "fale_conosco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaleConosco.findAll", query = "SELECT f FROM FaleConosco f")
    , @NamedQuery(name = "FaleConosco.findById", query = "SELECT f FROM FaleConosco f WHERE f.id = :id")
    , @NamedQuery(name = "FaleConosco.findByData", query = "SELECT f FROM FaleConosco f WHERE f.data = :data")
    , @NamedQuery(name = "FaleConosco.findByAssunto", query = "SELECT f FROM FaleConosco f WHERE f.assunto = :assunto")})
public class FaleConosco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "assunto")
    private String assunto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "texto")
    private String texto;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idPessoa;

    public FaleConosco() {
    }

    public FaleConosco(Integer id) {
        this.id = id;
    }

    public FaleConosco(Integer id, Date data, String assunto, String texto) {
        this.id = id;
        this.data = data;
        this.assunto = assunto;
        this.texto = texto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
        if (!(object instanceof FaleConosco)) {
            return false;
        }
        FaleConosco other = (FaleConosco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FaleConosco[ id=" + id + " ]";
    }
    
}
