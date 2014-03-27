package bookstore.dao;
import java.util.List;
import org.springframework.dao.DataAccessException;

import bookstore.model.Category;
import bookstore.model.Topic;

public interface TopicDao {
	public boolean deleteTopic(Integer topicId) throws DataAccessException;
	public void save(Topic topic) throws DataAccessException;
	public boolean updateTopic(Integer topicId, String Name) throws DataAccessException;
	public List<Topic> getTopics() throws DataAccessException;
}
