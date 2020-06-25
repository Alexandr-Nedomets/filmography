package filmography.dao;

import filmography.model.Film;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FilmDAOImpl implements FilmDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Film> allFilms() {
        TypedQuery<Film> queryFilm = em.createQuery("from Film f", Film.class);

        return queryFilm.getResultList();
    }

    @Override
    public void add(Film film) {
        em.merge(film);
    }

    @Override
    public void delete(Film film) {
        em.remove(film);
    }

    @Override
    public void edit(Film film) {
        em.merge(film);
    }

    @Override
    public Film getById(Integer id) {
        return em.find(Film.class, id);
    }
}