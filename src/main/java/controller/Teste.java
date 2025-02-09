package controller;
import java.util.HashMap;


public class Teste {


        public static void main(String[] args) {
            Controller controller = Controller.getInstance();

           controller.criarCliente("Joao","1234","joao@gmail.com");

           controller.criarCliente("Joao","12345","joao@gmail.com");

            System.out.println(controller.getClientes().values());

            controller.deletarCliente("1234");

            System.out.println(controller.getClientes().values());

            controller.adicionarVeiculoAoCliente("12345","jju-890","Honda","Civic","preto",2020,2021,1000);
            controller.adicionarVeiculoAoCliente("12345","jju-855","Honda","Civic","preto",2020,2021,1000);

            System.out.println(controller.listarVeiculosDoCliente("12345"));

            controller.deletarVeiculoDoCliente("12345","jju-890");

            System.out.println(controller.listarVeiculosDoCliente("12345"));


        }


}
