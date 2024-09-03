package com.Krishna.demo.Krishna.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Krishna.demo.Krishna.Entity.KrishnaGym;
import com.Krishna.demo.Krishna.Service.ServiceKrishna;
import com.Krishna.demo.Krishna.Validation.ModelUi;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Mani/gym")
public class Controllerkrishna {
	private ServiceKrishna Ms;
	
@Autowired 
public Controllerkrishna(ServiceKrishna Ms) {
this.Ms = Ms;
	}
	
@GetMapping("/health/get")
public List<KrishnaGym> getDetail() {
return Ms.getDetails();
}
@PostMapping("/health/add")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public String postMethod(@RequestBody @Valid KrishnaGym entity) {
return Ms.sendDetail(entity);
}


@PostMapping("/health/addModel")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public String postMethod(@RequestBody @Valid ModelUi ui) {
return Ms.sendDetails(ui);
}

@PutMapping("/health/update/{id}")
@PreAuthorize("hasRole('ROLE_ASSISTMANAGER')")
public String editMap(@PathVariable Long id, @RequestBody KrishnaGym entity) {
  	return Ms.updateMap(id, entity);
}
@DeleteMapping("/health/delete/{id}")
@PreAuthorize("hasRole('ROLE_MANAGER')")
public String deleteMap(@PathVariable Long id) {
	return Ms.deleteMapped(id);
}


}
