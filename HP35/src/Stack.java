

public class Stack {
    int size = 4;
    int[] stackArray = new int[size];
    private int sp = 0;
    int pushed = 0;



    /***
     * Push-macro for the stack
     * @param the value that is to be pushed to the top of the stack
     */
    public void push(int pushed){
        if(sp <= stackArray.length - 1){
            stackArray[sp] = pushed;
            sp++;
        }
        else System.out.println("Stack overflow!");
    }
    /***
     * Pop-macro for the stack
     * @return value popped from the top of the stack
     */
    public int pop(){
        if(sp == stackArray.length)sp--;
        if(sp <= 0) System.out.println("Stack underflow!");
        return stackArray[--sp];
    }
    /***
     * Expands the stack
     */
    public void expand(){
       size = size * 2;
        // set new temporary array whit size * 2 of stackArray
       int[] extendedArray = new int[size];
        
       // fill temporary array with stackArray
        for(int i = 0; i < stackArray.length; i++){
            extendedArray[i] = stackArray[i];
        }
        stackArray = extendedArray;
    }
    /***
     * Shrinks the stack
     */
    public void shrink(){
        System.out.println("Shrunken");
        int shrink = size / 2;
        // set new temporary array
        int[] shrunkenArray = new int[shrink];

        // fill teporary array with stackArray
        for(int i = 0; i < stackArray.length - shrink; i++){
            shrunkenArray[i] = stackArray[i];
        }
        stackArray = shrunkenArray;
    }
    
}