package co.grandcircus.restaRating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.restaRating.daos.RatingDao;
import co.grandcircus.restaRating.entities.Rating;

@Controller
public class RestaRatingController {

	@Autowired
	private RatingDao dao;

//	@RequestMapping("/")
//	public ModelAndView index(@RequestParam("ratte") int rating) {
//		List<Rating> theRatings = dao.findAll();
//		ModelAndView mv = new ModelAndView("rating");
//
//		Collections.sort((List<Rating>) theRatings);
//		for (Rating rate : theRatings) {
//			System.out.println(rate);
//		}
//
//		return mv;
//
//	}

	@RequestMapping("/")
	public ModelAndView index() {
		List<Rating> theRatings = dao.findAll();
		ModelAndView mv = new ModelAndView("rating");
		mv.addObject("rating", theRatings);
		return mv;

	}

//	@RequestMapping("/")
//	public ModelAndView index(@RequestParam(value = "sortByName", required = false) String sortByName,
//			@RequestParam(value = "sortByRating", required = false) String sortByRating) {
//		List<Rating> theRatings = dao.findAll();
//		ModelAndView mv = new ModelAndView("rating");
//
//		if (sortByName != null && !sortByName.isEmpty()) {
//			mv.addObject("rating", RatingDao.findByKeyword(sortByName));
//		} else if (sortByRating != null && !sortByRating.isEmpty()) {
//			mv.addObject("rating", RatingDao.findByCategory(sortByRating));
//		} else {
//			mv.addObject("rating", RatingDao.findAll());
//		}
//		// list of categories needed for <select>
//		mv.addObject("categories", RatingDao.findAllCategories());
//		mv.addObject("rating", theRatings);
//		return mv;
//
//	}



	/*
	 * @RequestMapping("/rating") public String nuberCheck(Rating rating) {
	 * 
	 * rating.addAttribute("commentValue", numberValue);
	 * 
	 * return "numberCheck"; }
	 * 
	 * @PostMapping("/rating") public String check(Rating rating, @RequestParam int
	 * rating) {
	 * 
	 * System.out.println(rating);
	 * 
	 * if (rating.equals("upvote")) { numberValue++;
	 * rating.addAttribute("numberValue", numberValue); }
	 * 
	 * if (rating.equals("dowvnote")) { numberValue--;
	 * rating.addAttribute("numberValue", numberValue); } return "numberCheck"; }
	 */




}
