package com.infotel.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.gg.DTO.CustomerDTO;
import com.infotel.gg.DTO.EateryManagerDTO;
import com.infotel.gg.DTO.UserDTO;
import com.infotel.gg.dao.EateryManagerDAO;
import com.infotel.gg.dao.UserDAO;
import com.infotel.gg.exception.AuthenticationException;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.model.Customer;
import com.infotel.gg.model.EateryManager;
import com.infotel.gg.model.User;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private EateryManagerDAO managerDAO;




	/* (non-Javadoc)
	 * @see com.infotel.gg.service.UserService#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public UserDTO authenticate(String username, String password) throws AuthenticationException {
		User u = userDAO.read(username);
		if(u == null){
			throw new AuthenticationException ("authentification incorrect : utilisateur incorrect");
		}
		if (!password.equals(u.getPassword())){
			throw new AuthenticationException ("authentification incorrect : mot de passe incorrect");
		}
		
		UserDTO uDto = new UserDTO();
		uDto.setUsername(u.getUsername());
		
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
		return uDto;
	}

	/* (non-Javadoc)
	 * @see com.infotel.gg.service.UserService#register(com.infotel.gg.DTO.UserDTO)
	 */
	@Override
	public void register(UserDTO userDto) throws GGourmandException {
		Customer cust = new Customer(userDto.getFirstName(), userDto.getLastName(), userDto.getTitle(), userDto.getPhone(), userDto.getUsername(), userDto.getPassword());
		userDAO.create(cust);
	}
	@Override
	public EateryManagerDTO findManagerByUsername(String username){
		EateryManager em = managerDAO.read(username);
		EateryManagerDTO emd = new EateryManagerDTO();
		emd.setUsername(em.getUsername());
		emd.setEateryId(em.getEatery().getId());
		emd.setFirstName(em.getFirstName());
		emd.setLastName(em.getLastName());
		return emd;
	}

	@Override
	public CustomerDTO findCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}


