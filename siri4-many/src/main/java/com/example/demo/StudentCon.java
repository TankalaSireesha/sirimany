package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCon {
		@Autowired
		private StudentRepo sr;
		
		@GetMapping("/student/{pageNo}/{pageSize}")
		public List<Student>getAll(@PathVariable int pageNo,@PathVariable int pageSize){
			PageRequest p1=PageRequest.of(pageNo, pageSize);
			Page<Student>p2=sr.findAll(p1);
			return p2.toList();
		}
		@GetMapping("/student/sorting")
		public List<Student>getAll(){
			return sr.findAll(Sort.by(Direction.ASC, "fName"));
		}
		@GetMapping("/student/{id}")
		public Optional<Student> getById(@PathVariable Integer id){
			return sr.findById(id);
		}
		@PostMapping("/student")
		public Student c(@RequestBody Student s1) {
			return sr.save(s1);
		}
		@PutMapping("/student/{id}")
		public Student u(@PathVariable Integer id,@RequestBody Student s2){
			return sr.findById(id).map(e->{e.setfName(s2.getlName());
			return sr.save(e);
				
			}).orElse(null);
		}
		@DeleteMapping("/student/{id}")
		public void d(@PathVariable Integer id) {
			sr.deleteById(id);
		}
}
