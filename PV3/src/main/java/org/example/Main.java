package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //criando um arquivo
        Arquivo arq = new Arquivo();
        //criando funcionarios
        Produto prod = new Produto();
        //variavel para escanear
        Scanner sc = new Scanner(System.in);
        //flag para manter o fluxo
        boolean flag = true;
        //contadores de tipo
        int contComida = 0;
        int contHigiene = 0;
        int contDecoracao = 0;



        while(flag){

            System.out.println("Bem vindo ao menu!");
            System.out.println("1-Cadastrar Produtos");
            System.out.println("2-Listar produtos em ordem decrescente");
            System.out.println("3-Mostrar a quantidade de produtos de cada tipo");
            System.out.println("4-Sair");
            System.out.print("Digite: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1:
                    System.out.print("Nome do produto: ");
                    prod.setNome(sc.nextLine());
                    System.out.print("Preço do produto: ");
                    prod.setPreco(sc.nextDouble());
                    sc.nextLine();
                    System.out.print("Tipo do produto: ");
                    prod.setTipo(sc.nextLine());

                    arq.escrever(prod);

                    break;

                case 2:
                    //armazena o retorno do medoto de leitura
                    ArrayList <Produto> prods = arq.ler();
                    Collections.sort(prods);
                    Collections.reverse(prods);

                    for (int i = 0; i < prods.size(); i++) {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("INFORMACOES DO PRODUTO");
                        System.out.println(prods.get(i).getNome());
                        System.out.println(prods.get(i).getPreco());
                        System.out.println(prods.get(i).getTipo());
                        System.out.println("-----------------------------------------------------");
                        if(prods.get(i).getTipo().equals("comida")){
                            contComida++;
                        }
                        else if(prods.get(i).getTipo().equals("higiene")){
                            contHigiene++;
                        }
                        else if(prods.get(i).getTipo().equals("decoracao")){
                            contDecoracao++;
                        }
                    }
                    break;

                case 3:
                    //armazena o retorno do medoto de leitura
                    //ArrayList <Produto> prods = arq.ler();

                    System.out.println("-----------------------------------------------------");
                    System.out.println("Quantidade Produtos do tipo comida: " + contComida);
                    System.out.println("Quantidade Produtos do tipo higiene: " + contHigiene);
                    System.out.println("Quantidade Produtos do tipo decoração: " + contDecoracao);
                    System.out.println("-----------------------------------------------------");

                    break;

                case 4:
                    flag =false;
                    break;

            }

        }
    }
}