/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classesPrincipais;


/**
 *
 * @author victor-costa
 */
public class Verificador {  
    
    private String usuario1 = "victor@gmail.com";
    private String usuario2 = "victorhenrique8520@gmail.com";
    private String senha1 = "12345678";
    
    
    public boolean verificarSenha(String usuario ,String senha){
        if(usuario1.equals(usuario)){
            if(senha1.equals(senha)){
                return true;
            }
        }else{
            return false;
        }
        
        return false;
    }

}
