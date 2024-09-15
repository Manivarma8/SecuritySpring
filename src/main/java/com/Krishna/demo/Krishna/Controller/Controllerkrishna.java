package com.Krishna.demo.Krishna.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Krishna.demo.Krishna.Entity.KrishnaGym;
import com.Krishna.demo.Krishna.Exception.MyException;
import com.Krishna.demo.Krishna.Service.ServiceKrishna;
import com.Krishna.demo.Krishna.Validation.ModelUi;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/Mani/gym")
public class Controllerkrishna {
	private ServiceKrishna Ms;
	
@Autowired 
public Controllerkrishna(ServiceKrishna Ms) {
this.Ms = Ms;
}
	
@GetMapping("/health/get")
public String getDetail(Model model) {
	List <KrishnaGym> list = Ms.getDetails();
	model.addAttribute("list", list);
return "Listgym";
}

@GetMapping("/post1")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public String UserForm(Model model) {
  model.addAttribute("gym",new ModelUi());
  return "gym/gymForm";
}


@PostMapping("/post2")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public String postMethod(@ModelAttribute @Valid ModelUi user,Model model,BindingResult bind) {
      if(bind.hasErrors()) {
        model.addAttribute("error", bind.getAllErrors());
        return "gym/UserError";
      }
      
      try {
    Ms.sendDetails(user);
    model.addAttribute("user", user);
    return "gym/userAdded";
      } catch(MyException e) {
        return "gym/Error";
      }
}


@GetMapping("/Deleted/{id}")
public String deletedget(Model model,@PathVariable Long id) {

	try{
	model.addAttribute("id",id);

	return "gym/deleteGet";
	}
	catch(MyException me) {
		return "gym/deleteErr";
	}
}

@PostMapping("/Deleted1/{id}")
public String updateGet(@ModelAttribute @PathVariable Long id) {
	Ms.deleteMapped(id);
    return "gym/deletedPost";
}

@GetMapping("update/{id}")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public String updateMethod(Model model, @PathVariable Long id) {
    KrishnaGym gym = Ms.findById(id); 
    if (gym == null) {
        throw new MyException("Gym not found");
    }
    model.addAttribute("update", gym);
    return "gym/updateGet";
}


@PostMapping("updated/{id}")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public String updatedMethod(@ModelAttribute KrishnaGym gym, @PathVariable Long id) {
    Ms.updateMap(id, gym); 
    return "gym/updatedPost";
}

}




