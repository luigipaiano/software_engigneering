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

@Entity(name="proposta")
public class Proposta implements Serializable {

    /** Primary key. */
    protected static final String PK = "idproposta";

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
    private int idproposta;
    @Column(length=255)
    private String nome;
    @Column(length=255)
    private String descrizione;
    private Timestamp datainiziodisp;
    private Timestamp datafinedisp;
    @Column(name="disponibilità", precision=10)
    private int disponibilita;
    @Column(precision=10)
    private BigDecimal costounitario;
    @Column(length=255)
    private String posizione;
    private Timestamp datacreamodpr;
    @Column(precision=10)
    private int stato;
    @OneToMany(mappedBy="proposta")
    private Set<Prenotazione> prenotazione;
    @OneToMany(mappedBy="proposta")
    private Set<Commento> commento;
    @ManyToOne
    @JoinColumn(name="idbeneservizio")
    private Beneservizio beneservizio;
    @ManyToOne
    @JoinColumn(name="idproponente")
    private Proponente proponente;
    @OneToMany(mappedBy="proposta")
    private Set<Immagine> immagine;
    @OneToMany(mappedBy="proposta")
    private Set<Notifica> notifica;

    /** Default constructor. */
    public Proposta() {
        super();
    }

    /**
     * Access method for idproposta.
     *
     * @return the current value of idproposta
     */
    public int getIdproposta() {
        return idproposta;
    }

    /**
     * Setter method for idproposta.
     *
     * @param aIdproposta the new value for idproposta
     */
    public void setIdproposta(int aIdproposta) {
        idproposta = aIdproposta;
    }

    /**
     * Access method for nome.
     *
     * @return the current value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter method for nome.
     *
     * @param aNome the new value for nome
     */
    public void setNome(String aNome) {
        nome = aNome;
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
     * Access method for datainiziodisp.
     *
     * @return the current value of datainiziodisp
     */
    public Timestamp getDatainiziodisp() {
        return datainiziodisp;
    }

    /**
     * Setter method for datainiziodisp.
     *
     * @param aDatainiziodisp the new value for datainiziodisp
     */
    public void setDatainiziodisp(Timestamp aDatainiziodisp) {
        datainiziodisp = aDatainiziodisp;
    }

    /**
     * Access method for datafinedisp.
     *
     * @return the current value of datafinedisp
     */
    public Timestamp getDatafinedisp() {
        return datafinedisp;
    }

    /**
     * Setter method for datafinedisp.
     *
     * @param aDatafinedisp the new value for datafinedisp
     */
    public void setDatafinedisp(Timestamp aDatafinedisp) {
        datafinedisp = aDatafinedisp;
    }

    /**
     * Access method for disponibilita.
     *
     * @return the current value of disponibilita
     */
    public int getDisponibilita() {
        return disponibilita;
    }

    /**
     * Setter method for disponibilita.
     *
     * @param aDisponibilita the new value for disponibilita
     */
    public void setDisponibilita(int aDisponibilita) {
        disponibilita = aDisponibilita;
    }

    /**
     * Access method for costounitario.
     *
     * @return the current value of costounitario
     */
    public BigDecimal getCostounitario() {
        return costounitario;
    }

    /**
     * Setter method for costounitario.
     *
     * @param aCostounitario the new value for costounitario
     */
    public void setCostounitario(BigDecimal aCostounitario) {
        costounitario = aCostounitario;
    }

    /**
     * Access method for posizione.
     *
     * @return the current value of posizione
     */
    public String getPosizione() {
        return posizione;
    }

    /**
     * Setter method for posizione.
     *
     * @param aPosizione the new value for posizione
     */
    public void setPosizione(String aPosizione) {
        posizione = aPosizione;
    }

    /**
     * Access method for datacreamodpr.
     *
     * @return the current value of datacreamodpr
     */
    public Timestamp getDatacreamodpr() {
        return datacreamodpr;
    }

    /**
     * Setter method for datacreamodpr.
     *
     * @param aDatacreamodpr the new value for datacreamodpr
     */
    public void setDatacreamodpr(Timestamp aDatacreamodpr) {
        datacreamodpr = aDatacreamodpr;
    }

    /**
     * Access method for stato.
     *
     * @return the current value of stato
     */
    public int getStato() {
        return stato;
    }

    /**
     * Setter method for stato.
     *
     * @param aStato the new value for stato
     */
    public void setStato(int aStato) {
        stato = aStato;
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
     * Access method for beneservizio.
     *
     * @return the current value of beneservizio
     */
    public Beneservizio getBeneservizio() {
        return beneservizio;
    }

    /**
     * Setter method for beneservizio.
     *
     * @param aBeneservizio the new value for beneservizio
     */
    public void setBeneservizio(Beneservizio aBeneservizio) {
        beneservizio = aBeneservizio;
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
     * Access method for immagine.
     *
     * @return the current value of immagine
     */
    public Set<Immagine> getImmagine() {
        return immagine;
    }

    /**
     * Setter method for immagine.
     *
     * @param aImmagine the new value for immagine
     */
    public void setImmagine(Set<Immagine> aImmagine) {
        immagine = aImmagine;
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
     * Compares the key for this instance with another Proposta.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Proposta and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Proposta)) {
            return false;
        }
        Proposta that = (Proposta) other;
        if (this.getIdproposta() != that.getIdproposta()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Proposta.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Proposta)) return false;
        return this.equalKeys(other) && ((Proposta)other).equalKeys(this);
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
        i = getIdproposta();
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
        StringBuffer sb = new StringBuffer("[Proposta |");
        sb.append(" idproposta=").append(getIdproposta());
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
        ret.put("idproposta", Integer.valueOf(getIdproposta()));
        return ret;
    }

}
