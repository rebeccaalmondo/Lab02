package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

import Traduzione.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	List <Dizionario> parole=new LinkedList<Dizionario>(); 

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtTraduzione;

    @FXML
    void doClear(ActionEvent event) {
    	txtParola.setText("");
    	txtTraduzione.setText("");
    	

    }

    @FXML
    void doTraduzione(ActionEvent event) {
    	String parolaInserita=txtParola.getText().toLowerCase();
    	if(parolaInserita.matches("[a-zA-Z? ]*")) {
    		if(parolaInserita.contains(" ")) {
    			String parola=parolaInserita.substring(0, txtParola.getText().indexOf(" "));
    			String traduzione=parolaInserita.substring(txtParola.getText().indexOf(" "), txtParola.getLength());
    			for(Dizionario d:parole) {
    				if(d.getParola().equals(parola)) {
    					d.getListaTraduzioni().add(traduzione);
    					txtTraduzione.setText("Traduzione inserita");
    					txtParola.setText("");
    					return;
    				}
    			}
    			Dizionario nuovaTraduzione = new Dizionario (parola);
    			nuovaTraduzione.getListaTraduzioni().add(traduzione);
    			parole.add(nuovaTraduzione);
    			txtTraduzione.setText("Traduzione inserita");
    			txtParola.setText("");
    			return;
    		}
    		else {
    			if(parolaInserita.contains("?")) {
    				parolaInserita.replace("?", ".");
    				for(Dizionario d: parole) {
    					if(d.getParola().matches(parolaInserita)) {
    						txtTraduzione.setText("La tua traduzione è: "+ d.getListaTraduzioni().get(0));
    					}
    				}
    			}
    			for(Dizionario d:parole) {
    				if(d.getParola().equals(parolaInserita)) {
    					if(d.getListaTraduzioni().size()==1) 
    						txtTraduzione.setText("La tua traduzione è" +d.getListaTraduzioni().get(0));
    					else {
    						String risposta= "Le tue traduzioni sono:\n";
    						for(String s:d.getListaTraduzioni()) {
    							risposta=risposta+s+"\n";
    						}
    						txtTraduzione.setText(risposta);
    						
    					}
    					txtParola.setText("");
    					
    					return;
    				}
    			
    			}
				txtTraduzione.setText("Nessuna Traduzione");
				txtParola.setText("");
			
    		}
    	}
    	else {
    		txtTraduzione.setText("Carattere non valido");
    	}
    }
    

}
