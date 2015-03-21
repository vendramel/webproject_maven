package com.vendramel.entitys;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author vendra
 */
@Entity
@Table(name="tipologradouro")
public class TipoLogradouro implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="IdTipoLogradouro", nullable = false)
    private Integer idTipoLogradouro;
    
    @Column(name="DescricaoTipoLogradouro", nullable = false, length = 40)
    private String descricaoTipoLogradouro;
    
    @OneToMany(mappedBy = "tipologradouro", fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoTipoLogradouro")
    
    private List<Endereco> enderecos;

    public TipoLogradouro() {
    }

    public Integer getIdTipoLogradouro() {
        return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(Integer idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    public String getDescricaoTipoLogradouro() {
        return descricaoTipoLogradouro;
    }

    public void setDescricaoTipoLogradouro(String descricaoTipoLogradouro) {
        this.descricaoTipoLogradouro = descricaoTipoLogradouro;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idTipoLogradouro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (!Objects.equals(this.idTipoLogradouro, other.idTipoLogradouro)) {
            return false;
        }
        return true;
    }
    
            
    
}
