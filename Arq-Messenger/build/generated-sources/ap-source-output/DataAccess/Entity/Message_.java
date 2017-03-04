package DataAccess.Entity;

import DataAccess.Entity.Conversation;
import DataAccess.Entity.MessagePK;
import DataAccess.Entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-03T06:07:45")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, Date> date;
    public static volatile SingularAttribute<Message, Integer> idUser;
    public static volatile SingularAttribute<Message, MessagePK> messagePK;
    public static volatile SingularAttribute<Message, String> text;
    public static volatile SingularAttribute<Message, User> user;
    public static volatile SingularAttribute<Message, Conversation> conversation;

}