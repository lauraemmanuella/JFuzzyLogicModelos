package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class MandaniQoS {
	public static void main(String[] args) {
		//Carrega arquivo fcl
		FIS fis = FIS.load("src/resource/MandaniQoS.fcl", true);
		
		if (fis == null) {
			System.err.println("Can't load file");
			System.exit(1);
		}

		
		// Mostra todas as varivais linguisticas em grafico
        JFuzzyChart.get().chart(fis.getFunctionBlock("MamdaniQoSFewRules"));
		
	    //Seta as entradas para cada variavel linguistica
        fis.setVariable("commitment", 5); 
	    fis.setVariable("clarity", 5);
	    fis.setVariable("influence", 5);
	    
	    //Avalia as regras
	    fis.evaluate();

	    //Mostra saída em grafico
        Variable biomassa = fis.getFunctionBlock("MamdaniQoSFewRules").getVariable("service_quality");
        JFuzzyChart.get().chart(biomassa, biomassa.getDefuzzifier(), true);
        System.out.println(biomassa.getValue());
	}
}
