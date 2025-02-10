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
    public boolean verificarSenha(String usuario, String senha) {
        switch (usuario) {
            case "adm@gmail.com":
                return senha.equals("123456");
            case "amd":
                return senha.equals("amd");
            default:
                return false;
        }
    }
}
