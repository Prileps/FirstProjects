import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String HELP_TEXT = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            try {
                String command = scanner.nextLine();
                String[] tokens = command.split("\\s+", 2);
                switch (tokens[0]) {
                    case "add":
                        LOGGER.info("Пользователь ввел команду: {}", command);
                        executor.addCustomer(tokens[1]);
                        break;
                    case "list":
                        if (tokens.length == 1) {
                            LOGGER.info("Пользователь ввел команду: {}", command);
                            executor.listCustomers();
                        } else {
                            throw new IllegalArgumentException("Неверный запрос списка всех клиентов");
                        }
                        break;
                    case "remove":
                        if (tokens.length == 2) {
                            LOGGER.info("Пользователь ввел команду: {}", command);
                            executor.removeCustomer(tokens[1]);
                        } else {
                            throw new IllegalArgumentException("Неверное удаление клиента");
                        }
                        break;
                    case "count":
                        if (tokens.length == 1) {
                            LOGGER.info("There are " + executor.getCount() + " customers");
                            System.out.println("There are " + executor.getCount() + " customers");
                        } else {
                            throw new IllegalArgumentException("Неверный запрос о количестве клиентов");
                        }
                        break;
                    case "help":
                        if (tokens.length == 1) {
                            LOGGER.info("Пользователь ввел команду: {}", command);
                            System.out.println(HELP_TEXT);
                        } else {
                            throw new IllegalArgumentException("Неверный запрос о командах приложения");
                        }
                        break;
                    default:
                        LOGGER.error("Пользователь ввел неверную команду: {}", command);
                        System.out.println(COMMAND_ERROR);
                        break;
                }
            } catch (Exception exception) {
                LOGGER.error(exception);
                System.out.println(COMMAND_ERROR);
            }
        }
    }
}
