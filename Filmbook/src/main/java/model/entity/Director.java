package model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "directors")
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastName;
	@Temporal(value = TemporalType.DATE)
	private Date birthDate;
	@Exclude
	@OneToMany(mappedBy = "director")
	private List<Film> listOfFilmsDirected;
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void setBirthdate(String birthdateStr) throws java.text.ParseException {
        this.birthDate = dateFormat.parse(birthdateStr);
    }
}
