package co.grandcircus.restaRating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.restaRating.daos.RatingDao;
import co.grandcircus.restaRating.entities.Rating;

@Controller
public class RestaRatingController {

	@Autowired
	private RatingDao dao;


	@RequestMapping("/")
	public ModelAndView index() {
		List<Rating> theRatings = dao.findAll();
		ModelAndView mv = new ModelAndView("rating");
		mv.addObject("rating", theRatings);
		return mv;

	}

	@RequestMapping("/rating/upvote")
	public ModelAndView upvote(@RequestParam("id") Long id) {
		dao.upvote(id);
		return new ModelAndView("redirect:/");

	}

	@RequestMapping("/rating/downvote")
	public ModelAndView downvote(@RequestParam("id") Long id) {
		dao.downvote(id);
		return new ModelAndView("redirect:/");

	}









}
