package com.setrem.pratica2api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "evento")
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "descricao")
    private String  descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    @JsonIgnore
    @JoinColumn(name = "incidenciaid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Incidencia incidenciaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "automatico")
    private boolean automatico;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Incidencia getIncidenciaId() {
        return this.incidenciaId;
    }

    public void setIncidenciaId(Incidencia incidenciaId) {
        this.incidenciaId = incidenciaId;
    }

    public boolean isAutomatico() {
        return this.automatico;
    }

    public boolean getAutomatico() {
        return this.automatico;
    }

    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Evento)) {
            return false;
        }
        Evento evento = (Evento) o;
        return Objects.equals(id, evento.id) && Objects.equals(descricao, evento.descricao) && Objects.equals(tipo, evento.tipo) && Objects.equals(incidenciaId, evento.incidenciaId) && automatico == evento.automatico;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, tipo, incidenciaId, automatico);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", incidenciaId='" + getIncidenciaId() + "'" +
            ", automatico='" + isAutomatico() + "'" +
            "}";
    }


}