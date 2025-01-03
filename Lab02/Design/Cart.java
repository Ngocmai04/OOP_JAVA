
public class Cart {

    private static final int MAX_NUMBER_ORDER = 20;

    private DigitalVdDisc[] itemOrdered = new DigitalVdDisc[MAX_NUMBER_ORDER];

    private int qtyOrdered;

    public int addDigitalVideoDisc(DigitalVdDisc disc) {
        int addCnt = 0;

        if (qtyOrdered == MAX_NUMBER_ORDER) {
            System.out.println("The cart is full");
        } else {
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The DVD has been added");
            addCnt++;
        }
        return addCnt;
    }

    public void removeDigitalVideoDisc(DigitalVdDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].equals(disc)) {
                found = true;
                // Shift remaining elements down
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemOrdered[j] = itemOrdered[j + 1];
                }
                itemOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("DVD removed");
                break; // Exit loop after removing one instance
            }
        }

        if (!found) {
            System.out.println("No matching DVD found");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemOrdered[i].get_Cost();
        }
        return sum;
    }

    public void print() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < qtyOrdered; i++) {
            output.append(i + 1).append(". [").append(itemOrdered[i].get_Title()).append("] - [")
                    .append(itemOrdered[i].get_Category()).append("] - [")
                    .append(itemOrdered[i].get_Director()).append("] - [")
                    .append(itemOrdered[i].getLength()).append("]: ")
                    .append(itemOrdered[i].get_Cost()).append(" $\n");
        }
        output.append("Total: ").append(totalCost()).append(" $\n");

        System.out.println(output);
    }

    public void searchById(int id) {
        if (id > qtyOrdered || id <= 0) {
            System.out.println("Not found!");
        } else {
            DigitalVdDisc foundDisc = itemOrdered[id - 1];
            System.out.println("Result: [" + foundDisc.get_Title() +
                    "] - [" + foundDisc.get_Category() + "] - ["
                    + foundDisc.get_Director() + "] - ["
                    + foundDisc.getLength() + "]: " + foundDisc.get_Cost() + " $\n");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].get_Title().equalsIgnoreCase(title)) { // Case-insensitive comparison
                System.out.println("Result: [" + itemOrdered[i].get_Title() +
                        "] - [" + itemOrdered[i].get_Category() + "] - ["
                        + itemOrdered[i].get_Director() + "] - ["
                        + itemOrdered[i].getLength() + "]: " + itemOrdered[i].get_Cost() + " $\n");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Not found");
        }
    }
    
}
