package model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "reviews")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	@Temporal(value = TemporalType.DATE)
	private Date dateWritten;
	@Exclude
	@ManyToOne
	@JoinColumn(name = "fk_id_user", referencedColumnName = "id")
	private User userWhoWrote;
	@Exclude
	@ManyToOne
	private Film filmRewieved;
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void setDateWritten(String dateStr) throws java.text.ParseException {
        this.dateWritten = dateFormat.parse(dateStr);
    }

}
