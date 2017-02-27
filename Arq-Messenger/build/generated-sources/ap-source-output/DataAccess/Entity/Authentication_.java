package DataAccess.Entity;

import DataAccess.Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-26T21:24:03")
@StaticMetamodel(Authentication.class)
public class Authentication_ { 

    public static volatile SingularAttribute<Authentication, Integer> idUser;
    public static volatile SingularAttribute<Authentication, String> password;
    public static volatile SingularAttribute<Authentication, Integer> id;
    public static volatile SingularAttribute<Authentication, User> user;
    public static volatile SingularAttribute<Authentication, String> lastConnection;

}