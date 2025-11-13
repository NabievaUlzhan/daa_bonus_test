import model.Graph;
import model.Edge;
import service.MSTService;
import util.GraphPrinterInTerminal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 3);
        g.addEdge(0, 3, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 3);
        g.addEdge(2, 3, 1);
        g.addEdge(2, 4, 5);
        g.addEdge(3, 4, 6);
        g.addEdge(4, 5, 2);

        MSTService mstService = new MSTService();
        List<Edge> mst = mstService.buildMST(g);
        GraphPrinterInTerminal.printMST(mst);

        mstService.findReplacementEdge(g, mst, 2);
        GraphPrinterInTerminal.printMST(mst);
    }
}
