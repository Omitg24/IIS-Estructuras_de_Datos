package p2Grafos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

/**
 * Titulo: Clase GraphTests
 * 
 * @author UO281847
 * @version 24/09/2021
 */
public class GraphTests {
	/**
	 * Atributo g
	 */
	private Graph<Integer> g;
	/**
	 * Constante infinite
	 */
	private static final double infinite = Double.POSITIVE_INFINITY;
/*
 * Pruebas del m�todo addNode:	
 */
	/**
	 * Test del m�todo addNode sin errores
	 */
	@Test
	public void testAddNodeFirst() {
		g = new Graph<Integer>(3);
		int node = 12;
		assertEquals(0, g.addNode(node));
		System.out.println(g.toString());	
	}	
	/**
	 * Test del m�todo addNode con nodo no valido
	 */
	@Test
	public void testAddNodeNotValid() {
		g = new Graph<Integer>(3);
		int node = 1;
		int node2 = 18;
		assertEquals(0, g.addNode(node));
		assertEquals(0, g.addNode(node2));
		assertEquals(-4, g.addNode(null));
		System.out.println(g.toString());	
	}
	/**
	 * Test del m�todo addNode cuando ya esta lleno
	 */
	@Test
	public void testAddNodeFull() {
		g = new Graph<Integer>(3);
		int node = 1;
		int node2 = 18;
		int node3 = 39;
		int node4= 2;
		assertEquals(0, g.addNode(node));
		assertEquals(0, g.addNode(node2));
		assertEquals(0, g.addNode(node3));
		assertEquals(-2, g.addNode(node4));		
		System.out.println(g.toString());	
	}
	/**
	 * Test del m�todo addNode cuando ya existe
	 */
	@Test
	public void testAddNodeAlreadyExists() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 39;
		int node4 = 19;
		int node5= 19;
		assertEquals(0, g.addNode(node));
		assertEquals(0, g.addNode(node2));
		assertEquals(0, g.addNode(node3));
		assertEquals(0, g.addNode(node4));
		assertEquals(-1, g.addNode(node5));	
		System.out.println(g.toString());	
	}
	
/*
 * Pruebas del m�todo getNode:
 */
	/**
	 * Test del m�todo getNode que devuelve la posici�n
	 */
	@Test
	public void testGetNodeNormal() {
		g = new Graph<Integer>(5);
		int node = 1;
		assertEquals(0,g.addNode(node));
		assertEquals(0, g.getNode(node));
	}
	/**
	 * Test del m�todo getNode que devuelve la posici�n ya a�adido
	 */
	@Test
	public void testGetNodeVarious() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 23;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(1, g.getNode(node2));
	}
	/**
	 * Test del m�todo getNode que devuelve -1
	 */
	@Test
	public void testGetNodeDontExists() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 23;
		assertEquals(0,g.addNode(node));
		assertEquals(-1, g.getNode(node2));
	}

/**
 * Pruebas del m�todo existsNode:
 */
	/**
	 * Test del m�todo existsNode que devuelve true
	 */
	@Test
	public void testExistsNodeOne() {
		g = new Graph<Integer>(5);
		int node = 1;
		assertEquals(0,g.addNode(node));
		assertTrue(g.existsNode(node));
	}
	/**
	 * Test del m�todo existsNode que devuelve true
	 */
	@Test
	public void testExistsNodeVarious() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 23;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertTrue(g.existsNode(node2));
	}
	/**
	 * Test del m�todo existsNode que devuelve true
	 */
	@Test
	public void testExistsNodeFalse() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 23;
		assertEquals(0,g.addNode(node));
		assertFalse(g.existsNode(node2));
	}

/*
 * Pruebas del m�todo addEdge:
 */
	/**
	 * Test del m�todo addEdge que no tiene errores
	 */
	@Test
	public void testAddEdgeNormal() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;		
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0, g.addEdge(node, node2, 12));
		System.out.println(g.toString());	
	}
	/**
	 * Test del m�todo addEdge donde no existe el nodo origen
	 */
	@Test
	public void testAddEdgeSourceDontExist() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 23;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));		
		assertEquals(-1, g.addEdge(node3, node2, 12));
		System.out.println(g.toString());	
	}
	/**
	 * Test del m�todo addEdge donde no existe el nodo destino
	 */
	@Test
	public void testAddEdgeTargetDontExist() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 23;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));		
		assertEquals(-2, g.addEdge(node, node3, 12));
		System.out.println(g.toString());	
	}
	/**
	 * Test del m�todo addEdge donde ya existe la arista
	 */
	@Test
	public void testAddEdgeEdgeExist() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 12));
		assertEquals(-4, g.addEdge(node, node2, 12));
		System.out.println(g.toString());	
	}
	/**
	 * Test del m�todo addEdge donde el peso no es valido
	 */
	@Test
	public void testAddEdgeEdgeWightError() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(-8, g.addEdge(node, node2, -4));
		System.out.println(g.toString());	
	}
	/**
	 * Test del m�todo addEdge donde no existen los nodos 
	 */
	@Test
	public void testAddEdgeSourceTargetError() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 12;
		int node4 = 56;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(-3, g.addEdge(node3, node4, 4));
		System.out.println(g.toString());	
	}
	/**
	 * Test del m�todo addEdge donde ya existe la arista y el peso no es valido
	 */
	@Test
	public void testAddEdgeEdgeExistsEdgeWeightError() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(-12, g.addEdge(node, node2, -4));
		System.out.println(g.toString());	
	}
	
/*
 * Pruebas del m�todo getEdge:
 */
	/**
	 * Test del m�todo getEdge que no tiene errores
	 */
	@Test
	public void testGetEdgeNormal() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(4, g.getEdge(node, node2),0.1);
	}
	/**
	 * Test del m�todo getEdge donde no existe el nodo origen
	 */
	@Test
	public void testGetEdgeSourceDontExist() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 4;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(-1, g.getEdge(node3, node2),0.1);
	}
	/**
	 * Test del m�todo getEdge donde no existe el nodo destino
	 */
	@Test
	public void testGetEdgeTargetDontExist() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 4;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(-2, g.getEdge(node, node3),0.1);
	}
	/**
	 * Test del m�todo getEdge donde existen los nodos y no la arista
	 */
	@Test
	public void testGetEdgeEdgeDontExist() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(-4, g.getEdge(node, node2),0.1);
	}
	/**
	 * Test del m�todo getEdge donde no existen los nodos
	 */
	@Test
	public void testGetEdgeBothDontExist() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 4;
		int node4 = 6;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(-3, g.getEdge(node3, node4),0.1);
	}
	
