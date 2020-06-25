package filmography.service;

import filmography.model.Film;

import java.util.List;

public interface FilmService {
    List<Film> allFilms();

    void add(Film film);

    void delete(Integer id);

    void edit(Film film);

    Film getById(Integer id);
}