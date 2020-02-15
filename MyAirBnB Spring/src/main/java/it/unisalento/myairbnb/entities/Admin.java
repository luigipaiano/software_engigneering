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

@Entity(name="admin")
public class Admin implements Serializable {

    /** Primary key. */
    protected static final String PK = "idadmin";

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
    private int idadmin;
    @ManyToOne(optional=false)
    @JoinColumn(name="idutente", nullable=false)
    private Utente utente;

    /** Default constructor. */
    public Admin() {
        super();
    }

    /**
     * Access method for idadmin.
     *
     * @return the current value of idadmin
     */
    public int getIdadmin() {
        return idadmin;
    }

    /**
     * Setter method for idadmin.
     *
     * @param aIdadmin the new value for idadmin
     */
    public void setIdadmin(int aIdadmin) {
        idadmin = aIdadmin;
    }

    /**
     * Access method for utente.
     *
     * @return the current value of utente
     */
    public Utente getUtente() {
        return utente;
    }

    /**
     * Setter method for utente.
     *
     * @param aUtente the new value for utente
     */
    public void setUtente(Utente aUtente) {
        utente = aUtente;
    }

    /**
     * Compares the key for this instance with another Admin.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Admin and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Admin)) {
            return false;
        }
        Admin that = (Admin) other;
        if (this.getIdadmin() != that.getIdadmin()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Admin.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Admin)) return false;
        return this.equalKeys(other) && ((Admin)other).equalKeys(this);
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
        i = getIdadmin();
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
        StringBuffer sb = new StringBuffer("[Admin |");
        sb.append(" idadmin=").append(getIdadmin());
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
        ret.put("idadmin", Integer.valueOf(getIdadmin()));
        return ret;
    }

}
