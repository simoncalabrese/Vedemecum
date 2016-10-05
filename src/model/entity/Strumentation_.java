package model.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Strumentation.class)
public abstract class Strumentation_ {

	public static volatile SingularAttribute<Strumentation, String> desStrumentazione;
	public static volatile SingularAttribute<Strumentation, Date> dtAcquisto;
	public static volatile SingularAttribute<Strumentation, String> marcaStrumentazione;
	public static volatile ListAttribute<Strumentation, EmployeeStrumentation> employeeStrumentations;
	public static volatile SingularAttribute<Strumentation, Integer> idStrumentazione;
	public static volatile SingularAttribute<Strumentation, String> modelloStrumentazione;
	public static volatile SingularAttribute<Strumentation, Integer> pezzi;

}