/*
 * Pruebas del m�todo existsEdge:
 */
	/**
	 * Test del m�todo existsEdge que no tiene errores
	 */
	@Test
	public void testExistsEdgeNormal() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertTrue(g.existsEdge(node, node2));
	}
	/**
	 * Test del m�todo existsEdge donde no existe el nodo origen
	 */
	@Test
	public void testExistsEdgeSourceDontExists() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3= 8;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertFalse(g.existsEdge(node3, node2));
	}
	/**
	 * Test del m�todo existsEdge donde no existe el nodo destino
	 */
	@Test
	public void testExistsEdgeTargetDontExists() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3= 8;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertFalse(g.existsEdge(node, node3));
	}
	/**
	 * Test del m�todo existsEdge donde no existen los nodos
	 */
	@Test
	public void testExistsEdgeBothDontExists() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 8;
		int node4 = 12;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertFalse(g.existsEdge(node3, node4));
	}
	
/*
 * Pruebas del m�todo removeEdge:
 */
	/**
	 * Test del m�todo removeEdge que no tiene errores 
	 */
	@Test
	public void testRemoveEdgeNormal() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 8;
		int node4 = 12; 
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addNode(node3));
		assertEquals(0,g.addNode(node4));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(0,g.addEdge(node3, node4, 12));
		assertEquals(0, g.removeEdge(node3, node4));
		System.out.println(g.toString());
	}
	/**
	 * Test del m�todo removeEdge donde no existe el nodo origen
	 */
	@Test
	public void testRemoveEdgeSourceDontExists() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 8;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(-1, g.removeEdge(node3, node2));
		System.out.println(g.toString());
	}
	/**
	 * Test del m�todo removeEdge donde no existe el nodo destino
	 */
	@Test
	public void testRemoveEdgeTargetDontExists() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 8;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(-2, g.removeEdge(node2, node3));
		System.out.println(g.toString());
	}
	/**
	 * Test del m�todo removeEdge donde existen los nodos y no la arista
	 */
	@Test
	public void testRemoveEdgeEdgeDontExistsNodesExists() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(-4, g.removeEdge(node2, node));
		System.out.println(g.toString());
	}	
	/**
	 * Test del m�todo removeEdge donde no existen los nodos
	 */
	@Test
	public void testRemoveEdgeNodesDontExists() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 8;
		int node4 = 12;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(-3, g.removeEdge(node3, node4));
		System.out.println(g.toString());
	}
/*
 * Pruebas del m�todo removeNode:
 */
	/**
	 * Test del m�todo removeNode que no tiene errores
	 */
	@Test
	public void testRemoveNodeNormal() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;		
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(0, g.removeNode(node));
		assertFalse(g.existsNode(node));
		assertFalse(g.existsEdge(node, node2));
		System.out.println(g.toString());
	}
	/**
	 * Test del m�todo removeNode que no tiene errores y borra toda la matriz
	 */
	@Test
	public void testRemoveNodeVarious() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 8;
		int node4 = 12;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addNode(node3));
		assertEquals(0,g.addNode(node4));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(0,g.addEdge(node, node, 12));
		assertEquals(0,g.addEdge(node3, node, 7));
		assertEquals(0,g.addEdge(node, node4, 15));
		assertEquals(0,g.addEdge(node, node3, 9));
		assertEquals(0, g.removeNode(node));
		assertFalse(g.existsNode(node));
		assertFalse(g.existsEdge(node, node2));
		assertFalse(g.existsEdge(node, node));
		assertFalse(g.existsEdge(node3, node));
		assertFalse(g.existsEdge(node, node4));
		assertFalse(g.existsEdge(node, node3));
		System.out.println(g.toString());
	}	
	/**
	 * Test del m�todo removeNode donde el nodo no es valido
	 */
	@Test
	public void testRemoveNodeNotValid() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;		
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(-1, g.removeNode(null));
		System.out.println(g.toString());
	}
	/**
	 * Test del m�todo removeNode donde el nodo no existe
	 */
	@Test
	public void testRemoveNodeDontExists() {
		g = new Graph<Integer>(5);
		int node = 1;
		int node2 = 18;
		int node3 = 12;
		assertEquals(0,g.addNode(node));
		assertEquals(0,g.addNode(node2));
		assertEquals(0,g.addEdge(node, node2, 4));
		assertEquals(-1, g.removeNode(node3));
		System.out.println(g.toString());
	}
	
