package DataAccess.Entity;

import DataAccess.Entity.EventPK;
import DataAccess.Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-26T21:24:03")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, String> descripcion;
    public static volatile SingularAttribute<Event, EventPK> eventPK;
    public static volatile SingularAttribute<Event, String> nombre;
    public static volatile SingularAttribute<Event, User> user;

}