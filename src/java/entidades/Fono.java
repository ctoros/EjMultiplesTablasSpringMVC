/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ctoro
 */
@Entity
@Table(name = "fono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fono.findAll", query = "SELECT f FROM Fono f")
    , @NamedQuery(name = "Fono.findByFono", query = "SELECT f FROM Fono f WHERE f.fono = :fono")
    , @NamedQuery(name = "Fono.findByNumero", query = "SELECT f FROM Fono f WHERE f.numero = :numero")})
public class Fono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fono")
    private Integer fono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @JoinColumn(name = "rut", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Alumno rut;

    public Fono() {
    }

    public Fono(Integer fono) {
        this.fono = fono;
    }

    public Fono(Integer fono, int numero) {
        this.fono = fono;
        this.numero = numero;
    }

    public Integer getFono() {
        return fono;
    }

    public void setFono(Integer fono) {
        this.fono = fono;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Alumno getRut() {
        return rut;
    }

    public void setRut(Alumno rut) {
        this.rut = rut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fono != null ? fono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fono)) {
            return false;
        }
        Fono other = (Fono) object;
        if ((this.fono == null && other.fono != null) || (this.fono != null && !this.fono.equals(other.fono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Fono[ fono=" + fono + " ]";
    }
    
}