/*
 * Prueba del m�todo dijkstra:
 */
	/**
	 * Test del m�todo de Dijkstra con un grafo de 4 nodos
	 */
	@Test
	public void testDijkstra4Node() {
		g = new Graph<Integer>(4);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;
		int v4 = 4;
		//A�adir los nodos
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		//A�adir las aristas
		assertEquals(0, g.addEdge(v1, v2, 2));
		assertEquals(0, g.addEdge(v2, v3, 1));
		assertEquals(0, g.addEdge(v2, v4, 2));
		assertEquals(0, g.addEdge(v3, v2, 4));
		System.out.println(g.toString());
		//Todos los caminos posibles:
		assertArrayEquals(new double[] {0,2,3,4}, g.dijkstra(v1));
		assertArrayEquals(new double[] {infinite,0,1,2}, g.dijkstra(v2));
		assertArrayEquals(new double[] {infinite,4,0,6}, g.dijkstra(v3));
		assertArrayEquals(new double[] {infinite,infinite,infinite,0}, g.dijkstra(v4));
	}
	/**
	 * Test del m�todo de Dijkstra con un grafo de 5 nodos
	 */
	@Test
	public void testDijkstra5Node() {
		g = new Graph<Integer>(5);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;
		int v4 = 4;
		int v5 = 5;
		//A�adir los nodos
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		assertEquals(0, g.addNode(v5));
		//A�adir las aristas
		assertEquals(0,g.addEdge(v1, v2, 1));
		assertEquals(0,g.addEdge(v1, v4, 3));
		assertEquals(0,g.addEdge(v1, v5, 10));
		assertEquals(0,g.addEdge(v2, v3, 5));
		assertEquals(0,g.addEdge(v3, v5, 1));
		assertEquals(0,g.addEdge(v4, v3, 2));
		assertEquals(0,g.addEdge(v4, v5, 6));
		System.out.println(g.toString());
		//Todos los caminos posibles:
		assertArrayEquals(new double[] {0,1,5,3,6}, g.dijkstra(v1));
		assertArrayEquals(new double[] {infinite,0,5,infinite,6}, g.dijkstra(v2));
		assertArrayEquals(new double[] {infinite,infinite,0,infinite,1}, g.dijkstra(v3));
		assertArrayEquals(new double[] {infinite,infinite,2,0,3}, g.dijkstra(v4));
		assertArrayEquals(new double[] {infinite,infinite,infinite,infinite,0}, g.dijkstra(v5));
	}
	/**
	 * Test del m�todo de Dijkstra con un grafo de 6 nodos
	 */
	@Test
	public void testDijkstra6Node() {
		g = new Graph<Integer>(6);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;
		int v4 = 4;
		int v5 = 5;
		int v6 = 6;
		//A�adir los nodos
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		assertEquals(0, g.addNode(v5));
		assertEquals(0, g.addNode(v6));
		//A�adir las aristas
		assertEquals(0, g.addEdge(v1, v2, 3));
		assertEquals(0, g.addEdge(v1, v3, 4));
		assertEquals(0, g.addEdge(v1, v5, 8));
		assertEquals(0, g.addEdge(v2, v5, 5));
		assertEquals(0, g.addEdge(v3, v5, 3));
		assertEquals(0, g.addEdge(v5, v4, 7));
		assertEquals(0, g.addEdge(v5, v6, 3));
		assertEquals(0, g.addEdge(v6, v4, 2));
		System.out.println(g.toString());
		//Todos los caminos posibles:
		assertArrayEquals(new double[] {0,3,4,12,7,10}, g.dijkstra(v1));
		assertArrayEquals(new double[] {infinite,0,infinite,10,5,8}, g.dijkstra(v2));
		assertArrayEquals(new double[] {infinite,infinite,0,8,3,6}, g.dijkstra(v3));
		assertArrayEquals(new double[] {infinite,infinite,infinite,0,infinite,infinite}, g.dijkstra(v4));
		assertArrayEquals(new double[] {infinite,infinite,infinite,5,0,3}, g.dijkstra(v5));
		assertArrayEquals(new double[] {infinite,infinite,infinite,2,infinite,0}, g.dijkstra(v6));
	}	
	/**
	 * Test del m�todo de Dijkstra con un grafo de 7 nodos
	 */
	@Test
	public void testDijkstra7Node() {
		g = new Graph<Integer>(7);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;
		int v4 = 4;
		int v5 = 5;
		int v6 = 6;
		int v7 = 7;
		//A�adir los nodos
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		assertEquals(0, g.addNode(v5));
		assertEquals(0, g.addNode(v6));
		assertEquals(0, g.addNode(v7));
		//A�adir las aristas
		assertEquals(0, g.addEdge(v1, v2, 1));
		assertEquals(0, g.addEdge(v1, v3, 2));
		assertEquals(0, g.addEdge(v2, v1, 3));
		assertEquals(0, g.addEdge(v2, v4, 4));
		assertEquals(0, g.addEdge(v2, v7, 7));
		assertEquals(0, g.addEdge(v3, v5, 5));
		assertEquals(0, g.addEdge(v4, v6, 8));
		assertEquals(0, g.addEdge(v5, v3, 4));
		assertEquals(0, g.addEdge(v5, v6, 1));
		assertEquals(0, g.addEdge(v5, v7, 3));
		assertEquals(0, g.addEdge(v6, v4, 1));
		assertEquals(0, g.addEdge(v6, v7, 2));
		System.out.println(g.toString());
		//Todos los caminos posibles:
		assertArrayEquals(new double[] {0,1,2,5,7,8,8}, g.dijkstra(v1));
		assertArrayEquals(new double[] {3,0,5,4,10,11,7}, g.dijkstra(v2));
		assertArrayEquals(new double[] {infinite,infinite,0,7,5,6,8}, g.dijkstra(v3));
		assertArrayEquals(new double[] {infinite,infinite,infinite,0,infinite,8,10}, g.dijkstra(v4));
		assertArrayEquals(new double[] {infinite,infinite,4,2,0,1,3}, g.dijkstra(v5));
		assertArrayEquals(new double[] {infinite,infinite,infinite,1,infinite,0,2}, g.dijkstra(v6));
		assertArrayEquals(new double[] {infinite,infinite,infinite,infinite,infinite,infinite,0}, g.dijkstra(v7));
	}
	
