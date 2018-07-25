package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Employee e)
	{
		repo.save(e);
		return "home.jsp";
	}
	
	@RequestMapping("/getEmployee")
	public ModelAndView getEmployee(@RequestParam int eid)
	{
		ModelAndView mv=new ModelAndView("showEmployee.jsp");
		Employee e=repo.findById(eid).orElse(new Employee());
		mv.addObject(e);
		return mv;
	}
        
        @RequestMapping("/deleteEmployee")
        
        public String deleteEmployee (@RequestParam int eid)
        {
            repo.deleteById(eid);
            return "home.jsp";
        }
}	
