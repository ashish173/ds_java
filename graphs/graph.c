/* graph.c
 * Using adjacency lists to represent a graph  
 * Representation:-
 * directed edge(x, y) by an edgenode y in x's adjacency list
 *
 */

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>  // for bool type to work

#define MAXV   10   // maximum number of vertices

// node structure
typedef struct {
    int y;                    // adjacency info
    int weight;               // edge weight
    struct edgenode *next;    // pointer to next edge in list
} edgenode;

// graph strucutre
typedef struct {
    edgenode *edge[MAXV+1];   // edge is an array of edgenode pointer
    int degree[MAXV+1];       // outdegree of each vertex
    int nvertices;            // number of vertices in graph
    int nedges;               // number of edges in graph
    bool directed;            // is the graph directed?
} graph;

void insert_edge(graph *, int , int, bool);

/* intializes am empty graph */
void initialize_graph(graph *g, bool directed) {
    int i;       // counter

    g->nvertices = 0;
    g->nedges = 0;
    g->directed = directed;

    for(i=0; i<=MAXV; i++) g->degree[i] = 0;
    for(i=0; i<=MAXV; i++)  g->edge[i] = NULL;
}


/* reads all the edges and prints on the screen */
void read_graph(graph *g, bool directed) {
    int i;  // counter
    int m;  // number of edges
    int x, y;

    initialize_graph(g, directed);
    printf("Enter vertices and edges: ");
    scanf("%d %d", &(g->nvertices), &m); // input # of vertices & # of edges

    for(i=1; i<=m; i++) {
        printf("Enter the edges between x then y: ");
        scanf("%d %d", &x, &y);
        insert_edge(g, x, y, directed);  // insert the edge
    }
}

/* insert nodes in the graph */
void insert_edge(graph *g, int x, int y, bool directed) {
    int name;
    edgenode *p;                    // temporary edgenode pointer
    p = malloc(sizeof(edgenode));   // allocate edgenode storage
    
    p->weight = (int)NULL;    // typecast from pointer to integer
    p->y = y;

    p->next = (edgenode *)g->edge[x];  // this needs to be corrected produces exception
    
    g->edge[x] = p;                // insert at the head of the list
    g->degree[x]++;
    if(directed == false)           // in case of undirected graph
        insert_edge(g, y, x, true); // insertion for the both the x & y list
    else
        g->nedges++;
}

/* prints the graph */
void print_graph(graph *g) {
    int i;        // counter
    edgenode *p;  // temporary pointer

    for(i=1; i<=g->nvertices; i++) {
        printf("%d~> ", i);
        p = g->edge[i];
        while(p != NULL) {
            printf(" %d", p->y);
            p = (edgenode *)p->next;
        }
        printf("\n");
    }
}

// driver function
int main(void) {  // notice void
    graph *g = malloc(sizeof(graph));
    read_graph(g, true);    // true ~> directed graph
    print_graph(g);         // prints the graph 
    return 0; 
}

