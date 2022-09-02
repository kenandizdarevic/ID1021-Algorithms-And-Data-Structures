public class Main {
    public static void main(String[] args){
        Item[] idNum = new Item[23];

        Item nb1 = new Item(ItemType.VALUE, 0);
        Item nb2 = new Item(ItemType.VALUE, 2);
        Item nb3 = new Item(ItemType.VALUE, 1);
        Item nb4 = new Item(ItemType.VALUE, 1);
        Item nb5 = new Item(ItemType.VALUE, 0);
        Item nb6 = new Item(ItemType.VALUE, 5);
        Item nb7 = new Item(ItemType.VALUE, 0);
        Item nb8 = new Item(ItemType.VALUE, 0);
        Item nb9 = new Item(ItemType.VALUE, 0);

        Item op = new Item(ItemType.SPECMUL, 0);
        Item add = new Item(ItemType.ADD,0);


        idNum[0]  = nb1;
        idNum[1]  = op;
        idNum[2]  = nb2;
        idNum[3]  = nb3;
        idNum[4]  = op;
        idNum[5]  = nb4;
        idNum[6]  = nb5;
        idNum[7]  = op;
        idNum[8]  = nb6;
        idNum[9]  = nb7;
        idNum[10] = op;
        idNum[11] = nb8;
        idNum[12] = nb9;
        idNum[13] = op;
        idNum[14] = add;
        idNum[15] = add;
        idNum[16] = add;
        idNum[17] = add;
        idNum[18] = add;
        idNum[19] = add;
        idNum[20] = add;
        idNum[21] = add;
        idNum[22] = new Item(ItemType.MOD, 0);

        Calculator TI82 = new Calculator(idNum);
        System.out.println(TI82.run());
       
    }
}
