import model.Biblioteca;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        Biblioteca b=new Biblioteca();
        Menu menu =new Menu();
        menu.launch(b);
    }
}