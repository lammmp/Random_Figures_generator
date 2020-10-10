import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Menu {
    private final static int CREATE = 1;
    private final static int DELETE = 2;
    private final static int GET_SQUARE = 3;
    private final static int EXIT = 0;
 
    private List<Figure> figures = new ArrayList<>();
 
    public void start() {
        int userChoice = -1;
        while (true) {
            printMainMenu();
            userChoice = getUserIntInput();
 
            if (userChoice == EXIT)
                return;
 
            if (userChoice != CREATE && userChoice != DELETE && userChoice != GET_SQUARE && userChoice != EXIT) {
                System.out.println("Ошибка ввода");
                continue;
            }
 
            int figureType = -1;
            do {
                printFigureTypeMenu();
                figureType = getUserIntInput();
            } while (figureType != 1 && figureType != 2 && figureType != 3 && figureType != 4);
            switch (userChoice) {
                case CREATE:
                    System.out.println("Введите первую сторону");
                    double a = getUserDoubleInput();
                    System.out.println("Введите вторую сторону");
                    double b = getUserDoubleInput();
                    createFigure(figureType, a, b);
                    break;
                case DELETE:
                    boolean deleteResult = deleteFigure(figureType);
                    if (!deleteResult)
                        System.out.println("Таких фигур в списке нет");
                    break;
                case GET_SQUARE:
                    printAllSquares(figureType);
            }
            printFiguresStatus();
        }
 
    }
    
    private void printFiguresStatus() {
        System.out.println("Общее колличество фигур - " + figures.size());
        System.out.println("Общее колличество кругов - " + countFigures(1));
        System.out.println("Общее колличество треугольников - " + countFigures(2));
        System.out.println("Общее колличество квадратов - " + countFigures(3));
        System.out.println("Общее колличество эллипсов - " + countFigures(4));
    }
 
    private int countFigures(int type) {
        int result = 0;
        if (type == 1) {
            for (Figure figure : figures) {
                if (figure.getClass() == Circle.class) {
                    result++;
                }
            }
        }
        if (type == 2)
            for (Figure figure : figures) {
                if (figure.getClass() == Triangle.class) {
                    result++;
                }
            }
        if (type == 3)
            for (Figure figure : figures) {
                if (figure.getClass() == Square.class) {
                    result++;
                }
            }
        if (type == 4)
            for (Figure figure : figures) {
                if (figure.getClass() == Ellipse.class) {
                    result++;
                }
            }
 
        return result;
    }
 
    private void printAllSquares(int type) {
        if (type == 1) {
            for (Figure figure : figures) {
                if (figure.getClass() == Circle.class) {
                    System.out.println(figure.getSquare());
                }
            }
        }
        if (type == 2)
            for (Figure figure : figures) {
                if (figure.getClass() == Triangle.class) {
                    System.out.println(figure.getSquare());
                }
            }
        if (type == 3)
            for (Figure figure : figures) {
                if (figure.getClass() == Square.class) {
                    System.out.println(figure.getSquare());
                }
            }
        if (type == 4)
            for (Figure figure : figures) {
                if (figure.getClass() == Ellipse.class) {
                    System.out.println(figure.getSquare());
                }
            }
    }
 
    private void createFigure(int type, double a, double b) {
        if (type == 1)
            figures.add(new Circle(a, b));
        if (type == 2)
            figures.add(new Triangle(a, b));
        if (type == 3)
            figures.add(new Square(a, b));
        if (type == 4)
            figures.add(new Ellipse(a, b));
    }
 
    // будем удалять самый первый элемент если он есть
    // если что-то удалилось - вернет тру
    private boolean deleteFigure(int type) {
        if (type == 1) {
            for (Figure figure : figures) {
                if (figure.getClass() == Circle.class) {
                    figures.remove(figure);
                    return true;
                }
            }
        }
        if (type == 2)
            for (Figure figure : figures) {
                if (figure.getClass() == Triangle.class) {
                    figures.remove(figure);
                    return true;
                }
            }
        if (type == 3)
            for (Figure figure : figures) {
                if (figure.getClass() == Square.class) {
                    figures.remove(figure);
                    return true;
                }
            }
        if (type == 4)
            for (Figure figure : figures) {
                if (figure.getClass() == Ellipse.class) {
                    figures.remove(figure);
                    return true;
                }
            }
        return false;
    }
 
    private void printMainMenu() {
        System.out.println("1 - создать");
        System.out.println("2 - удалить");
        System.out.println("3 - площадь");
        System.out.println("0 - выход");
    }
 
    private void printFigureTypeMenu() {
        System.out.println("1 – круг");
        System.out.println("2 – треугольник");
        System.out.println("3 – квадрат");
        System.out.println("4 – эллипс");
    }
 
    private int getUserIntInput() {
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        return result;
    }
 
    private double getUserDoubleInput() {
        Scanner scanner = new Scanner(System.in);
        double result = scanner.nextDouble();
        return result;
    }
}