/*
 * Pruebas del m�todo floyd:
 */
	/**
	 * Test del m�todo de Floyd con un grafo de 4 nodos
	 */
	@Test
	public void testFloyd4Node() {
		g = new Graph<Integer>(4);
		int v0 = 0;
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;
		//A�adir los nodos
		assertEquals(0, g.addNode(v0));
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		//A�adir las aristas
		assertEquals(0, g.addEdge(v0, v1, 2));
		assertEquals(0, g.addEdge(v1, v2, 1));
		assertEquals(0, g.addEdge(v1, v3, 2));
		assertEquals(0, g.addEdge(v2, v1, 4));
		assertEquals(0,g.floyd());
		System.out.println(g.toString());
		//Comprobaci�n Floyd:
		assertArrayEquals(new double[][] {{0,2,3,4},{infinite,0,1,2},
			{infinite,4,0,6},{infinite,infinite,infinite,0}},g.getAFloyd());
		assertArrayEquals(new int[][] {{-1,-1,1,1},{-1,-1,-1,-1},{-1,-1,-1,1},
			{-1,-1,-1,-1}},g.getPFloyd());
		//Prueba de que al modificar el grafo, las matrices de floyd vuelven a ser null
		assertEquals(0, g.removeNode(v2));
		assertNull(g.getAFloyd());
		assertNull(g.getPFloyd());
	}
	/**
	 * Test del m�todo de Floyd con un grafo de 5 nodos
	 */
	@Test
	public void testFloyd5Node() {
		g = new Graph<Integer>(6);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;
		int v4 = 4;
		int v5 = 5;		
		//A�adir los nodos
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		assertEquals(0, g.addNode(v5));
		//A�adir las aristas
		assertEquals(0,g.addEdge(v1, v2, 1));
		assertEquals(0,g.addEdge(v1, v4, 3));
		assertEquals(0,g.addEdge(v1, v5, 10));
		assertEquals(0,g.addEdge(v2, v3, 5));
		assertEquals(0,g.addEdge(v3, v5, 1));
		assertEquals(0,g.addEdge(v4, v3, 2));
		assertEquals(0,g.addEdge(v4, v5, 6));
		assertEquals(0,g.floyd());
		System.out.println(g.toString());
		//Comprobaci�n Floyd:
		assertArrayEquals(new double[][] {{0,1,5,3,6},{infinite,0,5,infinite,6},
			{infinite,infinite,0,infinite,1},{infinite,infinite,2,0,3},
			{infinite,infinite,infinite,infinite,0}},g.getAFloyd());
		assertArrayEquals(new int[][] {{-1,-1,3,-1,3},{-1,-1,-1,-1,2},
			{-1,-1,-1,-1,-1},{-1,-1,-1,-1,2},{-1,-1,-1,-1,-1}},g.getPFloyd());
		//Prueba de que al modificar el grafo, las matrices de floyd vuelven a ser null
		int v6 = 6;
		assertEquals(0, g.addNode(v6));
		assertNull(g.getAFloyd());
		assertNull(g.getPFloyd());
	}
	/**
	 * Test del m�todo de Floyd con un grafo de 6 nodos
	 */
	@Test
	public void testFloyd6Node() {
		g = new Graph<Integer>(6);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;
		int v4 = 4;
		int v5 = 5;
		int v6 = 6;
		//A�adir los nodos
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		assertEquals(0, g.addNode(v5));
		assertEquals(0, g.addNode(v6));
		//A�adir las aristas
		assertEquals(0, g.addEdge(v1, v2, 3));
		assertEquals(0, g.addEdge(v1, v3, 4));
		assertEquals(0, g.addEdge(v1, v5, 8));
		assertEquals(0, g.addEdge(v2, v5, 5));
		assertEquals(0, g.addEdge(v3, v5, 3));
		assertEquals(0, g.addEdge(v5, v4, 7));
		assertEquals(0, g.addEdge(v5, v6, 3));
		assertEquals(0, g.addEdge(v6, v4, 2));
		assertEquals(0,g.floyd());
		System.out.println(g.toString());
		//Comprobaci�n Floyd:
		assertArrayEquals(new double[][] {{0,3,4,12,7,10},{infinite,0,infinite,10,5,8},
			{infinite,infinite,0,8,3,6},{infinite,infinite,infinite,0,infinite,infinite},
			{infinite,infinite,infinite,5,0,3},{infinite,infinite,infinite,2,infinite,0}},g.getAFloyd());
		assertArrayEquals(new int[][] {{-1,-1,-1,5,2,4},{-1,-1,-1,5,-1,4},{-1,-1,-1,5,-1,4},
			{-1,-1,-1,-1,-1,-1},{-1,-1,-1,5,-1,-1},{-1,-1,-1,-1,-1,-1}},g.getPFloyd());
		//Prueba de que al modificar el grafo, las matrices de floyd vuelven a ser null		
		assertEquals(0, g.removeEdge(v1, v3));
		assertNull(g.getAFloyd());
		assertNull(g.getPFloyd());
	}	
	/**
	 * Test del m�todo de Floyd con un grafo de 7 nodos
	 */
	@Test
	public void testFloyd7Node() {
		g = new Graph<Integer>(7);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;
		int v4 = 4;
		int v5 = 5;
		int v6 = 6;
		int v7 = 7;
		//A�adir los nodos
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		assertEquals(0, g.addNode(v5));
		assertEquals(0, g.addNode(v6));
		assertEquals(0, g.addNode(v7));
		//A�adir las aristas
		assertEquals(0, g.addEdge(v1, v2, 1));
		assertEquals(0, g.addEdge(v1, v3, 2));
		assertEquals(0, g.addEdge(v2, v1, 3));
		assertEquals(0, g.addEdge(v2, v4, 4));
		assertEquals(0, g.addEdge(v2, v7, 7));
		assertEquals(0, g.addEdge(v3, v5, 5));
		assertEquals(0, g.addEdge(v4, v6, 8));
		assertEquals(0, g.addEdge(v5, v3, 4));
		assertEquals(0, g.addEdge(v5, v6, 1));
		assertEquals(0, g.addEdge(v5, v7, 3));
		assertEquals(0, g.addEdge(v6, v4, 1));
		assertEquals(0, g.addEdge(v6, v7, 2));
		assertEquals(0,g.floyd());
		System.out.println(g.toString());
		//Comprobaci�n Floyd:
		assertArrayEquals(new double[][] {{0,1,2,5,7,8,8},{3,0,5,4,10,11,7},
			{infinite,infinite,0,7,5,6,8},{infinite,infinite,infinite,0,infinite,8,10},
			{infinite,infinite,4,2,0,1,3},{infinite,infinite,infinite,1,infinite,0,2},
			{infinite,infinite,infinite,infinite,infinite,infinite,0}},g.getAFloyd());
		assertArrayEquals(new int[][] {{-1,-1,-1,1,2,4,1},{-1,-1,0,-1,2,4,-1},{-1,-1,-1,5,-1,4,4},
			{-1,-1,-1,-1,-1,-1,5},{-1,-1,-1,5,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1}},g.getPFloyd());
		//Prueba de que al modificar el grafo, las matrices de floyd vuelven a ser null		
		assertEquals(0, g.addEdge(v1, v7, 1));
		assertNull(g.getAFloyd());
		assertNull(g.getPFloyd());
	}
	/**
	 * Test del m�todo de Floyd con un grafo sin nodos
	 */
	@Test
	public void testFloydNoNodes() {
		g = new Graph<Integer>(3);
		assertEquals(-1,g.floyd());
		System.out.println(g.toString());
	}
	
