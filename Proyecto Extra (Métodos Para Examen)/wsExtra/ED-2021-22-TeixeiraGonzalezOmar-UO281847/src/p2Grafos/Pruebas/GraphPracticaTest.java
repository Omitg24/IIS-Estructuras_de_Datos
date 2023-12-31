package p2Grafos.Pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Titulo: Clase GraphPracticaTest
 * 
 * @author UO281847
 * @version 26/10/2021
 */
public class GraphPracticaTest {
	/**
	 * Atributo g
	 */
	private GraphPractica<Integer> g;
	
	/**
	 * Test de los ejercicios de practica del examen
	 */
	@Test
	public void testPractica() {
		g = new GraphPractica<Integer>(7);
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
		assertEquals(0, g.addEdge(v1, v2, 3));
		assertEquals(0, g.addEdge(v1, v3, 4));
		assertEquals(0, g.addEdge(v1, v5, 8));
		assertEquals(0, g.addEdge(v2, v5, 5));
		assertEquals(0, g.addEdge(v3, v5, 3));
		assertEquals(0, g.addEdge(v5, v4, 7));
		assertEquals(0, g.addEdge(v5, v6, 3));
		assertEquals(0, g.addEdge(v6, v4, 2));	
		
		assertEquals(0, g.floyd());
		
		System.out.println(g.toString());		
		assertEquals(1, g.contarSumideros());
		assertEquals(1, g.contarFuentes());
		assertEquals(2, g.contarInaccesibles());
		assertEquals(1, g.contarAislados());
		assertFalse(g.esConexo());
		assertFalse(g.contieneCiclos());
		assertEquals(0, g.reciprocity(), 0.001);
		assertEquals(null, g.obtenerCentro());
		assertEquals(1, g.getNumberOfReturnNodesWithinCost(1, 2));
	}
	
	/**
	 * Test 2 de los ejercicios de practica del examen
	 */
	@Test
	public void testPractica2() {
		g = new GraphPractica<Integer>(5);
		assertEquals(0, g.addNode(1));
		assertEquals(0, g.addNode(2));
		assertEquals(0, g.addNode(3));
		assertEquals(0, g.addNode(4));
		assertEquals(0, g.addNode(5));
		//A�adir las aristas
		assertEquals(0, g.addEdge(1, 2, 1));
		assertEquals(0, g.addEdge(2, 3, 2));
		assertEquals(0, g.addEdge(3, 4, 3));
		assertEquals(0, g.addEdge(4, 5, 4));
		assertEquals(0, g.addEdge(5, 1, 5));
		assertEquals(0, g.addEdge(5, 4, 4));
		assertEquals(0, g.addEdge(4, 3, 3));
		assertEquals(0, g.addEdge(3, 2, 2));
		assertEquals(0, g.addEdge(2, 1, 1));
		
		assertEquals(0, g.floyd());
		
		System.out.println(g.toString());		
		assertEquals(0, g.contarSumideros());
		assertEquals(0, g.contarFuentes());
		assertEquals(0, g.contarInaccesibles());
		assertEquals(0, g.contarAislados());
		assertTrue(g.esConexo());
		assertTrue(g.contieneCiclos());
		assertEquals(0.88, g.reciprocity(), 0.01);
		assertTrue(1==g.obtenerCentro());
		assertEquals(2, g.getNumberOfReturnNodesWithinCost(1, 2));
		assertEquals(3, g.getNumberOfReturnNodesWithinCost(1, 6));
		assertEquals(1, g.gradoSalida(1));
		assertEquals("(0,1,2,3,4,)", g.accesiblesFromNode(1));
		assertEquals("(0,0,2,3,4,)", g.accesiblesFromNode(2));
		assertEquals("(0,1,0,0,0,)", g.inaccesiblesFromNode(2));
	}
}

