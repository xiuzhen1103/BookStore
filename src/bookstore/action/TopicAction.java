package bookstore.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bookstore.model.Category;
import bookstore.model.Topic;
import bookstore.service.TopicManager;

import com.opensymphony.xwork2.ActionSupport;

@Component("topic")
@Scope("prototype")
public class TopicAction  extends ActionSupport{
	private TopicManager topicManager;
	private Topic topic;
	private String message = "";
	private List<Topic> topics;
	
	public TopicManager getTopicManager() {
		return topicManager;
	}
	@Resource(name="topicManager")
	public void setTopicManager(TopicManager topicManager) {
		this.topicManager = topicManager;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception{
		topicManager.add(topic);
		return "success";
	}
	
	public String update() throws Exception {
		boolean updated = topicManager.update(topic);
		if(updated) {
			message = "update succeeded ";
			return "success";
		}
			message = "update failed";
		return "fail";
	}
	
	public String delete() throws Exception{
		boolean	deleted = topicManager.delete(topic);
		if(deleted) {
			message = "delete succeeded";
			return "success";
		}
		else {
			message = "delete failed, topic id is not exist";
			return "fail";
		}
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	

	public String list() throws Exception {
		this.topics = topicManager.getTopics();
		return "list";	
	}
	

	

}
