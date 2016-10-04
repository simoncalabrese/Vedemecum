package model.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.entity.Card;
import model.entity.Card_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
public class CardDao extends BaseDaoImplementation {

    public Boolean insertCard(Card card) {
       return insert(card);

    }

    public Boolean editCard(Card card) {
        return update(card);

    }

    public Boolean deleteCard(Integer id) {
        return delete(findCard(id));

    }

    public Card findCard(Integer id) {

        return find(id, Card.class);
    }


    public List<Card> totCards() {
        return getAll(new Card());
    }


    public Integer findLastCard() {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaQuery<Integer> query = cb.createQuery(Integer.class);
        Root<Card> root = query.from(Card.class);
        query.select(cb.max(root.get(Card_.idScheda)));
        query.orderBy(cb.desc(root.get(Card_.idScheda)));
        return entityManager.createQuery(query).getSingleResult();
    }
}
