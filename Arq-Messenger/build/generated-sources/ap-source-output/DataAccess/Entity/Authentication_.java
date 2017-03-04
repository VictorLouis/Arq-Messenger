package DataAccess.Entity;

import DataAccess.Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-03T06:07:45")
@StaticMetamodel(Authentication.class)
public class Authentication_ { 

    public static volatile SingularAttribute<Authentication, String> password;
    public static volatile SingularAttribute<Authentication, Integer> userId;
    public static volatile SingularAttribute<Authentication, User> user;
    public static volatile SingularAttribute<Authentication, String> lastConnection;

}