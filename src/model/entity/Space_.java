package model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Space.class)
public abstract class Space_ {

	public static volatile SingularAttribute<Space, String> addImpianto;
	public static volatile SingularAttribute<Space, Integer> roomNo;
	public static volatile SingularAttribute<Space, Integer> windowsNo;
	public static volatile ListAttribute<Space, SpaceEmployee> spaceEmployees;
	public static volatile SingularAttribute<Space, String> desImpianto;
	public static volatile SingularAttribute<Space, Integer> idImpianto;
	public static volatile SingularAttribute<Space, Integer> doorNo;

}

