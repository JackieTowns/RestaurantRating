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

}
