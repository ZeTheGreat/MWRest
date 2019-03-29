package mw.rest.MWRest.controller;

import lombok.Setter;
import mw.rest.MWRest.service.api.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/postagem")
public class PostagemController {

    @Autowired
    @Setter
    private PostagemService postagemService;


}
