package DataAccess.Entity;

import DataAccess.Entity.Authentication;
import DataAccess.Entity.Conversation;
import DataAccess.Entity.Event;
import DataAccess.Entity.Message;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-03T06:07:45")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile CollectionAttribute<User, Event> eventCollection;
    public static volatile CollectionAttribute<User, Message> messageCollection;
    public static volatile SingularAttribute<User, String> name;
    public static volatile CollectionAttribute<User, Conversation> conversationCollection;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, Authentication> authentication;

}