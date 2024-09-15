package com.Krishna.demo.Krishna.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Krishna.demo.Krishna.Entity.KrishnaGym;
import com.Krishna.demo.Krishna.Exception.MyException;
import com.Krishna.demo.Krishna.Reposit.RepositoryKrishna;
import com.Krishna.demo.Krishna.Validation.ModelUi;

import jakarta.validation.Valid;
@Service
public class ServiceKrishna {
private RepositoryKrishna Mv;
@Autowired
public ServiceKrishna(RepositoryKrishna Mv) {
	this.Mv = Mv;
}

	public List<KrishnaGym> getDetails() {
		List<KrishnaGym> collect = Mv.findAll();
		return collect;
	}

	  public String sendDetails(ModelUi value) {
		  List <KrishnaGym> check = Mv.findAll();
	      KrishnaGym krish = new KrishnaGym();
		  for(KrishnaGym take : check) {  
		  if(take.getName().equals(value.getName())) {
			  throw new MyException("Yerkanaye Iruku Da");
		  }
		  }
	      krish.setName(value.getName());
	      krish.setLocation(value.getLocation());
	      krish.setPassedout(value.getPassedout());
	      krish.setRole(value.getRole());
	      krish.setSalary(value.getSalary());
		  Mv.save(krish);
		  return "Success";
}

	public String sendDetail(KrishnaGym entity) {
		Mv.save(entity);
		return "I am Ok";
	}

	public String updateMap(Long id, KrishnaGym entity) {
		 List <KrishnaGym> gyms = Mv.findAll();
		 
		 
		for(KrishnaGym gym : gyms) {
			if(gym.getName().equals(entity.getName()) || gym.getLocation().equals(entity.getLocation()) || gym.getPassedout().equals(entity.getPassedout())){
				throw new MyException("Kudutha the kudukkatha");
				
			}
		else if(gym.getId().equals(id)) {
				gym.setName(entity.getName());
				gym.setLocation(entity.getLocation());
				gym.setPassedout(entity.getPassedout());
				gym.setRole(entity.getRole());
				gym.setSalary(entity.getSalary());
				Mv.save(gym);
				return "success";
			}
		}
		
		return "not found";
	}

	public String deleteMapped(Long id) {
		List <KrishnaGym> list  = Mv.findAll();
		for(KrishnaGym krish : list) {
	    if(krish.getId().equals(id)) {
	    	Mv.deleteById(id);
	    	return "success";
	    }
		
	}
		return "not found";}
	
	public KrishnaGym findById(Long id) {
	    return Mv.findById(id).orElseThrow(() -> new MyException("Gym not found"));
	}

	

	
}