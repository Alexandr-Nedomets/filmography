package filmography.service;

import filmography.dao.FilmDAO;
import filmography.model.Film;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private static final Logger LOG = LoggerFactory.getLogger(FilmServiceImpl.class);

    @Autowired
    private FilmDAO filmDAO;

    @Override
    public List<Film> allFilms() {
        LOG.info("Получен список всех фильмов");
        return filmDAO.allFilms();

    }

    @Override
    @Transactional
    public void add(Film film) {
        filmDAO.add(film);
        LOG.info("Добавлен фильм: {}", film);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Film film = getById(id);
        filmDAO.delete(film);
        LOG.info("Удален фильм: {}", film);
    }

    @Override
    @Transactional
    public void edit(Film film) {
        filmDAO.edit(film);
        LOG.info("Изменен фильм: {}", film);
    }

    @Override
    public Film getById(Integer id) {
        return filmDAO.getById(id);
    }
}
