package presenter;

import model.service.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addStudent(String name, int age) {
        service.addStudent(name, age);
        getStudentsListInfo();
    }

    public void getStudentsListInfo() {
        String info = service.getStudentsInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getStudentsListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getStudentsListInfo();
    }

}
