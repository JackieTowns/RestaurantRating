package co.grandcircus.restaRating.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.grandcircus.restaRating.entities.Rating;

@Repository
@Transactional
public class RatingDao {

	@PersistenceContext
	EntityManager em;

	public List<Rating> findAll() {

		List<Rating> theRatings = em.createQuery("FROM Rating", Rating.class).getResultList();
		return theRatings;
	}

	public Rating findById(Long id) {
		return em.find(Rating.class, id);
	}

	public void create(Rating ratings) {
		em.persist(ratings);
	}

	public void update(Rating ratings) {
		em.merge(ratings);
	}

	public void delete(Long id) {
		Rating ratings = em.getReference(Rating.class, id);
		em.remove(ratings);
	}

	public void upvote(long id) {
		Rating upvote = em.getReference(Rating.class, id);
		int up = upvote.getRating() + 1;
		if (up > 10) {
			upvote.setRating(10);
		} else {
			upvote.setRating(up);
		}

		em.merge(upvote);
	}

	public void downvote(long id) {
		Rating downvote = em.getReference(Rating.class, id);
		int down = downvote.getRating() - 1;
		if (down < 0) {
			downvote.setRating(0);
		} else {
			downvote.setRating(down);
		}

		em.merge(downvote);
	}

}
