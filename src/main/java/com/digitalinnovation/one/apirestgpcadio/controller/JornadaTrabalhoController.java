package com.digitalinnovation.one.apirestgpcadio.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovation.one.apirestgpcadio.entity.JornadaTrabalho;
import com.digitalinnovation.one.apirestgpcadio.service.JornadaService;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();

    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho>  getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        return  ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() -> new NoSuchElementException("Not found!")));

    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.updateJornada(jornadaTrabalho);
    }

	@DeleteMapping("/deletar/{idJornada}")
    public ResponseEntity<?> deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
       try {
           jornadaService.deleteJornada(idJornada);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
        return new ResponseEntity<>(HttpStatus.OK);

    }



}