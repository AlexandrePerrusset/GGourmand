package com.infotel.gg.service;

import com.infotel.gg.DTO.UserDTO;
import com.infotel.gg.bookingreport.EateryManager;
import com.infotel.gg.customer.Customer;
import com.infotel.gg.customer.User;
import com.infotel.gg.dao.DAO;
import com.infotel.gg.dao.jdbc.CustomerDAO;
import com.infotel.gg.exception.ModelException;

public class UserServiceImpl implements UserService{
	private DAO userDAO;



	/* (non-Javadoc)
	 * @see com.infotel.gg.service.UserService#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public UserDTO authenticate(String username, String password) throws ModelException {
		DAO userdao = new CustomerDAO(); //a retirer apres
		User u = userdao.read(username);
		if(u == null){
			throw new AuthenticationException ("authentification incorrect : utilisateur incorrect");
		}
		if (!password.equals(u.getPassword())){
			throw new AuthenticationException ("authentification incorrect : mot de passe incorrect");
		}
		
		UserDTO uDto = new UserDTO();
		uDto.setUsername(u.getUsername());
		uDto.setPassword(u.getPassword());
		
		if(u instanceof Customer){
			uDto.setType("CUSTOMER");
			Customer c = (Customer)u;
			uDto.setPhone(c.getPhone());
			uDto.setTitle(c.getTitle());
			uDto.setFirstName(c.getFirstName());
			uDto.setLastName(c.getLastName());
		}else if (u instanceof EateryManager){
			uDto.setType("MANAGER");
			EateryManager e = (EateryManager)u;
			uDto.setFirstName(e.getFirstName());
			uDto.setLastName(e.getLastName());			
		}
	}

	/* (non-Javadoc)
	 * @see com.infotel.gg.service.UserService#register(com.infotel.gg.DTO.UserDTO)
	 */
	@Override
	public void register(UserDTO userDto) throws ModelException {
		User user;
		
	}
	
}


