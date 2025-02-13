package model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "films")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@Temporal(value = TemporalType.DATE)
	private Date dateReleased;
	private double rating;
	@Exclude
	@ManyToOne
	@JoinColumn(name = "fk_id_director", referencedColumnName = "id")
	private Director director;
	@Exclude
	@ManyToMany(mappedBy = "listOfFilmsStarring")
	private List<Actor> listOfActors;
	@Exclude
	@ManyToMany(mappedBy = "listOfFavoriteFilms")
	private List<User> listOfUsersThatLikeThisFilm;
	@Exclude
	@OneToMany(mappedBy = "filmRewieved")
	private List<Review> listOfReviews;
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void setDateReleased(String dateStr) throws java.text.ParseException {
        this.dateReleased = dateFormat.parse(dateStr);
    }
	
}
