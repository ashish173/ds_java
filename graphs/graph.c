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

typedef struct {
    int y;                    // adjacency info
    int weight;               // edge weight
    struct edgenode *next;    // pointer to next edge in list
} edgenode;

typedef struct {
    edgenode *edge[MAXV+1];   // adjacency info
    int degree[MAXV+1];       // outdegree of each vertex
    int nvertices;            // number of vertices in graph
    int nedges;               // number of edges in graph
    bool directed;            // is the graph directed?
} graph;

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
        insert_edge(g, x, y, directed);
    }
}

/* insert nodes in the graph */
void insert_edge(graph *g, int x, int y, bool directed) {
    edgenode *p;                    // temporary edgenode pointer
    p = malloc(sizeof(edgenode));   // allocate edgenode storage
    
    p->weight = NULL;
    p->y = y;
    p->next = g->edge[x];
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
            p = p->next;
        }
        printf("\n");
    }
}

// driver function
int main(void) {  // notice void
    graph *g = malloc(sizeof(graph));
    read_graph(g, true);    // true is a directed graph
    print_graph(g);
    return 0;
}

