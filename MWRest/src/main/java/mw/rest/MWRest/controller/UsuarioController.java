package mw.rest.MWRest.controller;


import lombok.Setter;
import mw.rest.MWRest.service.api.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    @Setter
    private UsuarioService usuarioService;
}
