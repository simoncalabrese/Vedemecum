package model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Card.class)
public abstract class Card_ {

	public static volatile SingularAttribute<Card, Integer> idScheda;
	public static volatile SingularAttribute<Card, String> bottom;
	public static volatile SingularAttribute<Card, String> header;
	public static volatile ListAttribute<Card, Sdsi> schedaDipStrumImp;

}

