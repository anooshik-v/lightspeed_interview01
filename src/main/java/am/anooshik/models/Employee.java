package am.anooshik.models;

public class Employee {
    private String name;
    private int id;
    private Double salary;
    private Library library;

    public Employee(String name, int id, Double salary, Library library) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.library = library;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", library=" + library +
                '}';
    }
}
