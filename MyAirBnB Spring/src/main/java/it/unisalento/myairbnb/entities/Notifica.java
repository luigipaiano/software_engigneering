// Generated with g9.

package it.unisalento.myairbnb.entities;

import java.io.Serializable;
import java.sql.Timestamp;
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

@Entity(name="notifica")
public class Notifica implements Serializable {

    /** Primary key. */
    protected static final String PK = "idnotifica";

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
    private int idnotifica;
    @Column(length=200)
    private String descrizione;
    @Column(precision=10)
    private int tipo;
    private Timestamp data;
    @ManyToOne
    @JoinColumn(name="idacquirente")
    private Acquirente acquirente;
    @ManyToOne
    @JoinColumn(name="idproponente")
    private Proponente proponente;
    @ManyToOne
    @JoinColumn(name="idproposta")
    private Proposta proposta;

    /** Default constructor. */
    public Notifica() {
        super();
    }

    /**
     * Access method for idnotifica.
     *
     * @return the current value of idnotifica
     */
    public int getIdnotifica() {
        return idnotifica;
    }

    /**
     * Setter method for idnotifica.
     *
     * @param aIdnotifica the new value for idnotifica
     */
    public void setIdnotifica(int aIdnotifica) {
        idnotifica = aIdnotifica;
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
     * Access method for tipo.
     *
     * @return the current value of tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Setter method for tipo.
     *
     * @param aTipo the new value for tipo
     */
    public void setTipo(int aTipo) {
        tipo = aTipo;
    }

    /**
     * Access method for data.
     *
     * @return the current value of data
     */
    public Timestamp getData() {
        return data;
    }

    /**
     * Setter method for data.
     *
     * @param aData the new value for data
     */
    public void setData(Timestamp aData) {
        data = aData;
    }

    /**
     * Access method for acquirente.
     *
     * @return the current value of acquirente
     */
    public Acquirente getAcquirente() {
        return acquirente;
    }

    /**
     * Setter method for acquirente.
     *
     * @param aAcquirente the new value for acquirente
     */
    public void setAcquirente(Acquirente aAcquirente) {
        acquirente = aAcquirente;
    }

    /**
     * Access method for proponente.
     *
     * @return the current value of proponente
     */
    public Proponente getProponente() {
        return proponente;
    }

    /**
     * Setter method for proponente.
     *
     * @param aProponente the new value for proponente
     */
    public void setProponente(Proponente aProponente) {
        proponente = aProponente;
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
     * Compares the key for this instance with another Notifica.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Notifica and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Notifica)) {
            return false;
        }
        Notifica that = (Notifica) other;
        if (this.getIdnotifica() != that.getIdnotifica()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Notifica.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Notifica)) return false;
        return this.equalKeys(other) && ((Notifica)other).equalKeys(this);
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
        i = getIdnotifica();
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
        StringBuffer sb = new StringBuffer("[Notifica |");
        sb.append(" idnotifica=").append(getIdnotifica());
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
        ret.put("idnotifica", Integer.valueOf(getIdnotifica()));
        return ret;
    }

}
