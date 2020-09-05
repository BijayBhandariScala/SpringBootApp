package com.bijay.springboot.practise;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {

	@Autowired
	private RoomRepository roomRepository;

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Room>> findAll(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
		if (StringUtils.isNotEmpty(roomNumber)) {
			return new ResponseEntity(Collections.singletonList(this.roomRepository.findByRoomNumber(roomNumber)), HttpStatus.OK);
		}
		return new ResponseEntity((List<Room>) this.roomRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("")
	@Transactional
	public ResponseEntity<Room> create(@RequestBody Room room) throws Exception {

		try {
			Room saveRoom = roomRepository.save(room);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{roomid}")
					.buildAndExpand(saveRoom.getId()).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			throw new Exception("Unable to post", ex);
		}

	}



}
