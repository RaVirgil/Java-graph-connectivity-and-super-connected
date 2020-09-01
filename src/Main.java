import java.io.FileNotFoundException;

public class Main
{
    public static void main(String[] args)
    {
        UndirectedGraph undirectedGraph=new UndirectedGraph();
        DirectedGraph directedGraph=new DirectedGraph();
        try
        {
            undirectedGraph.FileRead();
            undirectedGraph.ConnectedComponents();
            directedGraph.FileRead();
            directedGraph.IsStrongConnectedGraph();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }



    }
}
