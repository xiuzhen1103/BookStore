package bookstore.daoImpl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import bookstore.dao.TopicDao;
import bookstore.model.Book;
import bookstore.model.Category;
import bookstore.model.Customer;
import bookstore.model.Topic;
@Component("topicDao")
public class TopicDaoImpl implements TopicDao{
	private HibernateTemplate hibernateTemplate; 

	@Override
	public boolean deleteTopic(final Integer topicId) throws DataAccessException {
		List<Topic> topics = hibernateTemplate.find("from Topic t where t.topicId = '" + topicId + "'");

		if(topics != null && topics.size() > 0) {
			hibernateTemplate.executeWithNativeSession(
					new HibernateCallback() {
						@Override
						public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
							return session.createQuery
							("delete Topic t where t.topicId='"+ topicId + "'").executeUpdate();
						}					
					});
			
			return true;
		}
		return false;
	}


	@Override
	public void save(Topic topic) throws DataAccessException {
		hibernateTemplate.save(topic);
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public boolean updateTopic(Integer topicId, String name)
			throws DataAccessException {
		Topic topic = (Topic) this.hibernateTemplate.load(Topic.class,topicId);
		if(topic!=null) {
			topic.setName(name);
			return true;
		}
		return false;
	}


	@Override
	public List<Topic> getTopics() throws DataAccessException {
		return (List<Topic>)this.hibernateTemplate.find("from Topic");
	}


	@Override
	public Topic getByTopicId(Integer topicId) throws DataAccessException {
		return (Topic) this.hibernateTemplate.get(Topic.class, topicId);
	}

}
