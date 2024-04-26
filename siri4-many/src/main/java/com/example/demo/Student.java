package com.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Student {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		
		private Integer id;
		private String fName;
		private String lName;
		
		@ManyToMany(cascade=CascadeType.ALL)
		@JoinTable(name="stu_book",joinColumns=@JoinColumn(name="stu_id",referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="book_id",referencedColumnName="id"))
		
		private Set<Book> book=new HashSet<>();

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Student(Integer id, String fName, String lName, Set<Book> book) {
			super();
			this.id = id;
			this.fName = fName;
			this.lName = lName;
			this.book = book;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getfName() {
			return fName;
		}

		public void setfName(String fName) {
			this.fName = fName;
		}

		public String getlName() {
			return lName;
		}

		public void setlName(String lName) {
			this.lName = lName;
		}

		public Set<Book> getBook() {
			return book;
		}

		public void setBook(Set<Book> book) {
			this.book = book;
		}

				
}
