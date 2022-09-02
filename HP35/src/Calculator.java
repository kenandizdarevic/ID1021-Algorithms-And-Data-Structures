import java.util.Arrays;

public class Calculator {
    
    Item[] expr;
    int ip;
    Stack stack;

    public Calculator(Item[] expr){
        this.expr = expr;
        this.ip = 0;
        this.stack = new Stack();
    }

    public int run(){
        while(ip < expr.length){
            step();
            System.out.println(Arrays.toString(stack.stackArray));
        }
        return stack.pop();
    }

    public void step(){

        Item nxt = expr[ip++];

        switch(nxt.type()){
            case ADD : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }
            case SUB : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
            }
            case MUL : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
                break;
            }
            case DIV : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                break;
            }
            case VALUE : {
               int toPush = nxt.value();
                stack.push(toPush);
                break;
            }
            case MOD : {
                stack.push(stack.pop() % 10);
                break;
            }
            case SPECMUL : {
                int y = stack.pop() * 2;
                if(y < 10){
                    stack.push(y);
                }
                else stack.push(y - 10 + 1);
                break;
            }
        }
    }   
}
