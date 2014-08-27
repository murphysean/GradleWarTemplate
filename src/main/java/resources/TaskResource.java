package resources;

import models.Task;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path(value = "/tasks/")
public class TaskResource{
	public static List<Task> tasks = new ArrayList<>();

	@GET
	public Response getTasks(@QueryParam(value="finished") @DefaultValue(value="false") String finished){
		ArrayList<Task> ret = new ArrayList<>();
		for(Task t : tasks){
			if(t.isFinished() == Boolean.parseBoolean(finished))
				ret.add(t);
		}
		return Response.ok(ret).build();
	}

	@GET
	@Path(value = "/{id}")
	public Response getTask(@PathParam(value="id") int id){
		Task task = tasks.get(id);
		task.setId(id);
		return Response.ok(task).build();
	}

	@POST
	public Response addTask(Task task){
		tasks.add(task);
		task.setId(tasks.size() - 1);
		task.setFinished(false);
		return Response.created(URI.create(Integer.toString(task.getId()))).build();
	}

	@PUT
	@Path(value = "/{id}")
	public Response updateTask(@PathParam(value = "id") int id,Task task){
		task.setId(id);
		task.setFinished(true);
		tasks.set(id,task);
		return Response.ok(task).build();
	}
}
