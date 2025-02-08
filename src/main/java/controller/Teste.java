package controller;
import java.util.HashMap;


public class Teste {


        public static void main(String[] args) {
            Controller controller = new Controller();

           controller.criarCliente("Joao","1234","joao@gmail.com");

           controller.criarCliente("Joao","12345","joao@gmail.com");

            System.out.println(controller.getClientes().values());

            controller.deletarCliente("1234");

            System.out.println(controller.getClientes().values());



        }


}
