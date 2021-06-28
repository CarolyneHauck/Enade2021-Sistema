/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enade.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carolyne.carreira
 */
@Entity
@Table(name = "Questao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questao.findAll", query = "SELECT q FROM Questao q"),
    @NamedQuery(name = "Questao.findByIdQuestao", query = "SELECT q FROM Questao q WHERE q.idQuestao = :idQuestao"),
    @NamedQuery(name = "Questao.findByDescricaoQuestao", query = "SELECT q FROM Questao q WHERE q.descricaoQuestao = :descricaoQuestao"),
    @NamedQuery(name = "Questao.findByAlternativaA", query = "SELECT q FROM Questao q WHERE q.alternativaA = :alternativaA"),
    @NamedQuery(name = "Questao.findByAlternativaB", query = "SELECT q FROM Questao q WHERE q.alternativaB = :alternativaB"),
    @NamedQuery(name = "Questao.findByAlternativaC", query = "SELECT q FROM Questao q WHERE q.alternativaC = :alternativaC"),
    @NamedQuery(name = "Questao.findByAlternativaD", query = "SELECT q FROM Questao q WHERE q.alternativaD = :alternativaD"),
    @NamedQuery(name = "Questao.findByAlternativaE", query = "SELECT q FROM Questao q WHERE q.alternativaE = :alternativaE"),
    @NamedQuery(name = "Questao.findByQuestaoCorreta", query = "SELECT q FROM Questao q WHERE q.questaoCorreta = :questaoCorreta"),
    @NamedQuery(name = "Questao.findByEstadoQuestao", query = "SELECT q FROM Questao q WHERE q.estadoQuestao = :estadoQuestao")})
public class Questao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuestao")
    private Integer idQuestao;
    @Size(max = 45)
    @Column(name = "descricaoQuestao")
    private String descricaoQuestao;
    @Size(max = 45)
    @Column(name = "alternativaA")
    private String alternativaA;
    @Size(max = 45)
    @Column(name = "alternativaB")
    private String alternativaB;
    @Size(max = 45)
    @Column(name = "alternativaC")
    private String alternativaC;
    @Size(max = 45)
    @Column(name = "alternativaD")
    private String alternativaD;
    @Size(max = 45)
    @Column(name = "alternativaE")
    private String alternativaE;
    @Column(name = "questaoCorreta")
    private Character questaoCorreta;
    @Column(name = "estadoQuestao")
    private boolean estadoQuestao;
    @ManyToMany(mappedBy = "questaoList")
    private List<Prova> provaList;
    @JoinColumn(name = "TipoQuestao_idtipoQuestao", referencedColumnName = "idtipoQuestao")
    @ManyToOne(optional = false)
    private TipoQuestao tipoQuestaoidtipoQuestao;

    public Questao() {
    }

    public Questao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public Questao(Integer idQuestao, String descricaoQuestao) {
	this.idQuestao = idQuestao;
	this.descricaoQuestao = descricaoQuestao;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getDescricaoQuestao() {
        return descricaoQuestao;
    }

    public void setDescricaoQuestao(String descricaoQuestao) {
        this.descricaoQuestao = descricaoQuestao;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(String alternativaE) {
        this.alternativaE = alternativaE;
    }

    public Character getQuestaoCorreta() {
        return questaoCorreta;
    }

    public void setQuestaoCorreta(Character questaoCorreta) {
        this.questaoCorreta = questaoCorreta;
    }

    public boolean getEstadoQuestao() {
        return estadoQuestao;
    }

    public void setEstadoQuestao(boolean estadoQuestao) {
        this.estadoQuestao = estadoQuestao;
    }

    @XmlTransient
    public List<Prova> getProvaList() {
        return provaList;
    }

    public void setProvaList(List<Prova> provaList) {
        this.provaList = provaList;
    }

    public TipoQuestao getTipoQuestaoidtipoQuestao() {
        return tipoQuestaoidtipoQuestao;
    }

    public void setTipoQuestaoidtipoQuestao(TipoQuestao tipoQuestaoidtipoQuestao) {
        this.tipoQuestaoidtipoQuestao = tipoQuestaoidtipoQuestao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestao != null ? idQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questao)) {
            return false;
        }
        Questao other = (Questao) object;
        if ((this.idQuestao == null && other.idQuestao != null) || (this.idQuestao != null && !this.idQuestao.equals(other.idQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Questao[ idQuestao=" + idQuestao + " ]";
    }
    
}