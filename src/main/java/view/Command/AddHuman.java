package view;

    public class AddHuman extends Command{
        public AddHuman(ConsoleUI consoleUI){
            super("Добавить человека", consoleUI);
        }
        @Override
        public void execute(){
            getConsoleUI().addHuman();
        }
    }

