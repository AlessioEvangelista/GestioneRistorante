import static org.junit.Assert.assertEquals;

import org.junit.Test;


import it.unina.ingsw.ristorantegiapponese.entity.*;
import it.unina.ingsw.ristorantegiapponese.control.*;
import it.unina.ingsw.ristorantegiapponese.control.GestoreOrdiniRistorante;

public class TestGestioneOrdini {

	@Test
	public void test01FormulaAllConBevandeUnCoperto() {
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT,1);
		
		Piatto [] piatti = new Piatto[1];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		int [] qtaPiatti = {1};
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(24, prezzoTotale);
	}
	
	@Test
	public void test02FormulaAllConBevandePiuCoperti() {
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(),  new Cameriere(), Formula.ALL_YOU_CAN_EAT, 2);
		
		
		Piatto[] piatti = new Piatto[1];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		int [] qtaPiatti = {1};
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(46, prezzoTotale);
		
	}
	
	@Test
	public void test03FormulaAllConBevandeUnCopertoPiuComande() {
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(),  new Cameriere(), Formula.ALL_YOU_CAN_EAT, 1);
		
		Piatto[] piatti = new Piatto[1];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		int [] qtaPiatti = {1};
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande = {1};
		
		Piatto[] piatti2 = new Piatto[1];
		piatti2[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.GRANCHIO, 1, 5);
		int [] qtaPiatti2 =  {1};
		Bevanda[] bevande2 = new Bevanda[1];
		bevande2[0] = new Bevanda(TipoBevanda.ACQUA_GASSATA, 2);
		int [] qtaBevande2 = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti2, qtaPiatti2, bevande2, qtaBevande2);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(26, prezzoTotale);
		
		
	}
	
	@Test
	public void test04FormulaAllConBevandePiuCopertiPiuComande() {
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(),  new Cameriere(), Formula.ALL_YOU_CAN_EAT, 2);
		
		Piatto[] piatti = new Piatto[1];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		int [] qtaPiatti = {1};
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande = {1};
		
		Piatto[] piatti2 = new Piatto[1];
		piatti2[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.GRANCHIO, 1, 5);
		int [] qtaPiatti2 =  {1};
		Bevanda[] bevande2 = new Bevanda[1];
		bevande2[0] = new Bevanda(TipoBevanda.ACQUA_GASSATA, 2);
		int [] qtaBevande2 = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti2, qtaPiatti2, bevande2, qtaBevande2);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(48, prezzoTotale);
	}
	
	@Test
	public void test05FormulaAllSenzaBevandePiuCopertiPiuComande() {
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(),  new Cameriere(), Formula.ALL_YOU_CAN_EAT, 3);
		
		Piatto[] piatti = new Piatto[1];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		int [] qtaPiatti = {1};
		
		Piatto[] piatti2 = new Piatto[1];
		piatti2[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.GRANCHIO, 1, 5);
		int [] qtaPiatti2 =  {1};
		
		gestore_ord.creaComandaSenzaBevande(conto, piatti, qtaPiatti);
		gestore_ord.creaComandaSenzaBevande(conto, piatti2, qtaPiatti2);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(66, prezzoTotale);
	}
	
	@Test
	public void test06FormulaAllSenzaComandeZeroCoperti() {
		
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(),  new Cameriere(), Formula.ALL_YOU_CAN_EAT, 0);
		
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(0, prezzoTotale);
	}
	
	@Test
	public void test07FormulaAllConBevandeUnCopertoZeroComande() {
		
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(),  new Cameriere(), Formula.ALL_YOU_CAN_EAT, 1);
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande = {1};
		
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(0, prezzoTotale);
	}
	
	@Test
	public void test08FormulaCartaUnCopertoUnaComandaUnPiattoUnaBevanda() {
		
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(),  new Cameriere(), Formula.ALLA_CARTA, 1);
		
		Piatto [] piatti = new Piatto[1];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		int [] qtaPiatti = {1};
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(9, prezzoTotale);
		
	}
	
	@Test
	public void test09FormulaCartaPiuCopertiUnaComandaUnPiattoUnaBevanda() {
		
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 2);
		
		Piatto [] piatti = new Piatto[1];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		int [] qtaPiatti = {1};
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(11, prezzoTotale);
	}
	
	@Test
	public void test10FormulaCartaUnCopertoPiuComande() {
		
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
		
		Piatto [] piatti = new Piatto[1];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		int [] qtaPiatti = {1};
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande = {1};
		Piatto [] piatti2 = new Piatto[1];
		piatti2[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		int [] qtaPiatti2 = {1};
		Bevanda [] bevande2 = new Bevanda[1];
		bevande2[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande2 = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti2, qtaPiatti2, bevande2, qtaBevande2);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(16, prezzoTotale);
	}
	
	@Test
	public void test11FormulaCartaPiuCopertiPiuComande() {
		
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 2);
		
		Piatto [] piatti = new Piatto[1];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		int [] qtaPiatti = {1};
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande = {1};
		Piatto [] piatti2 = new Piatto[1];
		piatti2[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		int [] qtaPiatti2 = {1};
		Bevanda [] bevande2 = new Bevanda[1];
		bevande2[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande2 = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti2, qtaPiatti2, bevande2, qtaBevande2);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(18, prezzoTotale);
	}
	
	@Test
	public void test12FormulaCartaUnCopertoUnaComandaConSalmone() {
		
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
		
		Piatto [] piatti = new Piatto[1];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.SALMONE, 1, 5);
		int [] qtaPiatti = {1};
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(10, prezzoTotale);
	}
	
	@Test
	public void test13FormulaCartaUnCopertoUnaComandaSenzaBevande() {
		
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
		
		Piatto [] piatti = new Piatto[1];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		int [] qtaPiatti = {1};
		
		gestore_ord.creaComandaSenzaBevande(conto, piatti, qtaPiatti);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(7, prezzoTotale);
	}
	
	@Test
	public void test14FormulaCartaUnCopertoUnaComandaSenzaPiatti() {
		
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
		
		Bevanda [] bevande = new Bevanda[1];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		int [] qtaBevande = {1};
		
		gestore_ord.creaComandaSenzaPiatti(conto, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(4, prezzoTotale);
	}
	
	/*@Test
		public void test15SenzaFormulaUnaComandaVuota() {
		
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula., 0));
		
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(0, prezzoTotale);
	} */
	
	@Test
	public void test16FormulaAllPiuCopertiPiuComandeConPiuPiattiPiuBevande() {
		
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 2);
		
		Piatto [] piatti = new Piatto[2];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		piatti[1] = new Piatto(TipoPiatto.SASHIMI, Ingrediente.TONNO, 1, 6);
		int [] qtaPiatti = {2};
		Bevanda [] bevande = new Bevanda[2];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		bevande[1] = new Bevanda(TipoBevanda.BIRRA_GIAPPONESE, 5);
		int [] qtaBevande = {2};
		
		Piatto[] piatti2 = new Piatto[2];
		piatti2[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		piatti2[1] = new Piatto(TipoPiatto.SASHIMI, Ingrediente.TONNO, 1, 6);
		int [] qtaPiatti2 = {2};
		Bevanda [] bevande2 = new Bevanda[2];
		bevande2[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		bevande2[1] = new Bevanda(TipoBevanda.BIRRA_GIAPPONESE, 5);
		int [] qtaBevande2 = {2};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti2, qtaPiatti2, bevande2, qtaBevande2);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(58, prezzoTotale);
	}
	
	@Test
	public void test17FormulaCartaPiuCopertiPiuComandeConPiuPiattiPiuBevande() {
		
		int prezzoTotale;
		
		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 2);
		
		Piatto [] piatti = new Piatto[2];
		piatti[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		piatti[1] = new Piatto(TipoPiatto.SASHIMI, Ingrediente.TONNO, 1, 6);
		int [] qtaPiatti = {2};
		Bevanda [] bevande = new Bevanda[2];
		bevande[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		bevande[1] = new Bevanda(TipoBevanda.BIRRA_GIAPPONESE, 5);
		int [] qtaBevande = {2};
		
		Piatto[] piatti2 = new Piatto[2];
		piatti2[0] = new Piatto(TipoPiatto.SUSHI, Ingrediente.TONNO, 1, 5);
		piatti2[1] = new Piatto(TipoPiatto.SASHIMI, Ingrediente.TONNO, 1, 6);
		int [] qtaPiatti2 = {2};
		Bevanda [] bevande2 = new Bevanda[2];
		bevande2[0] = new Bevanda(TipoBevanda.ACQUA_LISCIA, 2);
		bevande2[1] = new Bevanda(TipoBevanda.BIRRA_GIAPPONESE, 5);
		int [] qtaBevande2 = {2};
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti2, qtaPiatti2, bevande2, qtaBevande2);
		gestore_ord.chiudiConto(conto);
		prezzoTotale = gestore_ord.visualizzaConto(conto);
		assertEquals(76, prezzoTotale);
	}
}	
