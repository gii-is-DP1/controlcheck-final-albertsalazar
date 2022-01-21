package org.springframework.samples.petclinic.care;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visit")
public class CareController {
	@Autowired
	CareService cs;
    @GetMapping("/{visitaId}/care/create")
    public String creaCare(ModelMap modelMap, @PathVariable("visitaId") int visitaId) {
    	Care c = new Care();
    	modelMap.addAttribute("Care", new Care());
    	modelMap.addAttribute("cares", cs.getAllCares() );
    	return "care/createOrUpdateProvidedCareForm";
    }
  
   
}
