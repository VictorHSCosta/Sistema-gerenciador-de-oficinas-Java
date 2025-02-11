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
    

    
    
    public boolean verificarSenha(String usuario ,String senha){
        return switch (usuario) {
            case "adm@gmail.com" -> senha.equals("123456");
            case "amd" -> senha.equals("amd");
            default -> false;
        };
    }

}
