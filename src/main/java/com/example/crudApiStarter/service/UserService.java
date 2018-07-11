		package com.example.crudApiStarter.service;
		
		import java.util.ArrayList;
		import java.util.Arrays;
		import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.stereotype.Service;
		
		import com.example.crudApiStarter.entity.User;
		import com.example.crudApiStarter.repository.UserRepository;
		
		@Service
		public class UserService {
			
			@Autowired
			private UserRepository repo;
	
//		private List<User> users =	new ArrayList<>(Arrays.asList(
//					new User("101","Meet","Miami"),
//					new User("102","Chetan","Orlando")));
//		
		public List<User> getAllUsers(){
			//return users;
			
			List<User> users = new ArrayList<>();
			repo.findAll()
			.forEach(users :: add);
			return users;
		}
		
		public Optional<User> getUser(String id) {
			//return users.stream().filter(t -> t.getId().equals(id)).findFirst().get();
			
			return repo.findById(id);
		}
		
		
		
		public void addUser(User user) {
			//users.add(user);
			repo.save(user);
		}
		
		public void updateUser(String id, User user) {
//			for(int i=0;i<users.size();i++){
//				User u = users.get(i);
//				
//				if(u.getId().equals(id)) {
//					users.set(i, user);
//					return;
//					
//				}
//			}
			
			repo.save(user);
		}
		
		public void deleteUser(String id) {
			//users.removeIf(t -> t.getId().equals(id));
			
			repo.deleteById(id);
		}

		public List<User> getUserByName(String name) {
			// TODO Auto-generated method stub
		return repo.findByName(name);
		}

		
		
}
