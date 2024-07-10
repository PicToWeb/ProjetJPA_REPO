package com.imdb.jpa.entities;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** name */
	@Column(name = "name", length = 60)
	private String name;

	/** url */
	@Column(name = "url", length = 200)
	private String url;
	
	/** movies */
	@OneToMany(mappedBy = "country")
	private Set<Movie> movies;
	
	/** adresses */
	@OneToMany(mappedBy = "country")
	private Set<Address> adresses;

	/** Constructor
	 *
	 */
	public Country() {
	}

	/** Constructor
	 * @param name
	 * @param url
	 */
	public Country(String name, String url) {
		this.name = name;
		this.url = url;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Country country = (Country) o;
		return Objects.equals(name, country.name) && Objects.equals(url, country.url);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, url);
	}

	/** Getter for nom
	 * @return the nom
	 */
	public String getName() {
		return name ;
	}

	/** Setter for nom
	 * @param name the nom to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Getter for url
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/** Setter for url
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Pays [nom= " + name + ", url= " + url + "] \n";
	}
	
	
	

}
