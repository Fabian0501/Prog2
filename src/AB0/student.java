package AB0;

public class student extends  person{
    private int matr;

    public student(String name, String vorname, int matr) {
        super(name, vorname);
        this.matr = matr;
    }

    public int getMatr() {
        return matr;
    }

    @Override
    public String toString() {
        return super.toString() + " " + matr;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof student)) {
            return false;
        }
        student student = (student) other;
        return super.equals(student) && student.matr == this.matr;
    }
}