/*
 * Pruebas del m�todo minCostPath: 
 */
	/**
	 * Test del m�todo minCostPath que comprueba todos los costes del grafo de 7 nodos 
	 */
	@Test
	public void testMinCostPath7Nodes() {
		g = new Graph<Integer>(7);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;
		int v4 = 4;
		int v5 = 5;
		int v6 = 6;
		int v7 = 7;
		//A�adir los nodos
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		assertEquals(0, g.addNode(v5));
		assertEquals(0, g.addNode(v6));
		assertEquals(0, g.addNode(v7));
		//A�adir las aristas
		assertEquals(0, g.addEdge(v1, v2, 1));
		assertEquals(0, g.addEdge(v1, v3, 2));
		assertEquals(0, g.addEdge(v2, v1, 3));
		assertEquals(0, g.addEdge(v2, v4, 4));
		assertEquals(0, g.addEdge(v2, v7, 7));
		assertEquals(0, g.addEdge(v3, v5, 5));
		assertEquals(0, g.addEdge(v4, v6, 8));
		assertEquals(0, g.addEdge(v5, v3, 4));
		assertEquals(0, g.addEdge(v5, v6, 1));
		assertEquals(0, g.addEdge(v5, v7, 3));
		assertEquals(0, g.addEdge(v6, v4, 1));
		assertEquals(0, g.addEdge(v6, v7, 2));
		assertEquals(0,g.floyd());
		System.out.println(g.toString());
		//Comprobaci�n minCostPath
		//Desde el nodo 1
		assertEquals(0, g.minCostPath(v1, v1), 0.01);
		assertEquals(1, g.minCostPath(v1, v2), 0.01);
		assertEquals(2, g.minCostPath(v1, v3), 0.01);
		assertEquals(5, g.minCostPath(v1, v4), 0.01);
		assertEquals(7, g.minCostPath(v1, v5), 0.01);
		assertEquals(8, g.minCostPath(v1, v6), 0.01);
		assertEquals(8, g.minCostPath(v1, v7), 0.01);
		//Desde el nodo 2		
		assertEquals(3, g.minCostPath(v2, v1), 0.01);
		assertEquals(0, g.minCostPath(v2, v2), 0.01);
		assertEquals(5, g.minCostPath(v2, v3), 0.01);
		assertEquals(4, g.minCostPath(v2, v4), 0.01);
		assertEquals(10, g.minCostPath(v2, v5), 0.01);
		assertEquals(11, g.minCostPath(v2, v6), 0.01);
		assertEquals(7, g.minCostPath(v2, v7), 0.01);
		//Desde el nodo 3		
		assertEquals(infinite, g.minCostPath(v3, v1), 0.01);
		assertEquals(infinite, g.minCostPath(v3, v2), 0.01);
		assertEquals(0, g.minCostPath(v3, v3), 0.01);
		assertEquals(7, g.minCostPath(v3, v4), 0.01);
		assertEquals(5, g.minCostPath(v3, v5), 0.01);
		assertEquals(6, g.minCostPath(v3, v6), 0.01);
		assertEquals(8, g.minCostPath(v3, v7), 0.01);
		//Desde el nodo 4
		assertEquals(infinite, g.minCostPath(v4, v1), 0.01);
		assertEquals(infinite, g.minCostPath(v4, v2), 0.01);
		assertEquals(infinite, g.minCostPath(v4, v3), 0.01);		
		assertEquals(0, g.minCostPath(v4, v4), 0.01);
		assertEquals(infinite, g.minCostPath(v4, v5), 0.01);
		assertEquals(8, g.minCostPath(v4, v6), 0.01);
		assertEquals(10, g.minCostPath(v4, v7), 0.01);
		//Desde el nodo 5
		assertEquals(infinite, g.minCostPath(v5, v1), 0.01);
		assertEquals(infinite, g.minCostPath(v5, v2), 0.01);
		assertEquals(4, g.minCostPath(v5, v3), 0.01);
		assertEquals(2, g.minCostPath(v5, v4), 0.01);
		assertEquals(0, g.minCostPath(v5, v5), 0.01);
		assertEquals(1, g.minCostPath(v5, v6), 0.01);
		assertEquals(3, g.minCostPath(v5, v7), 0.01);
		//Desde el nodo 6
		assertEquals(infinite, g.minCostPath(v6, v1), 0.01);
		assertEquals(infinite, g.minCostPath(v6, v2), 0.01);
		assertEquals(infinite, g.minCostPath(v6, v3), 0.01);
		assertEquals(1, g.minCostPath(v6, v4), 0.01);
		assertEquals(infinite, g.minCostPath(v6, v5), 0.01);
		assertEquals(0, g.minCostPath(v6, v6), 0.01);
		assertEquals(2, g.minCostPath(v6, v7), 0.01);
		//Desde el nodo 7
		assertEquals(infinite, g.minCostPath(v7, v1), 0.01);
		assertEquals(infinite, g.minCostPath(v7, v2), 0.01);
		assertEquals(infinite, g.minCostPath(v7, v3), 0.01);
		assertEquals(infinite, g.minCostPath(v7, v4), 0.01);
		assertEquals(infinite, g.minCostPath(v7, v5), 0.01);
		assertEquals(infinite, g.minCostPath(v7, v6), 0.01);
		assertEquals(0, g.minCostPath(v7, v7), 0.01);
	}	
	/**
	 * Test del m�todo minCostPath sin las matrices de floyd y con fallos (nodos origen y/o destino no existen)
	 */
	@Test
	public void testMinCostPathNotValid() {
		g = new Graph<Integer>(4);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;		
		int v4 = 4;
		
		int v5 = 5;
		int v6 = 6;		
		//A�adir los nodos		
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		//A�adir las aristas
		assertEquals(0, g.addEdge(v1, v2, 2));
		assertEquals(0, g.addEdge(v2, v3, 1));
		assertEquals(0, g.addEdge(v2, v4, 2));
		assertEquals(0, g.addEdge(v3, v2, 4));		
		//No estan generadas las matrices de Floyd (las genera)
		assertEquals(0, g.minCostPath(v1, v1),0.01);
		assertEquals(2, g.minCostPath(v1, v2),0.01);
		assertEquals(3, g.minCostPath(v1, v3),0.01);
		assertEquals(4, g.minCostPath(v1, v4),0.01);
		//No existen el nodoOrigen o nodoDestino
		assertEquals(-1, g.minCostPath(v5, v1),0.01);
		assertEquals(-1, g.minCostPath(v1, v6),0.01);
		assertEquals(-1, g.minCostPath(v5, v6),0.01);
	}
	
