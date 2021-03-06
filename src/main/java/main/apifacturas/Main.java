/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.apifacturas;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author danie
 */
@Controller
@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {    
        SpringApplication.run(Main.class, args);
    }
    
    @RequestMapping(value = "/cliente", method = GET)
    public ResponseEntity<?> getFacturaCliente(@RequestParam("factura") JSONObject factura){                        
        FormatoCliente formato = new ClientePlano();        
        return new ResponseEntity<>(formato.crearFormato(factura),HttpStatus.OK);
    }    
    
    @RequestMapping(value = "/dian", method = GET)
    public ResponseEntity<?> getFacturaDIAN(@RequestParam("factura") JSONObject factura){                        
        FormatoCliente formato = new FormatoDianXML();        
        return new ResponseEntity<>(formato.crearFormato(factura),HttpStatus.OK);
    }   
}
