package model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "actors")
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastName;
	@Temporal(value = TemporalType.DATE)
	private Date birthDate;
	@Exclude
	@ManyToMany
	@JoinTable(
			name = "actors_films",
			joinColumns = @JoinColumn(name = "actor_id"),
			inverseJoinColumns = @JoinColumn(name = "film_id")
		)
	private List<Film> listOfFilmsStarring;
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void setBirthdate(String birthdateStr) throws java.text.ParseException {
        this.birthDate = dateFormat.parse(birthdateStr);
    }
}
