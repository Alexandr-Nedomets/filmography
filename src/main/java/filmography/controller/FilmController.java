package filmography.controller;

import filmography.model.Film;
import filmography.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping(value = "/films")
    public ModelAndView allFilms() {
        List<Film> films = filmService.allFilms();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", films);

        return modelAndView;
    }


    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") Integer id) {
        Film film = filmService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("film", film);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/films");
        filmService.edit(film);

        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addFilm(@ModelAttribute Film film) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/films");
        filmService.add(film);

        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteFilm(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/films");
        filmService.delete(id);
        return modelAndView;
    }
}
