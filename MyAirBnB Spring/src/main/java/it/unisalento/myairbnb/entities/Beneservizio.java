// Generated with g9.

package it.unisalento.myairbnb.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="beneservizio")
public class Beneservizio implements Serializable {

    /** Primary key. */
    protected static final String PK = "idbeneservizio";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int idbeneservizio;
    @Column(length=80)
    private String categoria;
    @Column(length=255)
    private String descrizione;
    @OneToMany(mappedBy="beneservizio")
    private Set<Proposta> proposta;

    /** Default constructor. */
    public Beneservizio() {
        super();
    }

    /**
     * Access method for idbeneservizio.
     *
     * @return the current value of idbeneservizio
     */
    public int getIdbeneservizio() {
        return idbeneservizio;
    }

    /**
     * Setter method for idbeneservizio.
     *
     * @param aIdbeneservizio the new value for idbeneservizio
     */
    public void setIdbeneservizio(int aIdbeneservizio) {
        idbeneservizio = aIdbeneservizio;
    }

    /**
     * Access method for categoria.
     *
     * @return the current value of categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Setter method for categoria.
     *
     * @param aCategoria the new value for categoria
     */
    public void setCategoria(String aCategoria) {
        categoria = aCategoria;
    }

    /**
     * Access method for descrizione.
     *
     * @return the current value of descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Setter method for descrizione.
     *
     * @param aDescrizione the new value for descrizione
     */
    public void setDescrizione(String aDescrizione) {
        descrizione = aDescrizione;
    }

    /**
     * Access method for proposta.
     *
     * @return the current value of proposta
     */
    public Set<Proposta> getProposta() {
        return proposta;
    }

    /**
     * Setter method for proposta.
     *
     * @param aProposta the new value for proposta
     */
    public void setProposta(Set<Proposta> aProposta) {
        proposta = aProposta;
    }

    /**
     * Compares the key for this instance with another Beneservizio.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Beneservizio and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Beneservizio)) {
            return false;
        }
        Beneservizio that = (Beneservizio) other;
        if (this.getIdbeneservizio() != that.getIdbeneservizio()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Beneservizio.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Beneservizio)) return false;
        return this.equalKeys(other) && ((Beneservizio)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getIdbeneservizio();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Beneservizio |");
        sb.append(" idbeneservizio=").append(getIdbeneservizio());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idbeneservizio", Integer.valueOf(getIdbeneservizio()));
        return ret;
    }

}
