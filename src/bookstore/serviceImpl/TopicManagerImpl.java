package bookstore.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import bookstore.dao.TopicDao;
import bookstore.model.Topic;
import bookstore.service.TopicManager;
@Component("topicManager")
public class TopicManagerImpl implements TopicManager{
	private TopicDao topicDao;

	@Override
	public void add(Topic topic) throws DataAccessException {
		topicDao.save(topic);
		
	}

	@Override
	public List<Topic> getTopics() throws Exception {
		return topicDao.getTopics();
	}


	public TopicDao getTopicDao() {
		return topicDao;
	}
	@Resource
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	@Override
	public boolean delete(Topic topic) throws Exception {
		return topicDao.deleteTopic(topic.getTopicId());
	}

	@Override
	public boolean update(Topic topic) throws Exception {
		return topicDao.updateTopic(topic.getTopicId(), topic.getName());
	}

	@Override
	public Topic get(Topic topic) throws Exception {
		return topicDao.getByTopicId(topic.getTopicId());
	}



}
