/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cos301rules;

import java.io.IOException;

/**
 *
 * @author Orion
 */
public class COS301Rules {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*
        RuleReader testReader = new RuleReader();
        testReader.iniRules();
        String[] printRulesHolder = testReader.getTokenedRules();
        String outLine = " ";
        
        for(int y = 0; y < printRulesHolder.length; y++){
        outLine += "|"+printRulesHolder[y]+"|";
        }
        System.out.println(outLine);
         */
        RuleBuilder ruleTester = new RuleBuilder();
        ruleTester.ruleParser();
    }
}
