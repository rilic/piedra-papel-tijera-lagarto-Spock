package edu.tallerweb.pptls;

/** REGLAS DEL JUEGO Y EXPLICACION DE LA SOLUCION */

/**
*Piedra aplasta Lagarto
*Piedra aplasta Tijera
*
*Spock vaporiza Piedra
*Spock destroza Tijera
*
*Papel cubre Piedra
*Papel refuta Spock
*
*Lagarto envenena Spock
*Lagarto come Papel
*
*Tijera corta Papel
*Tijera decapita Lagarto
*/

/**
 * PIEDRA(0), SPOCK(1), PAPEL(2), LAGARTO(3), TIJERA(4);
 */

/**
 * TABLA DOBLE ENTRADA (CADA CELDA INDICA EL GANADOR EN AMBAS DIRECCIONES)
 *
 * 			|	PIEDRA	|	SPOCK	|	PAPEL	|	LAGARTO	|	TIJERA	|
 * _________|___________|___________|___________|___________|___________|
 * 	PIEDRA	|	EMPATA	|	Spock	|	Papel	|	Piedra	|	Piedra	|
 * _________|___________|___________|___________|___________|___________|
 * 	SPOCK	|	Spock	|	EMPATA	|	Papel	|	Lagarto	|	Spock	|
 * _________|___________|___________|___________|___________|___________|
 * 	PAPEL	|	Papel	|	Papel	|	EMPATA	|	Lagarto	|	Tijera	|
 * _________|___________|___________|___________|___________|___________|
 * 	LAGARTO	|	Piedra	|	Lagarto	|	Lagarto	|	EMPATA	|	Tijera	|
 * _________|___________|___________|___________|___________|___________|
 * 	TIJERA	|	Piedra	|	Spock	|	Tijera	|	Tijera	|	EMPATA	|
 * _________|___________|___________|___________|___________|___________|
*/

/**
 * TABLA FILA VS COLUMNA (CADA CELDA INDICA EL RESULTADO DE FILA VS COLUMNA)
 *
 * 			|	PIEDRA	|	SPOCK	|	PAPEL	|	LAGARTO	|	TIJERA	|
 * _________|___________|___________|___________|___________|___________|
 * 	PIEDRA	|	EMPATA	|	PIERDE	|	PIERDE	|	GANA	|	GANA	|
 * _________|___________|___________|___________|___________|___________|
 * 	SPOCK	|	GANA	|	EMPATA	|	PIERDE	|	PIERDE	|	GANA	|
 * _________|___________|___________|___________|___________|___________|
 * 	PAPEL	|	GANA	|	GANA	|	EMPATA	|	PIERDE	|	PIERDE	|
 * _________|___________|___________|___________|___________|___________|
 * 	LAGARTO	|	PIERDE	|	GANA	|	GANA	|	EMPATA	|	PIERDE	|
 * _________|___________|___________|___________|___________|___________|
 * 	TIJERA	|	PIERDE	|	PIERDE	|	GANA	|	GANA	|	EMPATA	|
 * _________|___________|___________|___________|___________|___________|
*/

/**
 * TABLA DOBLE ENTRADA CON VALORES NUMERICOS ASIGNADOS ( PIEDRA=0 SPOCK=1 PAPEL=2 LAGARTO=3 TIJERA=4 )
 *
 * 			|		0	|		1	|		2	|		3	|		4	|
 * _________|___________|___________|___________|___________|___________|
 * 		0	|		-	|		1	|		2	|		0	|		0	|
 * _________|___________|___________|___________|___________|___________|
 * 		1	|		1	|		-	|		2	|		3	|		1	|
 * _________|___________|___________|___________|___________|___________|
 * 		2	|		2	|		2	|		-	|		3	|		4	|
 * _________|___________|___________|___________|___________|___________|
 * 		3	|		0	|		3	|		3	|		-	|		4	|
 * _________|___________|___________|___________|___________|___________|
 * 		4	|		0	|		1	|		4	|		4	|		-	|
 * _________|___________|___________|___________|___________|___________|
*/

/**
 * MATRIZ DE COLUMNAS NUMERICAS Y CELDAS RESULTADO FILA VS COLUMNA (MATRIZ CON LA QUE FUNCIONA EL CODIGO)
 *
 * 			|	0		|	1		|	2		|	3		|	4		|
 * _________|___________|___________|___________|___________|___________|
 * 	0		|	EMPATA	|	PIERDE	|	PIERDE	|	GANA	|	GANA	|
 * _________|___________|___________|___________|___________|___________|
 * 	1		|	GANA	|	EMPATA	|	PIERDE	|	PIERDE	|	GANA	|
 * _________|___________|___________|___________|___________|___________|
 * 	2		|	GANA	|	GANA	|	EMPATA	|	PIERDE	|	PIERDE	|
 * _________|___________|___________|___________|___________|___________|
 * 	3		|	PIERDE	|	GANA	|	GANA	|	EMPATA	|	PIERDE	|
 * _________|___________|___________|___________|___________|___________|
 * 	4		|	PIERDE	|	PIERDE	|	GANA	|	GANA	|	EMPATA	|
 * _________|___________|___________|___________|___________|___________|
*/



/**
 * Representa una de las Manos involucradas en el juego
 */
public class Mano {

	/**
	 * Toda Mano debe crearse con una forma dada, que será
	 * la que determine su condición en el juego.
	 * @param forma, la Forma que adopta la Mano.
	 */

	/** Almacena la forma de la mano actual */
	private Forma forma;

	/** Almacena la matriz con las reglas del juego y sus posibles combinaciones */
	private Resultado matrizReglas[][];

	public Mano(final Forma forma) {
		this.forma = forma;
		this.matrizReglas = new Resultado[][] {
				{ Resultado.EMPATA,	Resultado.PIERDE,	Resultado.PIERDE,	Resultado.GANA,		Resultado.GANA 		},
				{ Resultado.GANA,	Resultado.EMPATA,	Resultado.PIERDE,	Resultado.PIERDE,	Resultado.GANA 		},
				{ Resultado.GANA,	Resultado.GANA,		Resultado.EMPATA,	Resultado.PIERDE,	Resultado.PIERDE 	},
				{ Resultado.PIERDE,	Resultado.GANA,		Resultado.GANA,		Resultado.EMPATA,	Resultado.PIERDE 	},
				{ Resultado.PIERDE,	Resultado.PIERDE,	Resultado.GANA,		Resultado.GANA,		Resultado.EMPATA 	} };

		/** throw new RuntimeException("No implementado aún"); */
	}

	/**
	 * Evaluará el resultado de la partida según las reglas
	 * del juego.
	 * @param otra, la otra Mano.
	 * @return un Resultado, de acuerdo al estado del juego.
	 */

	public Resultado jugarCon(final Mano otra) {

		/** Retorna un valor de los posibles Resultados desde la matriz en base a las formas que se enfrentan en ambas manos */
		return this.matrizReglas[this.forma.getValor()][otra.forma.getValor()];

		/** throw new RuntimeException("No implementado aún"); */
	}

}
