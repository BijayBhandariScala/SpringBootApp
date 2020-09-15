package com.bijay.springboot.practise;

import java.math.BigInteger;
import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TaskBoard>> findAll(@RequestParam(name = "_id", required = false) ObjectId id) {
		if (id!=null) {
			return new ResponseEntity(Collections.singletonList(this.taskRepository.findById(id)), HttpStatus.OK);
		}
		return new ResponseEntity(this.taskRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(value=  "/savetask")
	@Transactional
	public ResponseEntity<TaskBoard> create(@RequestBody TaskBoard taskBoard) throws Exception {

		try {
			TaskBoard saveTaskBoard = taskRepository.insert(taskBoard);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(saveTaskBoard.get_id()).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			throw new Exception("Unable to post", ex);
		}

	}

	@DeleteMapping(value=  "/removetask")
     public TaskBoard removeRoom(@RequestParam TaskBoard taskBoard){
		taskRepository.deleteById(taskBoard.get_id());
		return taskBoard;
	 }

}
