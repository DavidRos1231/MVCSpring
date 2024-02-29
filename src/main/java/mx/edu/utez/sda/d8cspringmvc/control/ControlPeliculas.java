package mx.edu.utez.sda.d8cspringmvc.control;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peliculas")
public class ControlPeliculas {

    //Permisos "-----", "RCD--", "R---A"
    @GetMapping(value="/index")
    @Secured({"ROLE_RECE","ROLE_ADULT","ROLE_CHILD"})
    public String index(){
        return "peliculas";
    }
    @GetMapping(value="/terror")
    @Secured({"ROLE_ADULT"})
    public String terror(){
        return "terror";
    }
    @GetMapping(value="/xxx")
    @Secured({"ROLE_ADULT"})
    public String xxx(){
        return "xxx";
    }
    @GetMapping(value="/accionR")
    @Secured({"ROLE_ADULT"})
    public String accionR(){
        return "accionr";
    }

    @GetMapping(value="/musical")
    @Secured({"ROLE_CHILD","ROLE_ADULT"})
    public String musical(){
        return "musical";
    }
    @GetMapping(value="/animadas")
    @Secured({"ROLE_CHILD","ROLE_ADULT"})
    public String animadas(){
        return "animadas";
    }
    @GetMapping(value="/superheroes")
    @Secured({"ROLE_CHILD","ROLE_ADULT"})
    public String superheroes(){
        return "superheroes";
    }



}
