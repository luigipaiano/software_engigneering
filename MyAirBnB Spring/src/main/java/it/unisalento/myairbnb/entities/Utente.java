// Generated with g9.

package it.unisalento.myairbnb.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="utente", indexes={@Index(name="utente_username_IX", columnList="username", unique=true), @Index(name="utente_email_IX", columnList="email", unique=true)})
public class Utente implements Serializable {

    /** Primary key. */
    protected static final String PK = "idutente";

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
    private int idutente;
    @Column(length=255)
    private String nome;
    @Column(length=255)
    private String cognome;
    @Column(unique=true, nullable=false, length=255)
    private String username;
    @Column(nullable=false, length=255)
    private String password;
    @Column(unique=true, nullable=false, length=255)
    private String email;
    private Timestamp ultimologin;
    @Column(precision=10)
    private int status;
    @OneToMany(mappedBy="utente")
    private Set<Proponente> proponente;
    @OneToMany(mappedBy="utente")
    private Set<Acquirente> acquirente;
    @OneToMany(mappedBy="utente")
    private Set<Admin> admin;

    /** Default constructor. */
    public Utente() {
        super();
    }

    /**
     * Access method for idutente.
     *
     * @return the current value of idutente
     */
    public int getIdutente() {
        return idutente;
    }

    /**
     * Setter method for idutente.
     *
     * @param aIdutente the new value for idutente
     */
    public void setIdutente(int aIdutente) {
        idutente = aIdutente;
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
     * Access method for cognome.
     *
     * @return the current value of cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Setter method for cognome.
     *
     * @param aCognome the new value for cognome
     */
    public void setCognome(String aCognome) {
        cognome = aCognome;
    }

    /**
     * Access method for username.
     *
     * @return the current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username.
     *
     * @param aUsername the new value for username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for ultimologin.
     *
     * @return the current value of ultimologin
     */
    public Timestamp getUltimologin() {
        return ultimologin;
    }

    /**
     * Setter method for ultimologin.
     *
     * @param aUltimologin the new value for ultimologin
     */
    public void setUltimologin(Timestamp aUltimologin) {
        ultimologin = aUltimologin;
    }

    /**
     * Access method for status.
     *
     * @return the current value of status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Setter method for status.
     *
     * @param aStatus the new value for status
     */
    public void setStatus(int aStatus) {
        status = aStatus;
    }

    /**
     * Access method for proponente.
     *
     * @return the current value of proponente
     */
    public Set<Proponente> getProponente() {
        return proponente;
    }

    /**
     * Setter method for proponente.
     *
     * @param aProponente the new value for proponente
     */
    public void setProponente(Set<Proponente> aProponente) {
        proponente = aProponente;
    }

    /**
     * Access method for acquirente.
     *
     * @return the current value of acquirente
     */
    public Set<Acquirente> getAcquirente() {
        return acquirente;
    }

    /**
     * Setter method for acquirente.
     *
     * @param aAcquirente the new value for acquirente
     */
    public void setAcquirente(Set<Acquirente> aAcquirente) {
        acquirente = aAcquirente;
    }

    /**
     * Access method for admin.
     *
     * @return the current value of admin
     */
    public Set<Admin> getAdmin() {
        return admin;
    }

    /**
     * Setter method for admin.
     *
     * @param aAdmin the new value for admin
     */
    public void setAdmin(Set<Admin> aAdmin) {
        admin = aAdmin;
    }

    /**
     * Compares the key for this instance with another Utente.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Utente and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Utente)) {
            return false;
        }
        Utente that = (Utente) other;
        if (this.getIdutente() != that.getIdutente()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Utente.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Utente)) return false;
        return this.equalKeys(other) && ((Utente)other).equalKeys(this);
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
        i = getIdutente();
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
        StringBuffer sb = new StringBuffer("[Utente |");
        sb.append(" idutente=").append(getIdutente());
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
        ret.put("idutente", Integer.valueOf(getIdutente()));
        return ret;
    }

}
