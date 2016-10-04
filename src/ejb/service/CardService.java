package ejb.service;

import api.dto.CardDto;
import api.dto.SpaceDto;
import model.dao.CardDao;
import model.entity.Card;

import java.util.List;

/**
 * Created by simon on 31/08/16.
 */
public class CardService extends BaseService<CardDao> {

    private CardDao cardDao = new CardDao();

    @Override
    public CardDao getDao() {
        return cardDao;
    }

    public Card getCardById(Integer id) {
        return getDao().findCard(id);
    }

    public Integer insertCard(CardDto cardDto) {
        Card card = new Card();
        card.setHeader(cardDto.getHeaderCard());
        card.setBottom(cardDto.getFooterCard());
        if (getDao().insertCard(card)) {
            return getLastIdCard();
        }
        return null;

    }

    private Integer getLastIdCard() {
        return getDao().findLastCard();
    }


    public List<SpaceDto> getAllSpace() {
        return null;
    }

}
