// Generated with g9.

package it.unisalento.myairbnb.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="immagine")
public class Immagine implements Serializable {

    /** Primary key. */
    protected static final String PK = "idimmagine";

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
    private int idimmagine;
    @Column(length=255)
    private String percorso;
    @ManyToOne(optional=false)
    @JoinColumn(name="idproposta", nullable=false)
    private Proposta proposta;

    /** Default constructor. */
    public Immagine() {
        super();
    }

    /**
     * Access method for idimmagine.
     *
     * @return the current value of idimmagine
     */
    public int getIdimmagine() {
        return idimmagine;
    }

    /**
     * Setter method for idimmagine.
     *
     * @param aIdimmagine the new value for idimmagine
     */
    public void setIdimmagine(int aIdimmagine) {
        idimmagine = aIdimmagine;
    }

    /**
     * Access method for percorso.
     *
     * @return the current value of percorso
     */
    public String getPercorso() {
        return percorso;
    }

    /**
     * Setter method for percorso.
     *
     * @param aPercorso the new value for percorso
     */
    public void setPercorso(String aPercorso) {
        percorso = aPercorso;
    }

    /**
     * Access method for proposta.
     *
     * @return the current value of proposta
     */
    public Proposta getProposta() {
        return proposta;
    }

    /**
     * Setter method for proposta.
     *
     * @param aProposta the new value for proposta
     */
    public void setProposta(Proposta aProposta) {
        proposta = aProposta;
    }

    /**
     * Compares the key for this instance with another Immagine.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Immagine and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Immagine)) {
            return false;
        }
        Immagine that = (Immagine) other;
        if (this.getIdimmagine() != that.getIdimmagine()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Immagine.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Immagine)) return false;
        return this.equalKeys(other) && ((Immagine)other).equalKeys(this);
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
        i = getIdimmagine();
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
        StringBuffer sb = new StringBuffer("[Immagine |");
        sb.append(" idimmagine=").append(getIdimmagine());
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
        ret.put("idimmagine", Integer.valueOf(getIdimmagine()));
        return ret;
    }

}
