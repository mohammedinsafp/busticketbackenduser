package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Bus;
import com.example.demo.Service.BusService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BusController {
	@Autowired
	private BusService busService;
	@PostMapping("/bus")
	public ResponseEntity<Bus> createCountry(@RequestBody Bus bus) {
		busService.addBus(bus);	
		return ResponseEntity.ok(bus);		
	}
	@DeleteMapping("/bus/{id}")
	public ResponseEntity<Bus> deleteUser(@PathVariable int id) {
		busService.deletebus(id);
				return new ResponseEntity<>(HttpStatus.OK);
		}
	@PutMapping("/bus/{id}") 
	public Bus updateBus(@PathVariable int id,@RequestBody Bus bus ) {
		busService.updateBus(id,bus);
		return bus;
		}
	@GetMapping("/buses")
	public List<Bus> getAllBus(){
		List<Bus> buses=busService.gellBuses();
		return buses;
	}
}
