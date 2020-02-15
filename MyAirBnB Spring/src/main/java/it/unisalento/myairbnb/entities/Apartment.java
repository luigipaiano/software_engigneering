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

@Entity(name="apartment")
public class Apartment implements Serializable {

    /** Primary key. */
    protected static final String PK = "idapartment";

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
    private int idapartment;
    @Column(nullable=false, length=255)
    private String name;
    @Column(length=500)
    private String description;
    @Column(nullable=false, length=12)
    private float price;
    @Column(length=12)
    private float lat;
    @Column(length=12)
    private float lon;
    @OneToMany(mappedBy="apartment")
    private Set<Booking> booking;

    /** Default constructor. */
    public Apartment() {
        super();
    }

    /**
     * Access method for idapartment.
     *
     * @return the current value of idapartment
     */
    public int getIdapartment() {
        return idapartment;
    }

    /**
     * Setter method for idapartment.
     *
     * @param aIdapartment the new value for idapartment
     */
    public void setIdapartment(int aIdapartment) {
        idapartment = aIdapartment;
    }

    /**
     * Access method for name.
     *
     * @return the current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     *
     * @param aName the new value for name
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Access method for description.
     *
     * @return the current value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description.
     *
     * @param aDescription the new value for description
     */
    public void setDescription(String aDescription) {
        description = aDescription;
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
     * Access method for lat.
     *
     * @return the current value of lat
     */
    public float getLat() {
        return lat;
    }

    /**
     * Setter method for lat.
     *
     * @param aLat the new value for lat
     */
    public void setLat(float aLat) {
        lat = aLat;
    }

    /**
     * Access method for lon.
     *
     * @return the current value of lon
     */
    public float getLon() {
        return lon;
    }

    /**
     * Setter method for lon.
     *
     * @param aLon the new value for lon
     */
    public void setLon(float aLon) {
        lon = aLon;
    }

    /**
     * Access method for booking.
     *
     * @return the current value of booking
     */
    public Set<Booking> getBooking() {
        return booking;
    }

    /**
     * Setter method for booking.
     *
     * @param aBooking the new value for booking
     */
    public void setBooking(Set<Booking> aBooking) {
        booking = aBooking;
    }

    /**
     * Compares the key for this instance with another Apartment.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Apartment and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Apartment)) {
            return false;
        }
        Apartment that = (Apartment) other;
        if (this.getIdapartment() != that.getIdapartment()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Apartment.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Apartment)) return false;
        return this.equalKeys(other) && ((Apartment)other).equalKeys(this);
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
        i = getIdapartment();
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
        StringBuffer sb = new StringBuffer("[Apartment |");
        sb.append(" idapartment=").append(getIdapartment());
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
        ret.put("idapartment", Integer.valueOf(getIdapartment()));
        return ret;
    }

}
