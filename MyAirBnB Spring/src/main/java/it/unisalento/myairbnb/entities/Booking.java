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

@Entity(name="booking")
public class Booking implements Serializable {

    /** Primary key. */
    protected static final String PK = "idbooking";

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
    private int idbooking;
    @Column(length=12)
    private float price;
    @Column(name="start_date")
    private Timestamp startDate;
    @Column(precision=10)
    private int days;
    @ManyToOne(optional=false)
    @JoinColumn(name="idapartment", nullable=false)
    private Apartment apartment;
    @ManyToOne(optional=false)
    @JoinColumn(name="iduser", nullable=false)
    private User user;

    /** Default constructor. */
    public Booking() {
        super();
    }

    /**
     * Access method for idbooking.
     *
     * @return the current value of idbooking
     */
    public int getIdbooking() {
        return idbooking;
    }

    /**
     * Setter method for idbooking.
     *
     * @param aIdbooking the new value for idbooking
     */
    public void setIdbooking(int aIdbooking) {
        idbooking = aIdbooking;
    }

    /**
     * Access method for price.
     *
     * @return the current value of price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Setter method for price.
     *
     * @param aPrice the new value for price
     */
    public void setPrice(float aPrice) {
        price = aPrice;
    }

    /**
     * Access method for startDate.
     *
     * @return the current value of startDate
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * Setter method for startDate.
     *
     * @param aStartDate the new value for startDate
     */
    public void setStartDate(Timestamp aStartDate) {
        startDate = aStartDate;
    }

    /**
     * Access method for days.
     *
     * @return the current value of days
     */
    public int getDays() {
        return days;
    }

    /**
     * Setter method for days.
     *
     * @param aDays the new value for days
     */
    public void setDays(int aDays) {
        days = aDays;
    }

    /**
     * Access method for apartment.
     *
     * @return the current value of apartment
     */
    public Apartment getApartment() {
        return apartment;
    }

    /**
     * Setter method for apartment.
     *
     * @param aApartment the new value for apartment
     */
    public void setApartment(Apartment aApartment) {
        apartment = aApartment;
    }

    /**
     * Access method for user.
     *
     * @return the current value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter method for user.
     *
     * @param aUser the new value for user
     */
    public void setUser(User aUser) {
        user = aUser;
    }

    /**
     * Compares the key for this instance with another Booking.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Booking and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Booking)) {
            return false;
        }
        Booking that = (Booking) other;
        if (this.getIdbooking() != that.getIdbooking()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Booking.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Booking)) return false;
        return this.equalKeys(other) && ((Booking)other).equalKeys(this);
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
        i = getIdbooking();
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
        StringBuffer sb = new StringBuffer("[Booking |");
        sb.append(" idbooking=").append(getIdbooking());
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
        ret.put("idbooking", Integer.valueOf(getIdbooking()));
        return ret;
    }

}
