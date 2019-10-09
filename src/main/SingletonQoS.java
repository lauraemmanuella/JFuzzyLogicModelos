package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class SingletonQoS {
	public static void main(String[] args) {
		//Carrega arquivo fcl
		FIS fis = FIS.load("src/resource/SingletonQoS.fcl", true);
		
		if (fis == null) {
			System.err.println("Can't load file");
			System.exit(1);
		}

		
		// Mostra todas as varivais linguisticas em grafico
        JFuzzyChart.get().chart(fis.getFunctionBlock("SingletonQoSFewRules"));
		
	    //Seta as entradas para cada variavel linguistica
        fis.setVariable("commitment", 9); 
	    fis.setVariable("clarity", 9);
	    fis.setVariable("influence", 9);
	    
	    //Avalia as regras
	    fis.evaluate();

	    //Mostra saída em grafico
        Variable biomassa = fis.getFunctionBlock("SingletonQoSFewRules").getVariable("service_quality");
        JFuzzyChart.get().chart(biomassa, biomassa.getDefuzzifier(), true);
        System.out.println(biomassa.getValue());
	}
}
