package xyz.danicostas.model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Component
@Scope(value = "prototype")
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastName;
	@Temporal(value = TemporalType.DATE)
	private Date birthDate;
	private String username;
	private String email;
	private String password;
	@Exclude
	@ManyToMany
	@JoinTable(
			name = "users_films",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "film_id")
		)
	private List<Film> listOfFavoriteFilms;
	@Exclude
	@OneToMany(mappedBy = "id")
	private List<Review> listOfReviews;
	@Exclude
	@ManyToMany
	@JoinTable(
			name = "users_users",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
		)
	private List<User> listOfFriends;
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void setBirthdate(String birthdateStr) throws java.text.ParseException {
        this.birthDate = dateFormat.parse(birthdateStr);
    }
}
