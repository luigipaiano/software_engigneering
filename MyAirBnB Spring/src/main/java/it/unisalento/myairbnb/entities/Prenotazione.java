// Generated with g9.

package it.unisalento.myairbnb.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="prenotazione")
public class Prenotazione implements Serializable {

    /** Primary key. */
    protected static final String PK = "idprenotazione";

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
    private int idprenotazione;
    private Timestamp datatransazione;
    private Timestamp datacheckin;
    private Timestamp datacheckout;
    @Column(precision=10)
    private BigDecimal costotot;
    @ManyToOne(optional=false)
    @JoinColumn(name="idacquirente", nullable=false)
    private Acquirente acquirente;
    @ManyToOne(optional=false)
    @JoinColumn(name="idproposta", nullable=false)
    private Proposta proposta;
    @OneToMany(mappedBy="prenotazione")
    private Set<Pagamento> pagamento;

    /** Default constructor. */
    public Prenotazione() {
        super();
    }

    /**
     * Access method for idprenotazione.
     *
     * @return the current value of idprenotazione
     */
    public int getIdprenotazione() {
        return idprenotazione;
    }

    /**
     * Setter method for idprenotazione.
     *
     * @param aIdprenotazione the new value for idprenotazione
     */
    public void setIdprenotazione(int aIdprenotazione) {
        idprenotazione = aIdprenotazione;
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
     * Access method for datacheckin.
     *
     * @return the current value of datacheckin
     */
    public Timestamp getDatacheckin() {
        return datacheckin;
    }

    /**
     * Setter method for datacheckin.
     *
     * @param aDatacheckin the new value for datacheckin
     */
    public void setDatacheckin(Timestamp aDatacheckin) {
        datacheckin = aDatacheckin;
    }

    /**
     * Access method for datacheckout.
     *
     * @return the current value of datacheckout
     */
    public Timestamp getDatacheckout() {
        return datacheckout;
    }

    /**
     * Setter method for datacheckout.
     *
     * @param aDatacheckout the new value for datacheckout
     */
    public void setDatacheckout(Timestamp aDatacheckout) {
        datacheckout = aDatacheckout;
    }

    /**
     * Access method for costotot.
     *
     * @return the current value of costotot
     */
    public BigDecimal getCostotot() {
        return costotot;
    }

    /**
     * Setter method for costotot.
     *
     * @param aCostotot the new value for costotot
     */
    public void setCostotot(BigDecimal aCostotot) {
        costotot = aCostotot;
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
     * Access method for pagamento.
     *
     * @return the current value of pagamento
     */
    public Set<Pagamento> getPagamento() {
        return pagamento;
    }

    /**
     * Setter method for pagamento.
     *
     * @param aPagamento the new value for pagamento
     */
    public void setPagamento(Set<Pagamento> aPagamento) {
        pagamento = aPagamento;
    }

    /**
     * Compares the key for this instance with another Prenotazione.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Prenotazione and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Prenotazione)) {
            return false;
        }
        Prenotazione that = (Prenotazione) other;
        if (this.getIdprenotazione() != that.getIdprenotazione()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Prenotazione.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Prenotazione)) return false;
        return this.equalKeys(other) && ((Prenotazione)other).equalKeys(this);
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
        i = getIdprenotazione();
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
        StringBuffer sb = new StringBuffer("[Prenotazione |");
        sb.append(" idprenotazione=").append(getIdprenotazione());
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
        ret.put("idprenotazione", Integer.valueOf(getIdprenotazione()));
        return ret;
    }

}
