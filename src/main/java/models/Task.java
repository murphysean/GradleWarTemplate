package models;

import java.util.List;

public class Task{
	private Integer id;
	private String title;
	private Boolean finished = false;
	private List<String> tags;

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public boolean isFinished(){
		return finished;
	}

	public void setFinished(Boolean finished){
		this.finished = finished;
	}

	public List<String> getTags(){
		return tags;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}
}
