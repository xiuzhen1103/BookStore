package bookstore.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.Topic;

public interface TopicManager {
	public boolean delete(Topic topic) throws Exception;
	public void add(Topic topic) throws DataAccessException;
	public boolean update(Topic topic) throws Exception;
	public List<Topic> getTopics() throws Exception;

}