/*
 * Pruebas del m�todo path:
 */
	/**
	 * Test del m�todo path con un grafo de 7 nodos que comprueba todos los caminos posibles
	 */
	@Test
	public void testPath7Nodes() {
		g = new Graph<Integer>(7);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;
		int v4 = 4;
		int v5 = 5;
		int v6 = 6;
		int v7 = 7;
		//A�adir los nodos
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		assertEquals(0, g.addNode(v5));
		assertEquals(0, g.addNode(v6));
		assertEquals(0, g.addNode(v7));
		//A�adir las aristas
		assertEquals(0, g.addEdge(v1, v2, 1));
		assertEquals(0, g.addEdge(v1, v3, 2));
		assertEquals(0, g.addEdge(v2, v1, 3));
		assertEquals(0, g.addEdge(v2, v4, 4));
		assertEquals(0, g.addEdge(v2, v7, 7));
		assertEquals(0, g.addEdge(v3, v5, 5));
		assertEquals(0, g.addEdge(v4, v6, 8));
		assertEquals(0, g.addEdge(v5, v3, 4));
		assertEquals(0, g.addEdge(v5, v6, 1));
		assertEquals(0, g.addEdge(v5, v7, 3));
		assertEquals(0, g.addEdge(v6, v4, 1));
		assertEquals(0, g.addEdge(v6, v7, 2));
		assertEquals(0,g.floyd());
		System.out.println(g.toString());
		//Comprobaci�n caminos
		//Desde el nodo 1
		assertEquals("1\t(1.0)\t2\t(7.0)\t7", g.path(v1, v7));
		assertEquals("1\t(2.0)\t3\t(5.0)\t5\t(1.0)\t6", g.path(v1, v6));
		assertEquals("1\t(2.0)\t3\t(5.0)\t5", g.path(v1, v5));
		assertEquals("1\t(1.0)\t2\t(4.0)\t4", g.path(v1, v4));
		assertEquals("1\t(2.0)\t3", g.path(v1, v3));
		assertEquals("1\t(1.0)\t2", g.path(v1, v2));
		assertEquals("1\t", g.path(v1, v1));
		//Desde el nodo 2
		assertEquals("2\t(7.0)\t7", g.path(v2, v7));
		assertEquals("2\t(3.0)\t1\t(2.0)\t3\t(5.0)\t5\t(1.0)\t6", g.path(v2, v6));
		assertEquals("2\t(3.0)\t1\t(2.0)\t3\t(5.0)\t5", g.path(v2, v5));
		assertEquals("2\t(4.0)\t4", g.path(v2, v4));
		assertEquals("2\t(3.0)\t1\t(2.0)\t3", g.path(v2, v3));
		assertEquals("2\t", g.path(v2, v2));
		assertEquals("2\t(3.0)\t1", g.path(v2, v1));
		//Desde el nodo 3
		assertEquals("3\t(5.0)\t5\t(3.0)\t7", g.path(v3, v7));
		assertEquals("3\t(5.0)\t5\t(1.0)\t6", g.path(v3, v6));
		assertEquals("3\t(5.0)\t5", g.path(v3, v5));
		assertEquals("3\t(5.0)\t5\t(1.0)\t6\t(1.0)\t4", g.path(v3, v4));
		assertEquals("3\t", g.path(v3, v3));
		assertEquals("3\t" + infinite + "\t2", g.path(v3, v2));
		assertEquals("3\t" + infinite + "\t1", g.path(v3, v1));
		//Desde el nodo 4
		assertEquals("4\t(8.0)\t6\t(2.0)\t7", g.path(v4, v7));
		assertEquals("4\t(8.0)\t6", g.path(v4, v6));
		assertEquals("4\t" + infinite + "\t5", g.path(v4, v5));
		assertEquals("4\t", g.path(v4, v4));
		assertEquals("4\t" + infinite + "\t3", g.path(v4, v3));
		assertEquals("4\t" + infinite + "\t2", g.path(v4, v2));
		assertEquals("4\t" + infinite + "\t1", g.path(v4, v1));
		//Desde el nodo 5
		assertEquals("5\t(3.0)\t7", g.path(v5, v7));
		assertEquals("5\t(1.0)\t6", g.path(v5, v6));
		assertEquals("5\t", g.path(v5, v5));
		assertEquals("5\t(1.0)\t6\t(1.0)\t4", g.path(v5, v4));
		assertEquals("5\t(4.0)\t3", g.path(v5, v3));
		assertEquals("5\t" + infinite + "\t2", g.path(v5, v2));
		assertEquals("5\t" + infinite + "\t1", g.path(v5, v1));
		//Desde el nodo 6
		assertEquals("6\t(2.0)\t7", g.path(v6, v7));
		assertEquals("6\t", g.path(v6, v6));
		assertEquals("6\t" + infinite + "\t5", g.path(v6, v5));
		assertEquals("6\t(1.0)\t4", g.path(v6, v4));
		assertEquals("6\t" + infinite + "\t3", g.path(v6, v3));
		assertEquals("6\t" + infinite + "\t2", g.path(v6, v2));
		assertEquals("6\t" + infinite + "\t1", g.path(v6, v1));	
		//Desde el nodo 7
		assertEquals("7\t", g.path(v7, v7));
		assertEquals("7\t" + infinite + "\t6", g.path(v7, v6));
		assertEquals("7\t" + infinite + "\t5", g.path(v7, v5));
		assertEquals("7\t" + infinite + "\t4", g.path(v7, v4));
		assertEquals("7\t" + infinite + "\t3", g.path(v7, v3));
		assertEquals("7\t" + infinite + "\t2", g.path(v7, v2));
		assertEquals("7\t" + infinite + "\t1", g.path(v7, v1));
	}
	/**
	 * Test del m�todo Path sin las matrices de floyd y con fallos (nodos origen y destino no existen)
	 */
	@Test
	public void testPathNotValid() {
		g = new Graph<Integer>(4);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;		
		int v4 = 4;
		
		int v5 = 5;
		int v6 = 6;		
		//A�adir los nodos		
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		//A�adir las aristas
		assertEquals(0, g.addEdge(v1, v2, 2));
		assertEquals(0, g.addEdge(v2, v3, 1));
		assertEquals(0, g.addEdge(v2, v4, 2));
		assertEquals(0, g.addEdge(v3, v2, 4));		
		//No estan generadas las matrices de Floyd (las genera)
		assertEquals("1\t", g.path(v1, v1));
		assertEquals("1\t(2.0)\t2", g.path(v1, v2));
		assertEquals("1\t(2.0)\t2\t(1.0)\t3", g.path(v1, v3));
		assertEquals("1\t(2.0)\t2\t(2.0)\t4", g.path(v1, v4));
		//No existen el nodoOrigen y/o nodoDestino
		assertEquals("", g.path(v5,v1));
		assertEquals("", g.path(v1,v6));
		assertEquals("", g.path(v5, v6));
	}
	
/*
 * Pruebas del m�todo recorridoProfundidad:
 */
	/**
	 * Test del m�todo recorridoProfundidad con un grafo de 7 nodos que comprueba todos los recorridos posibles
	 */
	@Test
	public void testRecorridoProfundidad7Nodes() {
		g = new Graph<Integer>(7);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;
		int v4 = 4;
		int v5 = 5;
		int v6 = 6;
		int v7 = 7;
		//A�adir los nodos
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		assertEquals(0, g.addNode(v5));
		assertEquals(0, g.addNode(v6));
		assertEquals(0, g.addNode(v7));
		//A�adir las aristas
		assertEquals(0, g.addEdge(v1, v2, 1));
		assertEquals(0, g.addEdge(v1, v3, 2));
		assertEquals(0, g.addEdge(v2, v1, 3));
		assertEquals(0, g.addEdge(v2, v4, 4));
		assertEquals(0, g.addEdge(v2, v7, 7));
		assertEquals(0, g.addEdge(v3, v5, 5));
		assertEquals(0, g.addEdge(v4, v6, 8));
		assertEquals(0, g.addEdge(v5, v3, 4));
		assertEquals(0, g.addEdge(v5, v6, 1));
		assertEquals(0, g.addEdge(v5, v7, 3));
		assertEquals(0, g.addEdge(v6, v4, 1));
		assertEquals(0, g.addEdge(v6, v7, 2));
		assertEquals(0,g.floyd());
		System.out.println(g.toString());
		//Comprobaci�n recorridoProfundidad
		assertEquals("1\t2\t4\t6\t7\t3\t5\t",g.recorridoProfundidad(v1));
		assertEquals("2\t1\t3\t5\t6\t4\t7\t",g.recorridoProfundidad(v2));
		assertEquals("3\t5\t6\t4\t7\t",g.recorridoProfundidad(v3));
		assertEquals("4\t6\t7\t",g.recorridoProfundidad(v4));
		assertEquals("5\t3\t6\t4\t7\t",g.recorridoProfundidad(v5));
		assertEquals("6\t4\t7\t",g.recorridoProfundidad(v6));
		assertEquals("7\t",g.recorridoProfundidad(v7));
	}
	/**
	 * Test del m�todo profundidad con un fallo de prueba (nodo origen no existe)
	 */
	@Test
	public void testRecorridoProfundidadNotValid() {
		g = new Graph<Integer>(4);
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;		
		int v4 = 4;
		
		int v5 = 5;
		//A�adir los nodos		
		assertEquals(0, g.addNode(v1));
		assertEquals(0, g.addNode(v2));
		assertEquals(0, g.addNode(v3));
		assertEquals(0, g.addNode(v4));
		//A�adir las aristas
		assertEquals(0, g.addEdge(v1, v2, 2));
		assertEquals(0, g.addEdge(v2, v3, 1));
		assertEquals(0, g.addEdge(v2, v4, 2));
		assertEquals(0, g.addEdge(v3, v2, 4));		
		//Comprobaci�n recorridoProfundidad
		assertEquals("1\t2\t3\t4\t", g.recorridoProfundidad(v1));
		assertEquals("2\t3\t4\t", g.recorridoProfundidad(v2));
		assertEquals("3\t2\t4\t", g.recorridoProfundidad(v3));
		assertEquals("4\t", g.recorridoProfundidad(v4));
		//No existen el nodoOrigen
		assertEquals("", g.recorridoProfundidad(v5));
	}	
	
