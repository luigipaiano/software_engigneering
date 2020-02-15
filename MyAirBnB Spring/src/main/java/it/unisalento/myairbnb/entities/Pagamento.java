// Generated with g9.

package it.unisalento.myairbnb.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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

@Entity(name="pagamento")
public class Pagamento implements Serializable {

    /** Primary key. */
    protected static final String PK = "idpagamento";

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
    private int idpagamento;
    @Column(length=100)
    private String metodo;
    @Column(precision=10)
    private BigDecimal importo;
    private Timestamp datatransazione;
    @ManyToOne(optional=false)
    @JoinColumn(name="idacquirente", nullable=false)
    private Acquirente acquirente;
    @ManyToOne(optional=false)
    @JoinColumn(name="idprenotazione", nullable=false)
    private Prenotazione prenotazione;

    /** Default constructor. */
    public Pagamento() {
        super();
    }

    /**
     * Access method for idpagamento.
     *
     * @return the current value of idpagamento
     */
    public int getIdpagamento() {
        return idpagamento;
    }

    /**
     * Setter method for idpagamento.
     *
     * @param aIdpagamento the new value for idpagamento
     */
    public void setIdpagamento(int aIdpagamento) {
        idpagamento = aIdpagamento;
    }

    /**
     * Access method for metodo.
     *
     * @return the current value of metodo
     */
    public String getMetodo() {
        return metodo;
    }

    /**
     * Setter method for metodo.
     *
     * @param aMetodo the new value for metodo
     */
    public void setMetodo(String aMetodo) {
        metodo = aMetodo;
    }

    /**
     * Access method for importo.
     *
     * @return the current value of importo
     */
    public BigDecimal getImporto() {
        return importo;
    }

    /**
     * Setter method for importo.
     *
     * @param aImporto the new value for importo
     */
    public void setImporto(BigDecimal aImporto) {
        importo = aImporto;
    }

    /**
     * Access method for datatransazione.
     *
     * @return the current value of datatransazione
     */
    public Timestamp getDatatransazione() {
        return datatransazione;
    }

    /**
     * Setter method for datatransazione.
     *
     * @param aDatatransazione the new value for datatransazione
     */
    public void setDatatransazione(Timestamp aDatatransazione) {
        datatransazione = aDatatransazione;
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
     * Access method for prenotazione.
     *
     * @return the current value of prenotazione
     */
    public Prenotazione getPrenotazione() {
        return prenotazione;
    }

    /**
     * Setter method for prenotazione.
     *
     * @param aPrenotazione the new value for prenotazione
     */
    public void setPrenotazione(Prenotazione aPrenotazione) {
        prenotazione = aPrenotazione;
    }

    /**
     * Compares the key for this instance with another Pagamento.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Pagamento and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Pagamento)) {
            return false;
        }
        Pagamento that = (Pagamento) other;
        if (this.getIdpagamento() != that.getIdpagamento()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Pagamento.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pagamento)) return false;
        return this.equalKeys(other) && ((Pagamento)other).equalKeys(this);
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
        i = getIdpagamento();
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
        StringBuffer sb = new StringBuffer("[Pagamento |");
        sb.append(" idpagamento=").append(getIdpagamento());
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
        ret.put("idpagamento", Integer.valueOf(getIdpagamento()));
        return ret;
    }

}
