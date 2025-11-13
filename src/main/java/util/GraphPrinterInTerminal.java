package util;
import model.Edge;
import java.util.List;

public class GraphPrinterInTerminal {
    public static void printMST(List<Edge> edges) {
        int total = edges.stream().mapToInt(Edge::getWeight).sum();
        System.out.println("1) MST Edges:");
        edges.forEach(System.out::println);
        System.out.println("2) Total Weight = " + total + "\n");
    }
}
