package cos301rules;


/**
 *
 * @author user
 */
public class Rule {
    private int ruleNumber = 0;
   
    
    Rule(int toDo){
        ruleNumber = toDo;
    }
        /**
     * Rule list:
     * 1 - Skip till next token := *
     * 2 - Token is till ',' := <Value,,>
     * 3 - Token is till '' := <Value,; >
     * 4 - Token is till '.' := <Value,.>
     * 5 - Token is from end of  last" till ',' := <"R"Value,,>
     * 6 - Token is from end of  last" till ' ' := <"R"Value,,>     * 
     */
    void doRule(){
        if(ruleNumber == 0){
            System.out.append("Init Rule");
            return;
        }
        switch(ruleNumber){
            case 1:{
              skipToken();  
            }
            case 2:{
               getToBreak(); 
            }   
            case 3:{
               getToSpace(); 
            } 
            case 4:{
                getToPoint();
            } 
            case 5:{
                getFromHashToBreak();
            } 
            case 6:{
                getFromHashToPoint();
            }                 
        }        
    }

    private void skipToken() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void getToBreak() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void getToSpace() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void getToPoint() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void getFromHashToBreak() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void getFromHashToPoint() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    @Override
    public String toString(){
     return "Rule Nr: " + ruleNumber;   
    }
}
