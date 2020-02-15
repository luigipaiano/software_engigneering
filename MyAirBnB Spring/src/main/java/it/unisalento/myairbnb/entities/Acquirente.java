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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="acquirente")
public class Acquirente implements Serializable {

    /** Primary key. */
    protected static final String PK = "idacquirente";

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
    private int idacquirente;
    @Column(length=15)
    private String telefono;
    @Column(length=255)
    private String indirizzo;
    @Column(length=45)
    private String citta;
    @Column(length=5)
    private String cap;
    @OneToMany(mappedBy="acquirente")
    private Set<Prenotazione> prenotazione;
    @OneToMany(mappedBy="acquirente")
    private Set<Commento> commento;
    @ManyToOne(optional=false)
    @JoinColumn(name="idutente", nullable=false)
    private Utente utente;
    @OneToMany(mappedBy="acquirente")
    private Set<Pagamento> pagamento;
    @OneToMany(mappedBy="acquirente")
    private Set<Notifica> notifica;

    /** Default constructor. */
    public Acquirente() {
        super();
    }

    /**
     * Access method for idacquirente.
     *
     * @return the current value of idacquirente
     */
    public int getIdacquirente() {
        return idacquirente;
    }

    /**
     * Setter method for idacquirente.
     *
     * @param aIdacquirente the new value for idacquirente
     */
    public void setIdacquirente(int aIdacquirente) {
        idacquirente = aIdacquirente;
    }

    /**
     * Access method for telefono.
     *
     * @return the current value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter method for telefono.
     *
     * @param aTelefono the new value for telefono
     */
    public void setTelefono(String aTelefono) {
        telefono = aTelefono;
    }

    /**
     * Access method for indirizzo.
     *
     * @return the current value of indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Setter method for indirizzo.
     *
     * @param aIndirizzo the new value for indirizzo
     */
    public void setIndirizzo(String aIndirizzo) {
        indirizzo = aIndirizzo;
    }

    /**
     * Access method for citta.
     *
     * @return the current value of citta
     */
    public String getCitta() {
        return citta;
    }

    /**
     * Setter method for citta.
     *
     * @param aCitta the new value for citta
     */
    public void setCitta(String aCitta) {
        citta = aCitta;
    }

    /**
     * Access method for cap.
     *
     * @return the current value of cap
     */
    public String getCap() {
        return cap;
    }

    /**
     * Setter method for cap.
     *
     * @param aCap the new value for cap
     */
    public void setCap(String aCap) {
        cap = aCap;
    }

    /**
     * Access method for prenotazione.
     *
     * @return the current value of prenotazione
     */
    public Set<Prenotazione> getPrenotazione() {
        return prenotazione;
    }

    /**
     * Setter method for prenotazione.
     *
     * @param aPrenotazione the new value for prenotazione
     */
    public void setPrenotazione(Set<Prenotazione> aPrenotazione) {
        prenotazione = aPrenotazione;
    }

    /**
     * Access method for commento.
     *
     * @return the current value of commento
     */
    public Set<Commento> getCommento() {
        return commento;
    }

    /**
     * Setter method for commento.
     *
     * @param aCommento the new value for commento
     */
    public void setCommento(Set<Commento> aCommento) {
        commento = aCommento;
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
     * Access method for notifica.
     *
     * @return the current value of notifica
     */
    public Set<Notifica> getNotifica() {
        return notifica;
    }

    /**
     * Setter method for notifica.
     *
     * @param aNotifica the new value for notifica
     */
    public void setNotifica(Set<Notifica> aNotifica) {
        notifica = aNotifica;
    }

    /**
     * Compares the key for this instance with another Acquirente.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Acquirente and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Acquirente)) {
            return false;
        }
        Acquirente that = (Acquirente) other;
        if (this.getIdacquirente() != that.getIdacquirente()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Acquirente.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Acquirente)) return false;
        return this.equalKeys(other) && ((Acquirente)other).equalKeys(this);
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
        i = getIdacquirente();
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
        StringBuffer sb = new StringBuffer("[Acquirente |");
        sb.append(" idacquirente=").append(getIdacquirente());
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
        ret.put("idacquirente", Integer.valueOf(getIdacquirente()));
        return ret;
    }

}
