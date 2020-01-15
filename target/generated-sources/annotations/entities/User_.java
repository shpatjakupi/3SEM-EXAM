package entities;

import javax.annotation.Generated;
import javax.management.relation.Role;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-15T23:39:33")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> userPass;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile ListAttribute<User, Role> roleList;

}