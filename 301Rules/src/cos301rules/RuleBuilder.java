/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cos301rules;

import java.io.IOException;

/**
 *
 * @author user
 */
public class RuleBuilder {

    private RuleReader ruleReaders = new RuleReader();
    private Rule[] ruleList = null;
    private String[] valueArray = null;

    /**
     * Rule list:
     * 1 - Skip till next token := *
     * 2 - Token is till ',' := <Value,,>
     * 3 - Token is till '' := <Value,; >
     * 4 - Token is till '.' := <Value,.>
     * 5 - Token is from end of  last" till ',' := <"R"Value,,>
     * 6 - Token is from end of  last" till '.' := <"R"Value,.>     * 
     */
    public void ruleParser() throws IOException {
        ruleReaders.iniRules();
        String[] readedHolder = ruleReaders.getTokenedRules();
        int ruleLeng = readedHolder.length;
        ruleList = new Rule[ruleLeng];

        this.parseValues(ruleLeng, readedHolder);
        this.buildRuleList(readedHolder);

        System.out.println("Rules Parsed");
        this.printRuleSet();
    }

    private void parseValues(int ruleLeng, String[] readedHolder) {
        valueArray = new String[ruleLeng];
        String tmpString = "";

        for (int y = 0; y < ruleLeng; y++) {
            if (readedHolder[y].contains("*")) {
                tmpString = "*";
            } else if (readedHolder[y].contains("\"")) {
                int begin = readedHolder[y].lastIndexOf("\"") + 1;
                int end = 0;
                if (readedHolder[y].contains(",,")) {
                    end = readedHolder[y].lastIndexOf(",") - 1;
                } else {
                    end = readedHolder[y].lastIndexOf(",");
                }
                tmpString = readedHolder[y].substring(begin, end);
            } else {
                int begin = 1;
                int end = readedHolder[y].indexOf(",");
                tmpString = readedHolder[y].substring(begin, end);
            }
            valueArray[y] = tmpString;
        }
    }
    
    public void printRuleSet(){
        StringBuilder returnString = new StringBuilder();
        for(int y = 0; y < ruleList.length;y++){
            returnString.append(" ").append(ruleList[y]);
        }
        System.out.println(returnString.toString());
    }

    private void buildRuleList( String[] readedHolder) {
        for (int y = 0; y < valueArray.length; y++) {
            if(readedHolder[y].contains("*")){
                ruleList[y] = new Rule(1);   
                
            }
           else if(readedHolder[y].contains("\"R")){
                if(readedHolder[y].contains(",.")){
                   ruleList[y] = new Rule(6); 
                }else if(readedHolder[y].contains(",,")){
                   ruleList[y] = new Rule(5); 
                }
                              
            }
           else if(readedHolder[y].contains(",,")){
               ruleList[y] = new Rule(2);
               
           }
           else if(readedHolder[y].contains(",;")){
               ruleList[y] = new Rule(3);
               
           }
           else if(readedHolder[y].contains(",.")){
               ruleList[y] = new Rule(4);
              
           }           

        }
    }
}
