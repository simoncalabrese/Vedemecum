package model.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, Integer> idDipedente;
	public static volatile SingularAttribute<Employee, String> codFiscale;
	public static volatile SingularAttribute<Employee, String> address;
	public static volatile SingularAttribute<Employee, Role> role;
	public static volatile ListAttribute<Employee, SpaceEmployee> spaceEmployees;
	public static volatile SingularAttribute<Employee, String> telephone;
	public static volatile SingularAttribute<Employee, String> nomeDipendente;
	public static volatile SingularAttribute<Employee, String> sessoDipendente;
	public static volatile SingularAttribute<Employee, Date> dtNascita;
	public static volatile ListAttribute<Employee, EmployeeStrumentation> employeeStrumentations;
	public static volatile SingularAttribute<Employee, String> cognomeDipendente;
	public static volatile SingularAttribute<Employee, String> email;

}

