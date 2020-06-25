package filmography.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "films")
public class Film  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "years")
    private Integer year;

    @Column(name = "genre")
    private String genre;

    @Column(name = "watched")
    private String watched;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getWatched() {
        return watched;
    }

    public void setWatched(String watched) {
        this.watched = watched;
    }

    @Override
    public String toString() {
        return "id="+id +
                " title=" + title +
                " year=" + year +
                " genre=" + genre +
                " watched=" + watched;

    }
}