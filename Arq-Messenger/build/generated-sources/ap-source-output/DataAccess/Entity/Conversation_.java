package DataAccess.Entity;

import DataAccess.Entity.Message;
import DataAccess.Entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-26T21:24:03")
@StaticMetamodel(Conversation.class)
public class Conversation_ { 

    public static volatile SingularAttribute<Conversation, Date> date;
    public static volatile CollectionAttribute<Conversation, Message> messageCollection;
    public static volatile CollectionAttribute<Conversation, User> userCollection;
    public static volatile SingularAttribute<Conversation, Integer> id;

}