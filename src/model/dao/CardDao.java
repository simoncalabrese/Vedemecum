package model.dao;

import model.entity.Card;

import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
public class CardDao extends BaseDaoImplementation {

    public void insertCard(Card card) {
        insert(card);

    }

    public void editCard(Card card) {
        update(card);

    }

    public void deleteCard(Integer id) {
        delete(findCard(id));

    }

    public Card findCard(Integer id) {

        return find(id, Card.class);
    }


    public List<Card> totCards() {
        return getAll(new Card());
    }


}
