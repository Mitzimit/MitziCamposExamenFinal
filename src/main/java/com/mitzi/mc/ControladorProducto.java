package com.mitzi.mc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.mitzi.mc.DAOProductoImpl;
import com.mitzi.mc.Producto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mitzimit
 */
@Controller
@RequestMapping("/")
public class ControladorProducto {
    @RequestMapping(value="/producto/{nombre}/{precio}/{unidades}", 
            method=RequestMethod.GET, headers={"Accept=text/html"})
    public @ResponseBody String mensajito(@PathVariable String nombre, @PathVariable float 
           precio,@PathVariable int unidades){
           DAOProductoImpl d= new DAOProductoImpl();
     d.agregarProducto(new Producto(nombre, precio,unidades));
           return "Producto Agregado con exito";
    }
    
    @RequestMapping(value="/producto", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception{
     
  DAOProductoImpl g=new DAOProductoImpl();
  Map<String,ArrayList<Producto>> singletonMap =Collections.singletonMap("Producto", g.buscarTodosProducto());
  ObjectMapper mapper=new ObjectMapper();
  
  return mapper.writeValueAsString(g.buscarTodosProducto());
    }
}

