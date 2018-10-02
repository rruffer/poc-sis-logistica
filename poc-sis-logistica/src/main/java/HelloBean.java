/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author hantsy
 */
@Named
@ViewScoped
public class HelloBean implements Serializable {
	
	private static final long serialVersionUID = -6896803213320150843L;
	
	private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sayHi() {
        this.message = " received at " + LocalDateTime.now();
       System.out.println("Teste"); 
       
    }


}
