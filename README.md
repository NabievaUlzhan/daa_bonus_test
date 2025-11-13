# DAA Bonus Task

## Description
Java Maven project demonstrating:
- Construction of a MST via Prim's algorithm
- Edge removal and efficient replacement to maintain MST validity

## How to Run
1. Clone the repository git clone
2. Go to project folder cd daa_bonus
3. Build and run: mvn compile exec:java -Dexec.mainClass="Main"

## The result output in terminal when input is:
input(in Main)  
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


output  
" 1) MST Edges:   
   (0 - 1, w=4)  
   (1 - 4, w=3)  
   (4 - 7, w=4)  
   (7 - 9, w=2)  
   (7 - 3, w=5)  
   (9 - 8, w=7)  
   (8 - 6, w=1)  
   (8 - 5, w=3)  
   (5 - 2, w=2)  
2) Total Weight = 31  


3) Removing edge: (4 - 7, w=4)  
   Component 1: [0, 1, 4]  
   Component 2: [2, 3, 5, 6, 7, 8, 9]  
4) Replacement edge found: (4 - 7, w=4)  
1) MST Edges:  
   (0 - 1, w=4)  
   (1 - 4, w=3)  
   (7 - 9, w=2)  
   (7 - 3, w=5)  
   (9 - 8, w=7)  
   (8 - 6, w=1)  
   (8 - 5, w=3)  
   (5 - 2, w=2)  
   (4 - 7, w=4)  
2) Total Weight = 31"