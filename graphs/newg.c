#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

#define MAXV 20

typedef struct edgenode {
    int info;        // adjacency info
    int weight;   // weight
    struct edgenode *next;  // stores the link to next edgenode
} edgenode;

typedef struct graph {
    edgenode *edge[MAXV];   // array for storing 
    int degree[MAXV];
    int nvertices;
    int nedges;
    bool directed;
} graph;
// function declarations

void insert_edge(graph *, int , int , bool);

// just for intializing all the nodes to NULL and degree array to 0
void initialize_graph(graph *g, bool directed) {
    int i=0;
    g->nvertices=0;
    g->nedges=0;
    g->directed = directed;

    for(i=0; i<MAXV; i++) g->degree[i]=0;
    for(i=0; i<MAXV; i++) g->edge[i]=NULL;
}
 
void read_graph(graph *g) {
    int m, i;          // number of edges between edge(x, y)
    int x, y;       // x and y veritces

    printf("Enter the number of edges and vetices");
    scanf("%d %d", &m, &(g->nvertices));

    for(i=0; i<m; i++) {
        printf("Enter the value of x & y");
        scanf("%d %d", &x, &y);
        insert_edge(g, x, y, g->directed);
    }
}

void insert_edge(graph *g, int x, int y, bool directed) {
    
    edgenode *p;  // temporary edgenode
    p = malloc(sizeof(edgenode));
    p->info = y;
    
    p->next = g->edge[x];  // saving the node link of already existing node in the edge array

    g->edge[x] = p;        // saving the link to edge array
    g->degree[x]++;        // increment degree of the node
    if(directed == false)  // if not directed add on more edge which will be fo(y, x) but with directed true
        insert_edge(g, y, x, true);
    else
        g->nedges++;       // even for directed edge is incemented only once.
}

void display_graph(graph *g) {
    int i=0;
    edgenode *j;

    for(i=1; i<g->nvertices; i++) {
        printf(" %d --> ", i);
        for(j=g->edge[i]; j!=NULL; j =j->next)
            printf("%d ", j->info);
        printf("\n");
    }
}

int main(void) {
    graph *g =  malloc(sizeof(graph));    
    initialize_graph(g, true);  // bool controls the directed nature of the graph  
    read_graph(g);
    printf("Vertices %d, Edges %d", g->nvertices, g->nedges);
    display_graph(g);
    return 0;
}
