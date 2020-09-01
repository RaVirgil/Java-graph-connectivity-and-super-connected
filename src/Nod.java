import java.util.ArrayList;

public class Nod {

    public ArrayList<Nod> kids=new ArrayList<>();
    Integer number;
    Nod(int number)
    {

        this.number=number;

    }

    @Override
    public boolean equals(Object obj) {
        Nod anotherNode=(Nod)obj;
        if(number==anotherNode.number)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
