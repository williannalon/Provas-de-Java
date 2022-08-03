package projGerenciaConsultas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Classe com validações genéricas de dados
 * alfanuméricos e alguns tipos específicos. */
public class Validador {
	
	public static boolean temApenasDigitos(String s) {
		String regex = "[0-9]+";
		Pattern p = Pattern.compile(regex);
        
		if ((s == null) || (s.length() == 0)) {
            return false;
        }
        Matcher m = p.matcher(s);
        return m.matches();
	}
	
	public static boolean temApenasLetras(String s) {
		/* 
		 * Este método tem uma abordagem semelhante ao método
		 * temApenasDigitos, mas foi escrito de uma forma mais concisa
		 */
		String regex = "^[a-zA-Z ]*$";
		
		return ((s != null) && (!s.equals(""))
                && (s.matches(regex)));
	}
	
	
	public static boolean temApenasLetrasENumeros(String s) {
		/* 
		 * Aqui, aceitamos caracteres númericos e alfabeticos,
		 * mas se encontrarmos algum caractere como acento ou 
		 * símbolos, não aceitamos o valor.
		 */
		String regex = "^[a-zA-Z0-9]+$";
		
		return ((s != null) && (!s.equals(""))
                && (s.matches(regex)));
	}
	
	public static boolean validaCEP(String s) {
		
		String regex = "[0-9]{5}-[0-9]{3}";
		
		return ((s != null) && (!s.equals(""))
                && (s.matches(regex)));
	}
	
	public static boolean ValidaEmail(String s)
    {
        String regex = "^(.+)@(\\S+)$";
		
		return ((s != null) && (!s.equals(""))
                && (s.matches(regex)));
    }
	
	

	public static boolean dataValida(String s) {
		String regex = "^(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[012])/\\d{4}$";
		
		boolean valida = false;
		
		Pattern p = Pattern.compile(regex);
        
		if ((s == null) || (s.length() == 0)) {
            return false;
        }
        
		Matcher m = p.matcher(s);
        
        if(m.matches()) {
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            // Rejeitar data invÃ¡lidas
            sdf.setLenient(false);
 
            // Parse 
            try {
                
                // Tenta fazer o parse e lanÃ§a exceÃ§Ã£o
            	// em caso de data invÃ¡lida
                sdf.parse(s);
                
                // Se nÃ£o lanÃ§ou exceÃ§Ã£o, a data Ã© vÃ¡lida
                valida = true;
                
            }catch(ParseException pe) {
                // Como o valor de valida jÃ¡ Ã© false
            	// nem precisa fazer nada
            }            
        }        
        
        return valida;        
	}
	
	public static boolean horaValida(String s) {
		String regex = "^(0[0-9]|[1][0-9]|[2][01234]):(0[0-9]|[1-5][0-9])$";
		
		boolean valida = false;
		
		Pattern p = Pattern.compile(regex);
        
		if ((s == null) || (s.length() == 0)) {
            return false;
        }
        
		Matcher m = p.matcher(s);
        
        if(m.matches()) {            
            // Parse 
            try {                
                // Tenta fazer o parse e lanÃ§a exceÃ§Ã£o
            	// em caso de hora invÃ¡lida
            	LocalTime lt = LocalTime.parse(s);
                
                // Se nÃ£o lanÃ§ou exceÃ§Ã£o, a hora Ã© vÃ¡lida
                valida = true;
                
            }catch(DateTimeException dte) {
                // Como o valor de valida jÃ¡ Ã© false
            	// nem precisa fazer nada
            }            
        }        
        
        return valida;
        
	}
	public static LocalDateTime StringData(String data) throws ParseException{
		
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
		  
		return dateTime;
        
		
	}
}

