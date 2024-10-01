package view.Command;


import view.ConsoleUI;

public class AddParant extends Command {
    public AddParant(ConsoleUI consoleUI) {
        super("Добавить родителя", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addParent();
    }
}