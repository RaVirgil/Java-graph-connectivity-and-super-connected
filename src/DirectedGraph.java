import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DirectedGraph {
    ArrayList<Nod> graph=new ArrayList<>();
    int nrNodes;

    public void FileRead() throws FileNotFoundException
    {
        Scanner f = new Scanner(new FileReader("DirectedGraph.txt"));
        nrNodes = f.nextInt();
        for(int i=0;i<nrNodes;i++)
            graph.add(new Nod(i));
        Nod temp;
        while (f.hasNextLine()) {
            for (int i = 0; i < nrNodes; i++)
                for (int j = 0; j < nrNodes; j++)
                {
                    if (f.nextInt() == 1)
                    {
                        graph.get(i).kids.add(graph.get(j));


                    }
                }
        }
        for (Nod nod : graph) {
            System.out.print("\n" + (nod.number+1) + " ");
            for (Nod kid : nod.kids)
                System.out.print((kid.number+1) + " ");
        }
    }
    public void IsStrongConnectedGraph()
    {
        ArrayList<Nod> visited=new ArrayList<>();
        Queue<Nod> toVisit=new LinkedList<>();
        Nod currentNod=graph.get(0);
        toVisit.add(currentNod);
        while(!toVisit.isEmpty())
        {
            if (!visited.contains(currentNod))
            {
                visited.add(currentNod);
                currentNod.kids.forEach(kid -> toVisit.add(kid));
                toVisit.poll();
                currentNod = toVisit.peek();
            }
            else
            {
                toVisit.poll();
                if (!toVisit.isEmpty())
                    currentNod = toVisit.peek();

            }
        }
        if(visited.size()==graph.size())
            System.out.print("\nGraph is strongly connected!");
        else
            System.out.print("\nGraph is not strongly connected!");
    }
}
