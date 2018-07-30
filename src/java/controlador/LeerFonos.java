/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Alumno;
import modelo.AlumnoDAO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ctoro
 */
@Controller
@RequestMapping("/mostrar.htm")
public class LeerFonos {
    
    @Autowired
    private AlumnoDAO2 dao;
    
    @RequestMapping(method = RequestMethod.GET)
    public String mostrarAlumno(){
        return "buscar";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String mostrarAlumno(
            @RequestParam("txtRut") String rut,
            Model model){
        if (rut.trim().equals("")) {
            return "error";
        }
        
        Alumno a = dao.readByRutJPQL(rut);
        
        if (a == null) {
            return "error";
            
        }
        model.addAttribute("listaFonos",a.getFonoCollection());
        
        return "fonos";
        
    }
    
    
}
