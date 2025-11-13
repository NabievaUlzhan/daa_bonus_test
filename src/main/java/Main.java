import model.Graph;
import model.Edge;
import service.MSTService;
import util.GraphPrinterInTerminal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 8);
        g.addEdge(1, 3, 7);
        g.addEdge(1, 4, 3);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 6, 6);
        g.addEdge(3, 7, 5);
        g.addEdge(4, 7, 4);
        g.addEdge(5, 8, 3);
        g.addEdge(6, 8, 1);
        g.addEdge(7, 9, 2);
        g.addEdge(8, 9, 7);


        MSTService mstService = new MSTService();
        List<Edge> mst = mstService.buildMST(g);
        GraphPrinterInTerminal.printMST(mst);

        mstService.findReplacementEdge(g, mst, 2);
        GraphPrinterInTerminal.printMST(mst);
    }
}