//----------------------------- Test Correcciones ------------------------------
/*
 * Pruebas b�sicas:
 */
	/**
	 * Prueba b�sica de nodos
	 */
	@Test
	public void basicNodeTest() {
		g=new Graph<Integer>(3); 
	    assertFalse(g.existsNode(1)); //false
	    assertFalse(g.existsNode(2)); //false
	    assertEquals(0,g.addNode(1)); //0
		assertEquals(0,g.addNode(2)); //0
		assertTrue(g.existsNode(1)); //true
		assertTrue(g.existsNode(2)); //true
		assertEquals(-1,g.addNode(1)); //-1
		assertEquals(-1,g.addNode(2)); //-1
		assertEquals(0,g.addNode(3)); //0
		assertEquals(-2,g.addNode(4)); //-2
		assertFalse(g.existsNode(4)); //false
		assertFalse(g.existsNode(5)); //false
	}
	/**
	 * Prueba b�sica de aristas
	 */
	@Test
	public void basicEdgeTest() {
		g=new Graph<Integer>(3); 
		assertFalse(g.existsEdge(1,2)); //false
		assertEquals(-3.0,g.getEdge(1,2),0.001); //-3.0
		assertEquals(0,g.addNode(1)); //0
		assertFalse(g.existsEdge(1,2)); //false
		assertEquals(-2.0,g.getEdge(1,2),0.001); //-2.0
		assertFalse(g.existsEdge(2,1)); //false
		assertEquals(-1.0,g.getEdge(2,1),0.001); //-1.0
		assertEquals(0,g.addNode(2)); //0
		assertFalse(g.existsEdge(1,2)); //false
		assertEquals(-4.0,g.getEdge(1,2),0.001); //-4.0
		assertEquals(0,g.addEdge(1,2,12.12)); //0
		assertEquals(-4,g.addEdge(1,2,12.1212)); //-4
		assertEquals(0,g.addNode(3)); //0
		assertFalse(g.existsEdge(1,3)); //false
		assertFalse(g.existsEdge(3,2)); //false
		assertEquals(-4.0,g.getEdge(1,3),0.001); //-4.0
		assertEquals(-4.0,g.getEdge(3,2),0.001); //-4.0
		assertEquals(0,g.addEdge(1,1,11.11)); //0
		assertEquals(-4,g.addEdge(1,2,12.12)); //-4
		assertEquals(0,g.addEdge(1,3,13.13)); //0
		assertEquals(0,g.addEdge(2,1,21.21)); //0
		assertEquals(0,g.addEdge(2,2,22.22)); //0
		assertEquals(0,g.addEdge(2,3,23.23)); //0
		assertEquals(0,g.addEdge(3,1,31.31)); //0
		assertEquals(0,g.addEdge(3,2,32.32)); //0
		assertEquals(0,g.addEdge(3,3,33.33)); //0
		assertEquals(-4,g.addEdge(1,1,11.11)); //-4
		assertEquals(-4,g.addEdge(1,2,12.12)); //-4
		assertEquals(-4,g.addEdge(1,3,13.13)); //-4
		assertEquals(-4,g.addEdge(2,1,21.21)); //-4
		assertEquals(-4,g.addEdge(2,2,22.22)); //-4
		assertEquals(-4,g.addEdge(2,3,23.23)); //-4
		assertEquals(-4,g.addEdge(3,1,31.31)); //-4
		assertEquals(-4,g.addEdge(3,2,32.32)); //-4
		assertEquals(-4,g.addEdge(3,3,33.33)); //-4
		assertEquals(11.11,g.getEdge(1,1),0.001); //11.11
		assertEquals(12.12,g.getEdge(1,2),0.001); //12.12
		assertEquals(13.129999999999999,g.getEdge(1,3),0.001); //13.129999999999999
		assertEquals(21.21,g.getEdge(2,1),0.001); //21.21
		assertEquals(22.22,g.getEdge(2,2),0.001); //22.22
		assertEquals(23.23,g.getEdge(2,3),0.001); //23.23
		assertEquals(31.310000000000002,g.getEdge(3,1),0.001); //31.310000000000002
		assertEquals(32.32,g.getEdge(3,2),0.001); //32.32
		assertEquals(33.33,g.getEdge(3,3),0.001); //33.33
	}
	/**
	 * Prueba b�sica de evolucion
	 */
	@Test
	public void basicEvolutionTest() {
		g=new Graph<Integer>(3); 
		assertFalse(g.existsNode(1)); //false
		assertFalse(g.existsNode(2)); //false
		assertEquals(0,g.addNode(1)); //0
		assertEquals(0,g.addNode(2)); //0
		assertTrue(g.existsNode(1)); //true
		assertTrue(g.existsNode(2)); //true
		assertEquals(-1,g.addNode(1)); //-1
		assertEquals(-1,g.addNode(2)); //-1
		assertEquals(0,g.addEdge(1,2, 1.2)); //0
		assertEquals(0,g.addEdge(2,1, 2.1));//0
		assertEquals(0,g.addEdge(1,1, 1.1)); //0
		assertEquals(1.2,g.getEdge(1,2),0.001); //1.2
		assertEquals(2.1,g.getEdge(2,1),0.001); //2.1
		assertEquals(1.1,g.getEdge(1,1),0.001); //1.1
		assertEquals(-2.0,g.getEdge(2,3),0.001); //-2.0
		assertTrue(g.existsEdge(1,2)); //true
		assertTrue(g.existsEdge(2,1)); //true
		assertTrue(g.existsEdge(1,1)); //true
		assertFalse(g.existsEdge(2,2)); //false
		assertEquals(-4,g.removeEdge(2,2)); //-4
		assertEquals(0,g.addEdge(2,2,2.2)); //0
		assertEquals(2.2,g.getEdge(2,2),0.001); //2.2
		assertTrue(g.existsEdge(2,2)); //true
		assertEquals(0,g.removeEdge(2,2)); //0
		assertEquals(-1,g.removeNode(3)); //-1
		assertEquals(0,g.addNode(3)); //0		
		assertEquals(-2,g.addNode(4)); //-2
		assertEquals(-4.0,g.getEdge(1, 3),0.001); //-4.0
		assertEquals(0,g.addEdge(1,3, 1.3)); //0	
		assertTrue(g.existsEdge(1, 3)); //true	
		assertEquals(1.3,g.getEdge(1, 3),0.001); //1.3
		assertEquals(-2.0,g.getEdge(1, 4),0.001); //-2.0
		assertEquals(-1.0,g.getEdge(5,1),0.001); //-1.0
		assertEquals(-3.0,g.getEdge(5,4),0.001); //-3.0
		assertEquals(0,g.removeNode(3)); //0
		assertEquals(-1,g.removeNode(3)); //0---------------->(-1)
		assertFalse(g.existsEdge(1, 3)); //true---------------->(false)	
		assertEquals(-2.0,g.getEdge(1, 3),0.001); //1.3------------------->(-2.0)
		assertEquals(0,g.removeNode(2)); //0
		assertEquals(-1,g.removeNode(2)); //0--------------------->(-1)
		assertTrue(g.existsEdge(1, 1)); //true
		assertEquals(0,g.removeNode(1)); //0
		assertFalse(g.existsNode(1)); //true---------------------->(false)
		assertFalse(g.existsNode(2)); //true---------------------->(false)
		assertFalse(g.existsNode(3)); //true---------------------->(false)
		assertFalse(g.existsNode(4)); //false
		assertEquals(0,g.addNode(4)); //0
		assertTrue(g.existsNode(4)); //true
		assertEquals(0,g.addEdge(4,4, 4.4)); //0
		assertTrue(g.existsEdge(4, 4)); //true
		assertEquals(4.4,g.getEdge(4, 4),0.001); //4.4
		assertEquals(0,g.removeNode(4)); //0
		assertEquals(-1,g.removeNode(4)); //0----------------------->(-1)
		assertFalse(g.existsEdge(4, 4)); //true-------------------->(false)
		assertEquals(0,g.addNode(7)); //0
		assertEquals(-1,g.removeNode(2)); //0--------------------->(-1)
		assertEquals(-1,g.removeNode(3)); //0--------------------->(-1)
		assertEquals(-1,g.removeNode(4)); //-1
		assertFalse(g.existsEdge(7, 7)); //false
		assertEquals(0,g.addEdge(7,7, 7.7)); //0
		assertEquals(-4,g.addEdge(7,7, 17.17)); //-4
		assertEquals(7.7,g.getEdge(7, 7),0.001); //7.7
		assertEquals(0,g.addNode(8)); //0
		assertEquals(0,g.addNode(9)); //0
		assertFalse(g.existsEdge(7, 8)); //false
		assertFalse(g.existsEdge(8, 7)); //false
		assertFalse(g.existsEdge(8, 8)); //false
		assertFalse(g.existsEdge(8, 9)); //true-------------------->(false)
		assertFalse(g.existsEdge(9, 8)); //true-------------------->(false)
		assertFalse(g.existsEdge(9, 9)); //false
		assertEquals(0,g.addEdge(7,8, 7.8)); //0
		assertEquals(0,g.addEdge(8,7, 8.7)); //0
		assertEquals(0,g.addEdge(8,8, 8.8)); //0
		assertEquals(0,g.addEdge(8,9, 8.9)); //-4---------------------->(0)
		assertEquals(0,g.addEdge(9,8, 9.8)); //-4---------------------->(0)
		assertEquals(0,g.addEdge(9,9, 9.9)); //0
		assertEquals(0,g.addEdge(7,9, 7.9)); //0
		assertEquals(0,g.addEdge(9,7, 9.7)); //0
		assertEquals(7.7,g.getEdge(7, 7),0.001); //-4.0---------------------->(7.7)
		assertEquals(7.8,g.getEdge(7, 8),0.001); //7.8
		assertEquals(7.9,g.getEdge(7, 9),0.001); //7.9
		assertEquals(8.7,g.getEdge(8, 7),0.001); //8.7
		assertEquals(8.8,g.getEdge(8, 8),0.001); //8.8
		assertEquals(8.9,g.getEdge(8, 9),0.001); //1.2---------------------->(8.9)
		assertEquals(9.7,g.getEdge(9, 7),0.001); //9.7
		assertEquals(9.8,g.getEdge(9, 8),0.001); //2.1---------------------->(9.9)
		assertEquals(9.9,g.getEdge(9, 9),0.001); //9.9
		assertEquals(0,g.removeNode(7)); //0
		assertEquals(-1,g.removeNode(7)); //0
		assertEquals(-3.0,g.getEdge(7, 7),0.001); //-4.0---------------------->(-3.0)
		assertEquals(-1.0,g.getEdge(7, 8),0.001); //7.8---------------------->(-1.0)
		assertEquals(-1.0,g.getEdge(7, 9),0.001); //7.9---------------------->(-1.0)
		assertEquals(-2.0,g.getEdge(8, 7),0.001); //8.7---------------------->(-2.0)
		assertEquals(8.8,g.getEdge(8, 8),0.001); //8.8
		assertEquals(8.9,g.getEdge(8, 9),0.001); //1.2---------------------->(8.9)
		assertEquals(-2.0,g.getEdge(9, 7),0.001); //9.7---------------------->(-2.0)
		assertEquals(9.8,g.getEdge(9, 8),0.001); //2.1---------------------->(9.8)
		assertEquals(9.9,g.getEdge(9, 9),0.001); //9.9
		assertEquals(-1,g.removeNode(null)); //-1
		assertEquals(-4,g.addNode(null)); //-4
		assertEquals(0,g.addNode(10)); //0
		assertEquals(-4.0,g.getEdge(8, 10),0.001); //8.7---------------------->(-4.0)
		assertEquals(-4.0,g.getEdge(10, 9),0.001); //7.9---------------------->(-4.0)
		assertEquals(-6,g.addNode(null)); //-6
		assertEquals(-12,g.addEdge(8,8,-8.8)); //-12
		assertEquals(-9,g.addEdge(7,8,-7.8)); //-9
		assertEquals(-10,g.addEdge(8,7,-8.7)); //-10
		assertEquals(-11,g.addEdge(7,7,-7.7)); //-11
		assertEquals(-1,g.addEdge(null,8,0.8)); //-1
		assertEquals(-2,g.addEdge(8,null,0.8)); //-2
		assertEquals(-3,g.addEdge(null,null,0.8)); //-3
		assertEquals(-1.0,g.getEdge(null,10),0.001); //-1.0
		assertEquals(-2.0,g.getEdge(10,null),0.001); //-2.0
		assertEquals(-3.0,g.getEdge(null,null),0.001); //-3.0
		assertFalse(g.existsNode(null)); //true-------------------->(false)
		assertFalse(g.existsEdge(null,null)); //false
	}
}
