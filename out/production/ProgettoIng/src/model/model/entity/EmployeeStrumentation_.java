package model.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmployeeStrumentation.class)
public abstract class EmployeeStrumentation_ {

	public static volatile SingularAttribute<EmployeeStrumentation, Date> dtAssign;
	public static volatile SingularAttribute<EmployeeStrumentation, Strumentation> strumentation;
	public static volatile SingularAttribute<EmployeeStrumentation, Integer> id;
	public static volatile SingularAttribute<EmployeeStrumentation, Employee> employee;

}

