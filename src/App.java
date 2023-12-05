import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Comando javac para compilar
// Comando java para rodar o programa
// Sempre colocar quando fizer alteração no código

public class App {

    public static void main(String[] args) {
        List<String> task = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        char choice;

        while (true) {
            System.out.println("Escolha as opções abaixo:\n");
            System.out.println("1 - Adicionar uma nova tarefa");
            System.out.println("2 - Ver as tarefas");
            System.out.println("3 - Remover uma tarefa");
            System.out.println("4 - Atualizar uma tarefa");
            System.out.println("5 - Sair");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1':
                    adicionarTarefa(task, scanner);
                    break;

                case '2':
                    listarTarefas(task);
                    break;

                case '3':
                    removerTarefa(task, scanner);
                    break;

                case '4':
                    atualizarTarefa(task, scanner);
                    break;

                case '5':
                    System.out.println("Saindo do programa.");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    // Fora da class Main, Fazer as funções 
    private static void adicionarTarefa(List<String> task, Scanner scanner) {
        System.out.print("Digite sua nova tarefa: ");
        scanner.nextLine();
        String taskNew = scanner.nextLine();
        task.add(taskNew);
    }

    private static void listarTarefas(List<String> task) {
        System.out.println("Tarefas:");
        for (String tarefa : task) {
            System.out.println("Suas tarefas: " + tarefa);
        }
    }

    private static void removerTarefa(List<String> task, Scanner scanner) {
        System.out.println("Escolha para remover da lista");
        for (String tarefa : task) {
            System.out.println(tarefa);
        }
        System.out.print("Digite o que você quer remover: ");
        scanner.nextLine();
        String removeTask = scanner.nextLine();
        boolean encontrou = false;

        for (String tarefa : task) {
            if (removeTask.equals(tarefa)) {
                System.out.println("Tarefa Removida com sucesso!!!");
                task.remove(removeTask);
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Tarefa não encontrada");
            for (String tarefa : task) {
                System.out.println(tarefa);
            }
        }
    }

    private static void atualizarTarefa(List<String> task, Scanner scanner) {
        System.out.println("Escolha para atualizar da lista");
        for (String tarefa : task) {
            System.out.println(tarefa);
        }
        System.out.print("Digite o que você quer atualizar: ");
        scanner.nextLine();
        String removeTask = scanner.nextLine();
        boolean encontrou = false;

        for (int i = 0; i < task.size(); i++) {
            if (removeTask.equals(task.get(i))) {
                System.out.println("Digite o novo nome da tarefa: ");
                String updateTask = scanner.nextLine();
                task.set(i, updateTask);
                encontrou = true;
                System.out.println("Tarefa atualizada com sucesso!");
                break;
            }
        }

        if (!encontrou) {
            System.out.println("Tarefa não encontrada");
        }
    }
}

// Anotações do programa feito

/*
 * Este programa em Java funciona como uma lista de tarefas interativa. Abaixo estão algumas anotações para entender o código:
 * 
 * - Scanner: A classe Scanner é usada para receber entrada do usuário. O método next().charAt(0) é usado para capturar o primeiro caractere da entrada do usuário.
 * 
 * - List<String>: A interface List é usada para criar uma lista dinâmica de strings. O ArrayList implementa essa interface, fornecendo funcionalidades para adicionar, remover e acessar elementos na lista.
 * 
 * - Arrays em Java são esquisitos, não da para adicionar é remover, é também tem espaço limitado.
 * 
 * - switch: A estrutura switch é utilizada para criar um menu interativo. Dependendo da escolha do usuário (armazenada em 'choice'), diferentes funções são chamadas.
 * 
 * - Funções: O código foi organizado com funções separadas para adicionar, listar, remover e atualizar tarefas.
 * 
 * - Iteração sobre a lista: Em várias partes do código, há for e while for que iteram sobre a lista de tarefas. Eles são usados para exibir tarefas, remover tarefas e atualizar tarefas.
 * 
 * - equals: O método equals é usado para comparar strings. No código, é usado para verificar se uma tarefa digitada pelo usuário corresponde a uma tarefa na lista.
 * 
 * - Remoção durante iteração: No método 'removerTarefa', há uma iteração sobre a lista e, se uma tarefa é encontrada, ela é removida. No entanto, é importante notar que modificar a lista enquanto ela está sendo iterada pode levar a problemas. Isso é tratado aqui, pois o loop é encerrado assim que uma tarefa é removida.
 * 
 * - Estrutura de repetição infinita: O código usa um loop 'while (true)' para manter o menu ativo até que o usuário escolha sair (opção 5).
 * 
 * - nextLine(): É utilizado para consumir a quebra de linha deixada pelo next() ou next().charAt(0) e garantir a correta leitura da próxima entrada.
 */
