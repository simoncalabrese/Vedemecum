package ejb.service;

import api.dto.CardDto;
import ejb.converter.CardConverter;
import model.dao.CardDao;
import model.dao.EmployeeDao;
import model.dao.SpaceDao;
import model.dao.StrumentationDao;
import model.entity.Card;
import model.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by simon on 31/08/16.
 */
public class CardService extends BaseService<CardDao> {

    private CardDao cardDao = new CardDao();
    private EmployeeDao employeeDao = new EmployeeDao();
    private SpaceDao spaceDao = new SpaceDao();
    private StrumentationDao strumentationDao = new StrumentationDao();

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
        card.setEmployees(cardDto.getEmployeeDtos()
                .stream()
                .map(elem -> employeeDao.findEmployee(elem))
                .collect(Collectors.toList()));
        card.setSpaces(cardDto.getSpaceDtos()
                .stream()
                .map(elem -> spaceDao.findSpace(elem))
                .collect(Collectors.toList()));
        card.setStrumentations(cardDto.getStrumentationDtos()
                .stream()
                .map(elem -> strumentationDao.findStrumentation(elem))
                .collect(Collectors.toList()));

        if (getDao().insertCard(card)) {
            return getLastIdCard();
        }
        return null;

    }

    public List<CardDto> getAllCards(){
        return converter(getDao().totCards(),CardConverter.ToDto.toCardDtoId);
    }

    private Integer getLastIdCard() {

        return getDao().findLastCard();
    }


}
