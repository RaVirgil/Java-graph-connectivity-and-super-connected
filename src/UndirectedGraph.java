import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class UndirectedGraph
{
    ArrayList<Nod> graph=new ArrayList<>();
    int nrNodes;

    public void FileRead() throws FileNotFoundException
    {
        Scanner f = new Scanner(new FileReader("UndirectedGraph.txt"));
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

    public void ConnectedComponents()
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
        if(currentNod==graph.get(0) && visited.size()==graph.size())
        {
            System.out.println("\nGraph has only one component: ");
            visited.forEach(nod-> System.out.print(nod+" "));
        }
        else
        {
            System.out.println("\nGraph has the following components: ");
            visited.forEach(nod-> System.out.print((nod.number+1)+" "));
            System.out.println();
            for(Nod nod:graph)
            {
                if(!visited.contains(nod))
                {
                    System.out.print((nod.number+1)+" ");
                    nod.kids.forEach(kid-> System.out.print((kid.number+1)+" "));
                    System.out.println();
                    nod.kids.forEach(kid->visited.add(kid));
                }

        }   }
    }


}


