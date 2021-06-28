/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enade.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author carolyne.carreira
 */
@Entity
@Table(name = "TipoQuestao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoQuestao.findAll", query = "SELECT t FROM TipoQuestao t"),
    @NamedQuery(name = "TipoQuestao.findByIdtipoQuestao", query = "SELECT t FROM TipoQuestao t WHERE t.idtipoQuestao = :idtipoQuestao"),
    @NamedQuery(name = "TipoQuestao.findByNomeTipoQuestao", query = "SELECT t FROM TipoQuestao t WHERE t.nomeTipoQuestao = :nomeTipoQuestao")})
public class TipoQuestao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoQuestao")
    private Integer idtipoQuestao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeTipoQuestao")
    private String nomeTipoQuestao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoQuestaoidtipoQuestao")
    private List<Questao> questaoList;

    public TipoQuestao() {
    }

    public TipoQuestao(Integer idtipoQuestao) {
        this.idtipoQuestao = idtipoQuestao;
    }

    public TipoQuestao(Integer idtipoQuestao, String nomeTipoQuestao) {
        this.idtipoQuestao = idtipoQuestao;
        this.nomeTipoQuestao = nomeTipoQuestao;
    }

    public Integer getIdtipoQuestao() {
        return idtipoQuestao;
    }

    public void setIdtipoQuestao(Integer idtipoQuestao) {
        this.idtipoQuestao = idtipoQuestao;
    }

    public String getNomeTipoQuestao() {
        return nomeTipoQuestao;
    }

    public void setNomeTipoQuestao(String nomeTipoQuestao) {
        this.nomeTipoQuestao = nomeTipoQuestao;
    }

    @XmlTransient
    public List<Questao> getQuestaoList() {
        return questaoList;
    }

    public void setQuestaoList(List<Questao> questaoList) {
        this.questaoList = questaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoQuestao != null ? idtipoQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoQuestao)) {
            return false;
        }
        TipoQuestao other = (TipoQuestao) object;
        if ((this.idtipoQuestao == null && other.idtipoQuestao != null) || (this.idtipoQuestao != null && !this.idtipoQuestao.equals(other.idtipoQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enade.model.TipoQuestao[ idtipoQuestao=" + idtipoQuestao + " ]";
    }
    
}
